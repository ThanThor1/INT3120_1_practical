package com.example.unit6_pathway3_project_flight_search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.unit6_pathway3_project_flight_search.application.FlightSearchApplication
import com.example.unit6_pathway3_project_flight_search.data.Airport
import com.example.unit6_pathway3_project_flight_search.data.AirportRepository
import com.example.unit6_pathway3_project_flight_search.data.UserPreferencesRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class FlightSearchViewModel(
    private val airportRepository: AirportRepository,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(FlightSearchUiState())
    val uiState: StateFlow<FlightSearchUiState> = _uiState.asStateFlow()

    init {
        loadFavoriteRoutes()
        restoreState()
    }

    /**
     * Khôi phục trạng thái đã lưu khi mở app
     */
    private fun restoreState() {
        viewModelScope.launch {
            // Đọc search query đã lưu
            userPreferencesRepository.searchQuery.first().let { savedQuery ->
                if (savedQuery.isNotEmpty()) {
                    searchAirports(savedQuery)
                }
            }

            // Đọc selected airport đã lưu
            userPreferencesRepository.selectedAirportCode.first()?.let { savedCode ->
                airportRepository.getAirportByIataCode(savedCode).first()?.let { airport ->
                    _uiState.update {
                        it.copy(
                            selectedAirport = airport,
                            isSearching = false
                        )
                    }
                    loadAvailableFlights(airport.iataCode)
                }
            }
        }
    }

    // Tìm airport theo name hoặc id
    fun searchAirports(query: String) {
        _uiState.update {
            it.copy(
                searchQuery = query,
                isSearching = query.isNotEmpty()
            )
        }

        // Lưu search query vào DataStore
        viewModelScope.launch {
            userPreferencesRepository.saveSearchQuery(query)
        }

        if (query.isEmpty()) {
            _uiState.update {
                it.copy(
                    airportSuggestions = emptyList(),
                    selectedAirport = null,
                    availableFlights = emptyList()
                )
            }
            // Xóa selected airport trong DataStore
            viewModelScope.launch {
                userPreferencesRepository.saveSelectedAirport(null)
            }
            return
        }

        viewModelScope.launch {
            airportRepository.searchAirports(query)
                .catch { _ ->
                    Log.e("FlightSearchVM", "ERROR - Exception caught:")
                    _uiState.update {
                        it.copy(
                            airportSuggestions = emptyList(),
                            isSearching = false
                        )
                    }
                }
                .collect { result ->
                    Log.d("FlightSearchVM", "Received ${result.size} airports from repository")
                    _uiState.update {
                        it.copy(
                            airportSuggestions = result
                        )
                    }
                }
        }
    }

    // Khi người dùng chọn 1 airport
    fun selectAirport(airport: Airport) {
        _uiState.update {
            it.copy(
                selectedAirport = airport,
                airportSuggestions = emptyList(),
                isSearching = false
            )
        }

        // Lưu selected airport vào DataStore
        viewModelScope.launch {
            userPreferencesRepository.saveSelectedAirport(airport.iataCode)
        }

        loadAvailableFlights(airport.iataCode)
    }

    /**
     * Khi user nhấn "sao" để thêm / bỏ yêu thích
     */
    fun toggleFavorite(flight: FlightRoute) {
        viewModelScope.launch {
            val currentlyFavorite = airportRepository
                .isRouteFavorite(flight.departureCode, flight.destinationCode)
                .first()

            if (currentlyFavorite) {
                airportRepository.deleteFavorite(flight.departureCode, flight.destinationCode)
            } else {
                airportRepository.insertFavorite(
                    com.example.unit6_pathway3_project_flight_search.data.Favorite(
                        departureCode = flight.departureCode,
                        destinationCode = flight.destinationCode
                    )
                )
            }

            // Sau khi toggle, reload danh sách
            loadFavoriteRoutes()
            // Chỉ reload available flights nếu đang xem airport đó
            if (_uiState.value.selectedAirport?.iataCode == flight.departureCode) {
                loadAvailableFlights(flight.departureCode)
            }
        }
    }

    /**
     * Load các chuyến bay có thể đi từ một sân bay
     */
    private fun loadAvailableFlights(departureCode: String) {
        viewModelScope.launch {
            combine(
                airportRepository.getDestinationAirports(departureCode),
                airportRepository.getAllFavorites()
            ) { destinations, favorites ->
                destinations.map { dest ->
                    val isFav = favorites.any {
                        it.departureCode == departureCode && it.destinationCode == dest.iataCode
                    }
                    FlightRoute(
                        departureCode = departureCode,
                        departureName = _uiState.value.selectedAirport?.name ?: "",
                        destinationCode = dest.iataCode,
                        destinationName = dest.name,
                        isFavorite = isFav
                    )
                }
            }.collect { routes ->
                _uiState.update { it.copy(availableFlights = routes) }
            }
        }
    }

    /**
     * Load tất cả favorite routes để hiển thị phần "Favorite flights"
     */
    private fun loadFavoriteRoutes() {
        viewModelScope.launch {
            airportRepository.getAllFavorites()
                .collect { favorites ->
                    val favRoutes = favorites.map { fav ->
                        // Lấy thông tin airport cho mỗi favorite
                        val depAirport =
                            airportRepository.getAirportByIataCode(fav.departureCode).first()
                        val destAirport =
                            airportRepository.getAirportByIataCode(fav.destinationCode).first()

                        FlightRoute(
                            departureCode = fav.departureCode,
                            departureName = depAirport?.name ?: fav.departureCode,
                            destinationCode = fav.destinationCode,
                            destinationName = destAirport?.name ?: fav.destinationCode,
                            isFavorite = true
                        )
                    }
                    _uiState.update { it.copy(favoriteRoutes = favRoutes) }
                }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as FlightSearchApplication)
                FlightSearchViewModel(
                    application.container.airportRepository,
                    application.container.userPreferencesRepository
                )
            }
        }
    }
}
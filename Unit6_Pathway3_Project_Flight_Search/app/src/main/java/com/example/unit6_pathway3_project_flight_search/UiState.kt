package com.example.unit6_pathway3_project_flight_search

import com.example.unit6_pathway3_project_flight_search.data.Airport

data class FlightSearchUiState(
    val searchQuery: String = "",
    val airportSuggestions: List<Airport> = emptyList(),
    val selectedAirport: Airport? = null,
    val availableFlights: List<FlightRoute> = emptyList(),
    val favoriteRoutes: List<FlightRoute> = emptyList(),
    val isSearching: Boolean = false
)

data class FlightRoute(
    val departureCode: String,
    val departureName: String,
    val destinationCode: String,
    val destinationName: String,
    val isFavorite: Boolean = false
)
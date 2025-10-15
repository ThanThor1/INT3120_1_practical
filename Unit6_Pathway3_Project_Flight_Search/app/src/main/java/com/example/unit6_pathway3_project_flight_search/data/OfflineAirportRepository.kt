package com.example.unit6_pathway3_project_flight_search.data

import kotlinx.coroutines.flow.Flow

class OfflineAirportRepository(
    private val airportDao: AirportDao,
    private val FavoriteDao: FavoriteDao
) : AirportRepository {

    // Airport
    override fun searchAirports(query: String): Flow<List<Airport>> =
        airportDao.searchAirports(query)

    override fun getAirportByIataCode(iataCode: String): Flow<Airport?> =
        airportDao.getAirportByIataCode(iataCode)

    override fun getDestinationAirports(excludeIataCode: String): Flow<List<Airport>> =
        airportDao.getDestinationAirports(excludeIataCode)

    // Favorite
    override fun getAllFavorites(): Flow<List<Favorite>> =
        FavoriteDao.getAllFavorites()

    override fun isRouteFavorite(departureCode: String, destinationCode: String): Flow<Boolean> =
        FavoriteDao.isRouteFavorite(departureCode, destinationCode)

    override suspend fun insertFavorite(Favorite: Favorite) =
        FavoriteDao.insertFavorite(Favorite)

    override suspend fun deleteFavorite(departureCode: String, destinationCode: String) =
        FavoriteDao.deleteFavorite(departureCode, destinationCode)

}
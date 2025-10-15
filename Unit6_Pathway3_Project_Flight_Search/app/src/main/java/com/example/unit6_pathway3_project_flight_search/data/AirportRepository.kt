package com.example.unit6_pathway3_project_flight_search.data

import kotlinx.coroutines.flow.Flow

interface AirportRepository {

    // Airport
    fun searchAirports(query: String): Flow<List<Airport>>

    fun getAirportByIataCode(iataCode: String): Flow<Airport?>

    fun getDestinationAirports(excludeIataCode: String): Flow<List<Airport>>

    // Favorite
    fun getAllFavorites(): Flow<List<Favorite>>

    fun isRouteFavorite(departureCode: String, destinationCode: String): Flow<Boolean>

    suspend fun insertFavorite(Favorite: Favorite)

    suspend fun deleteFavorite(departureCode: String, destinationCode: String)

}
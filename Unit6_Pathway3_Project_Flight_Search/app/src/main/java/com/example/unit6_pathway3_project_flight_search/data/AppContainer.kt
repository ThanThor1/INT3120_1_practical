package com.example.unit6_pathway3_project_flight_search.data

import android.content.Context

interface AppContainer{
    val airportRepository: AirportRepository
    val userPreferencesRepository: UserPreferencesRepository
}

class AppDataContainer(private val context: Context): AppContainer{
    override val airportRepository: AirportRepository by lazy{
        OfflineAirportRepository(airportDao = AirportDatabase.getDatabase(context).airportDao(),
            FavoriteDao = AirportDatabase.getDatabase(context).FavoriteDao())
    }
    override val userPreferencesRepository: UserPreferencesRepository by lazy {
        UserPreferencesRepository(context)
    }
}
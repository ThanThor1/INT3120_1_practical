package com.example.unit6_pathway3_project_flight_search.application

import android.app.Application
import com.example.unit6_pathway3_project_flight_search.data.AppContainer
import com.example.unit6_pathway3_project_flight_search.data.AppDataContainer


class FlightSearchApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate(){
        super.onCreate()
        container= AppDataContainer(this)
    }
}
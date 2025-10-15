package com.example.unit5_pathway2_practice_amphibians

import android.app.Application

class AmphibianApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
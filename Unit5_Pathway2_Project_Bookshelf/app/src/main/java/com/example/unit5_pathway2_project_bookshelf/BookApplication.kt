
package com.example.unit5_pathway2_project_bookshelf

import android.app.Application

class BookApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
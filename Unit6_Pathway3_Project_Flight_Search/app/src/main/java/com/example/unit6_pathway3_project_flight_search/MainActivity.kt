package com.example.unit6_pathway3_project_flight_search

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.unit6_pathway3_project_flight_search.screens.FlightSearchScreen
import com.example.unit6_pathway3_project_flight_search.ui.theme.Unit6_Pathway3_Project_Flight_SearchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Unit6_Pathway3_Project_Flight_SearchTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FlightSearchScreen()
                }
            }
        }
    }
}
package com.example.myapplication3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // Thay cho main()
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                TutorialScreen() // Gọi UI của bạn
            }
        }
    }
}
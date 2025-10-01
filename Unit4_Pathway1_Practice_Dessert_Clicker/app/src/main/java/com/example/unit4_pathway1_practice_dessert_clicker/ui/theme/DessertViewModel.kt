package com.example.unit4_pathway1_practice_dessert_clicker

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DessertViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DessertUiState())
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()
    fun onDessertClicked(
        desserts: List<Dessert>
    ) {
        // Update the revenue and dessertsSold
        _uiState.value = _uiState.value.copy(
            revenue = _uiState.value.revenue + desserts[_uiState.value.currentDessertIndex].price,
            dessertsSold = _uiState.value.dessertsSold + 1,
        )
        val currentDessertIndexToShow = determineDessertIndexToShow(desserts, _uiState.value.dessertsSold)
        _uiState.value = _uiState.value.copy(
            currentDessertIndex = currentDessertIndexToShow
        )
    }
    fun determineDessertIndexToShow(
        desserts: List<Dessert>,
        dessertsSold: Int
    ): Int {
        var dessertIndex = 0
        for ((index, dessert) in desserts.withIndex()) {
            if (dessertsSold >= dessert.startProductionAmount) {
                dessertIndex = index
            } else {
                break
            }
        }
        return dessertIndex
    }
    fun shareSoldDessertsInformation(intentContext: Context, dessertsSold: Int, revenue: Int) {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(
                Intent.EXTRA_TEXT,
                intentContext.getString(R.string.share_text, dessertsSold, revenue)
            )
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)

        try {
            ContextCompat.startActivity(intentContext, shareIntent, null)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(
                intentContext,
                intentContext.getString(R.string.sharing_not_available),
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
package com.example.lunchtray.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class OrderViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    fun updateSelectedAccompaniment(item: MenuItem.AccompanimentItem) {
        _uiState.value = _uiState.value.copy(
            accompaniment = item
        )
    }

    fun updateSelectedEntree(item: MenuItem.EntreeItem) {
        _uiState.value = _uiState.value.copy(
            entree = item
        )
    }

    fun updateSelectedSideDish(item: MenuItem.SideDishItem) {
        _uiState.value = _uiState.value.copy(
            sideDish = item
        )
    }

    fun resetOrder() {
        _uiState.value = _uiState.value.copy(
            entree = null,
            accompaniment = null,
            sideDish = null,
            itemTotalPrice = 0.0,
            orderTax = 0.0,
            orderTotalPrice = 0.0,
        )
    }
}
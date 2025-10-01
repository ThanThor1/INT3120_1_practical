package com.example.unit4_pathway3_project_my_city.ui.theme

import androidx.lifecycle.ViewModel
import com.example.unit4_pathway3_project_my_city.Category
import com.example.unit4_pathway3_project_my_city.Recommendation
import com.example.unit4_pathway3_project_my_city.ui.theme.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState: StateFlow<MyCityUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = MyCityUiState(
            categories = DataSource.categories
        )
    }

    // Khi user chọn một category
    fun selectCategory(category: Category) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedCategory = category,
                selectedRecommendation = null,
                screen = Screen.Recommendation
            )
        }
    }

    // Khi user chọn một recommendation
    fun selectRecommendation(recommendation: Recommendation) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedRecommendation = recommendation,
                screen = Screen.Detail,
            )
        }
    }

    // Quay lại màn hình trước
    fun navigateBack() {
        _uiState.update { currentState ->
            when (currentState.screen) {

                Screen.Detail -> {
                    currentState.copy(screen = Screen.Recommendation)
                }

                Screen.Recommendation -> {
                    currentState.copy(screen = Screen.Category)
                }

                else -> currentState
            }
        }
    }
    fun navigateToCategory(){
        _uiState.update { currentState ->
            currentState.copy(
                screen = Screen.Category,
                selectedCategory = null,
                selectedRecommendation = null
            )
        }
    }
}

// Data class để lưu trạng thái UI
data class MyCityUiState(
    val categories: List<Category> = emptyList(),
    val selectedCategory: Category? = null,
    val selectedRecommendation: Recommendation? = null,
    val screen: Screen = Screen.Category
)

enum class Screen {
    Category,
    Recommendation,
    Detail,
}
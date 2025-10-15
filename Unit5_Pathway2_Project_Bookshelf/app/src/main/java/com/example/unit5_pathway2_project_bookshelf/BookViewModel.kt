
package com.example.unit5_pathway2_project_bookshelf
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch

class BookViewModel(
    private val bookRepository: BookRepository
) : ViewModel() {

    var bookUiState: BookUiState by mutableStateOf(BookUiState.Loading)
        private set

    init {
        searchBooks("jazz history") // Tìm kiếm mặc định
    }

    fun searchBooks(query: String) {
        viewModelScope.launch {
            bookUiState = BookUiState.Loading
            bookUiState = try {
                val result = bookRepository.searchAndGetBooks(query)
                Log.d("BookViewModel", "Success: ${result.size} books loaded")
                BookUiState.Success(result)
            } catch (e: Exception) {
                Log.e("BookViewModel", "Error: ${e.message}", e)
                BookUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                        as BookApplication)
                val bookRepository = application.container.bookRepository
                BookViewModel(bookRepository = bookRepository)
            }
        }
    }
}
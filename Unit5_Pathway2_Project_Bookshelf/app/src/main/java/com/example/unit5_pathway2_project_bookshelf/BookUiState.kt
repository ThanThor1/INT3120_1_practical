
package com.example.unit5_pathway2_project_bookshelf

sealed interface BookUiState {
    data class Success(val books: List<Book>) : BookUiState
    object Error : BookUiState
    object Loading : BookUiState
}

package com.example.unit5_pathway2_project_bookshelf
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("BookShelf") }
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            val bookViewModel: BookViewModel =
                viewModel(factory = BookViewModel.Factory)

            HomeScreen(
                bookUiState = bookViewModel.bookUiState,
                retryAction = {bookViewModel.searchBooks("jazz")}
            )
        }
    }
}

package com.example.unit5_pathway2_project_bookshelf

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun HomeScreen(
    bookUiState: BookUiState,
    retryAction: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    when (bookUiState) {
        is BookUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is BookUiState.Success -> BookListScreen(
            books = bookUiState.books,
            modifier = modifier.fillMaxWidth()
        )

        is BookUiState.Error -> ErrorScreen(
            retryAction = retryAction,
            modifier = modifier.fillMaxSize()
        )
    }
}

@Composable
fun BookListScreen(
    books: List<Book>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
    ) {
        items(books) { book ->
            AsyncImage(
                model = book.imgUrl.replace("http://", "https://"),
                contentDescription = "Book cover",
                modifier = Modifier.fillMaxHeight(),
                contentScale = ContentScale.Crop,
            )
        }
    }
}


@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorScreen(
    retryAction: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Failed to load", modifier = Modifier.padding(16.dp))
        Button(onClick = { retryAction("jazz history") }) {
            Text(text = "Retry")
        }
    }
}
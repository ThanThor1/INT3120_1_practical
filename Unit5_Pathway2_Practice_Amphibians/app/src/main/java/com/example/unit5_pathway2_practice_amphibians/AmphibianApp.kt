package com.example.unit5_pathway2_practice_amphibians

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibianApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Amphibians",fontSize = 32.sp) }
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            val amphibianViewModel: AmphibianViewModel =
                viewModel(factory = AmphibianViewModel.Factory)

            HomeScreen(
                amphibianUiState = amphibianViewModel.amphibianUiState,
                retryAction = amphibianViewModel::getAmphibians
            )
        }
    }
}

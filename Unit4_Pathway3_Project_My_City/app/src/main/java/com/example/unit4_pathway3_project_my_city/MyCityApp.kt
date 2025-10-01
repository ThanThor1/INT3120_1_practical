package com.example.unit4_pathway3_project_my_city

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unit4_pathway3_project_my_city.ui.theme.MyCityViewModel
import com.example.unit4_pathway3_project_my_city.ui.theme.Screen

enum class ContentType {
    ListOnly, ListAndDetail
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun MyCityApp(
    windowSize: WindowWidthSizeClass
) {
    val viewModel: MyCityViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    val contentType: ContentType = when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            ContentType.ListOnly
        }
        WindowWidthSizeClass.Medium -> {
            ContentType.ListOnly
        }
        WindowWidthSizeClass.Expanded -> {
            ContentType.ListAndDetail
        }
        else -> {
            ContentType.ListOnly
        }
    }

    Scaffold(
        topBar = {
            MyCityAppBar(
                currentScreen = when (uiState.screen) {
                    Screen.Recommendation -> uiState.selectedCategory?.title ?: ""
                    Screen.Category -> "Thành phố Ninh Bình"
                    else -> uiState.selectedRecommendation?.name ?: "Lỗi"
                },
                canNavigateBack = uiState.selectedCategory != null,
                navigateUp = {
                    if (contentType == ContentType.ListAndDetail) {
                        viewModel.navigateToCategory()
                    } else {
                        viewModel.navigateBack()
                    }
                },
            )
        }
    ) { innerPadding ->
        when {
            uiState.screen == Screen.Category && contentType == ContentType.ListOnly-> {
                CategoryListScreen(
                    categories = uiState.categories,
                    onCategoryClick = { category ->
                        viewModel.selectCategory(category)
                    },
                    modifier = Modifier.padding(innerPadding)
                )
            }
            uiState.screen == Screen.Category && contentType == ContentType.ListAndDetail-> {
                CategoryGridScreen(
                    categories = uiState.categories,
                    onCategoryClick = { category ->
                        viewModel.selectCategory(category)
                    },
                    modifier = Modifier.padding(innerPadding)
                )
            }

            uiState.screen == Screen.Recommendation || uiState.screen == Screen.Detail -> {
                if (contentType == ContentType.ListAndDetail && uiState.selectedCategory != null) {
                    RecommendationListAndDetailScreen(
                        category = uiState.selectedCategory!!,
                        selectedRecommendation = uiState.selectedRecommendation,
                        onRecommendationClick = { recommendation ->
                            viewModel.selectRecommendation(recommendation)
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                } else {
                    if (uiState.screen == Screen.Detail && uiState.selectedRecommendation != null) {
                        RecommendationDetailScreen(
                            recommendation = uiState.selectedRecommendation!!,
                            modifier = Modifier.padding(innerPadding)
                        )
                    } else if (uiState.selectedCategory != null) {
                        RecommendationListScreen(
                            category = uiState.selectedCategory!!,
                            onRecommendationClick = { recommendation ->
                                viewModel.selectRecommendation(recommendation)
                            },
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
    currentScreen: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = currentScreen,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}
package com.example.unit4_pathway3_project_my_city

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.TouchApp
import androidx.compose.material3.*

import androidx.compose.ui.Alignment


import androidx.compose.ui.unit.dp
@Composable
fun RecommendationListAndDetailScreen(
    category: Category,
    selectedRecommendation: Recommendation?,
    onRecommendationClick: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxSize()) {

        RecommendationListScreen(
            category = category,
            onRecommendationClick = onRecommendationClick,
            selectedRecommendationId = selectedRecommendation?.id,
            modifier = Modifier
                .weight(0.4f)
                .fillMaxHeight()
        )

        if (selectedRecommendation != null) {
            RecommendationDetailScreen(
                recommendation = selectedRecommendation,
                modifier = Modifier
                    .weight(0.6f)
                    .fillMaxHeight()
            )
        } else {
            Box(
                modifier = Modifier
                    .weight(0.6f)
                    .fillMaxHeight()
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.TouchApp,
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Chọn một địa điểm để xem chi tiết",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}
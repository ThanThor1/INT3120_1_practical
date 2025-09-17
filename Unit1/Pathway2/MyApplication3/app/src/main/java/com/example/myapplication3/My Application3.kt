package com.example.myapplication3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TutorialScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Hàng trên
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            // Góc trên trái
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFFEADDFF))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Text composable",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Displays text and follows the recommended Material Design guidelines.",
                        textAlign = TextAlign.Justify,
                        color = Color.Black
                    )
                }
            }

            // Góc trên phải - Image composable
            Box(
                modifier = Modifier
                    .weight(1f) // 50% chiều rộng
                    .fillMaxHeight()
                    .background(Color(0xFFD0BCFF))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Image composable",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Creates a composable that lays out and draws a given Painter class object.",
                        textAlign = TextAlign.Justify,
                        color = Color.Black
                    )
                }
            }
        }

        // Hàng dưới (50% chiều cao)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // 50% chiều cao
        ) {
            // Góc dưới trái - Row composable
            Box(
                modifier = Modifier
                    .weight(1f) // 50% chiều rộng
                    .fillMaxHeight()
                    .background(Color(0xFFB69DF8))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Row composable",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "A layout composable that places its children in a horizontal sequence.",
                        textAlign = TextAlign.Justify,
                        color = Color.Black
                    )
                }
            }

            // Góc dưới phải - Column composable
            Box(
                modifier = Modifier
                    .weight(1f) // 50% chiều rộng
                    .fillMaxHeight()
                    .background(Color(0xFFF6EDFF))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Column composable",
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "A layout composable that places its children in a vertical sequence.",
                        textAlign = TextAlign.Justify,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuarterScreenLayoutPreview() {
    MaterialTheme {
        TutorialScreen()
    }
}
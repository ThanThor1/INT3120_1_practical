package com.example.unit2_pathway3_project_create_an_art_space_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGalleryApp()
        }
    }
}

@Composable
fun ArtGalleryApp() {
    var currentIndex by remember { mutableIntStateOf(0) }
    val gallery = ArtGallery()
    val currentArt = gallery.getArtPiece(currentIndex)
    val totalCount = gallery.getTotalCount()

    fun goToPrevious() {
        currentIndex = if (currentIndex > 0) {
            currentIndex - 1
        } else {
            totalCount - 1
        }
    }

    fun goToNext() {
        currentIndex = if (currentIndex < totalCount - 1) {
            currentIndex + 1
        } else {
            0
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Frame chứa ảnh tranh với bóng và viền
        Box(
            modifier = Modifier
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(4.dp)
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(16.dp) // Padding tạo viền trắng
        ) {
            Image(
                painter = painterResource(currentArt.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .width(280.dp)  // Nhỏ hơn so với ban đầu
                    .height(320.dp), // Nhỏ hơn so với ban đầu
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Thông tin tranh
        Card(
            modifier = Modifier
                .width(280.dp)
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(8.dp)
                ),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF5F5F5) // Màu xám nhạt như trong hình
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.Start // Căn trái như trong hình
            ) {
                Text(
                    text = currentArt.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${currentArt.artist} (${currentArt.year})",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Nút Previous và Next với styling giống hình
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Button(
                onClick = { goToPrevious() },
                modifier = Modifier
                    .width(120.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5C6BC0) // Màu xanh giống trong hình
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = "Previous",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }

            Button(
                onClick = { goToNext() },
                modifier = Modifier
                    .width(120.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5C6BC0) // Màu xanh giống trong hình
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = "Next",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
        }
    }
}
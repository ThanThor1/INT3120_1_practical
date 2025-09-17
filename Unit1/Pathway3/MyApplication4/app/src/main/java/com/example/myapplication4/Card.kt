package com.example.myapplication4

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF003a3a))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainInfoSection()

        Spacer(modifier = Modifier.height(32.dp))

        ContactInfoSection()
    }
}

@Composable
fun MainInfoSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android Logo",
            modifier = Modifier
                .size(120.dp)
                .background(
                    Color(0xFF000000),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Vũ Xuân Dũng",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = "Android Developer",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3DDC84),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ContactInfoSection() {
    Column{
        ContactItem(
            icon = Icons.Default.Phone,
            text = "+84 836 396 421"
        )
        ContactItem(
            icon = Icons.Default.Email,
            text = "vuxuandungnb2k5@gmail.com"
        )
        ContactItem(
            icon = Icons.Default.Share,
            text = "@DungDev"
        )
    }
}

@Composable
fun ContactItem(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp).
            padding(start = 30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF3DDC84),
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(24.dp))

        Text(
            text = text,
            color = Color.White,
            fontSize = 16.sp
        )
    }
}
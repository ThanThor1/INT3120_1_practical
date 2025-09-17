package com.example.myapplication2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TutorialScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Spacer để tạo khoảng trống trên
        Spacer(modifier = Modifier.weight(1f))

        // Hình ảnh được căn giữa với kích thước cố định
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = "Task completed",
        )

        // Text "All tasks completed" - căn giữa, cỡ chữ 24sp
        Text(
            text = stringResource(R.string.string1),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp,top = 24.dp)
        )

        // Text "Nice work!" - căn giữa
        Text(
            text  = stringResource(R.string.string2),
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        // Spacer để tạo khoảng trống dưới
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun TutorialScreenPreview() {
    MaterialTheme {
        TutorialScreen()
    }
}
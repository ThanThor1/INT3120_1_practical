package com.example.myapplication1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TutorialScreen() {
    // đầu tiên cần tạo lay out
    Column(
    ) {
        // bên trong layout có ảnh
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = "Compose tutorial header",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentScale = ContentScale.FillWidth //
        )

        // cỡ chữ 24, padding full 16dp
        Text(
            text = stringResource(R.string.tutorial_title),
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        // cỡ chữ mặc định nên không có dòng cỡ chữ, padding trên dưới 16 dp,  justify là dòng dài bằng nhau
        Text(
            text = stringResource(R.string.tutorial_description_1),
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Justify
        )

        // cỡ chữ mặc định nên không có dòng cỡ chữ, padding all 16 dp, justify là dòng dài bằng nhau
        Text(
            text = stringResource(R.string.tutorial_description_2),
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TutorialScreenPreview() {
    MaterialTheme {
        TutorialScreen()
    }
}
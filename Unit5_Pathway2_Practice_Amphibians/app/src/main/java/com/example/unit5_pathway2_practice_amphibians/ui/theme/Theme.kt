package com.example.unit5_pathway2_practice_amphibians.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color.Green,     // Xanh lá tươi nhẹ (nổi bật trên nền tối)
    secondary = Color(0xFF388E3C),   // Xanh lá đậm hơn cho điểm nhấn phụ
    tertiary = Color(0xFF81C784),    // Xanh lá nhạt pha chút sáng

    background = Color(0xFF1B5E20),  // Xanh lá rừng đậm (nền chính)
    surface = Color(0xFF2E7D32),     // Nền cho card/view nổi lên
    onPrimary = Color.Black,         // Chữ trên nền primary (tươi sáng)
    onSecondary = Color.White,       // Chữ trên secondary
    onTertiary = Color.Black,        // Chữ trên tertiary
    onBackground = Color(0xFFDDEED9),// Chữ chính trên nền tối (xanh ngà)
    onSurface = Color(0xFFE8F5E9)    // Chữ phụ sáng hơn một chút
)

private val LightColorScheme = lightColorScheme(
    primary = Color.Green,      // Xanh lá đậm (màu chủ đạo)
    secondary = Color(0xFF81C784),    // Xanh lá nhạt, dịu mắt
    tertiary = Color(0xFF4CAF50),     // Xanh tươi trung tính

    background = Color(0xFFF1F8E9),   // Nền sáng có ánh xanh nhạt
    surface = Color(0xFFE8F5E9),      // Nền cho card, nhẹ và tự nhiên

    onPrimary = Color.White,          // Chữ trên nền primary
    onSecondary = Color.Black,        // Chữ trên nền secondary
    onTertiary = Color.White,         // Chữ trên nền tertiary
    onBackground = Color(0xFF1B5E20), // Màu chữ chính, xanh lá đậm
    onSurface = Color(0xFF2E7D32)     // Màu chữ phụ, xanh đậm hơn nền
)

@Composable
fun AmphibiansTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
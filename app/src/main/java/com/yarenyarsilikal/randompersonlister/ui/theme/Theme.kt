package com.yarenyarsilikal.randompersonlister.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColors(
    primary = color100,
    primaryVariant = color200,
    onPrimary = color500,
    secondary = color300,
    secondaryVariant = color400,
    onSecondary = Color.White
)

private val DarkColorPalette = darkColors(
    primary = color600,
    secondary = color700,
    onSecondary = color800,
    surface = color900
)


@Composable
fun RandomPersonListerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
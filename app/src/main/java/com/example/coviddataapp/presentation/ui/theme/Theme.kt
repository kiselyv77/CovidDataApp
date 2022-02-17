package com.example.coviddataapp.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = primaryDark,
    primaryVariant = primaryVariantDark,
    secondary = secondaryDark
)

private val LightColorPalette = lightColors(
    primary = primaryLight,
    primaryVariant = primaryVariantLight,
    secondary = secondaryLight

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun CovidDataAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()
    val colors = if (darkTheme) {
        DarkColorPalette

    } else {
        LightColorPalette
    }
    if(darkTheme){
        systemUiController.setSystemBarsColor(
            color = colors.secondary
        )
    }
    else{
        systemUiController.setSystemBarsColor(
            color = colors.secondary
        )
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
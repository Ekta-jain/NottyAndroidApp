package com.hari.notty.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

private val NottyDarkColorPalette = darkColors(
    primary = NottyBlack,
    primaryVariant = NottyBlack,
    secondary = Blue,
    secondaryVariant = Blue,
    onPrimary = Color.White,
    onSecondary = Color.White,
    background = NottyBlack,
    surface = NottyBlack,
    onSurface = NottyGray,
    onBackground = NottyGray
)

private val NottyLightColorPalette = lightColors(
    primary = Color.White,
    primaryVariant = Color.White,
    secondary = Blue,
    secondaryVariant = Blue,
    background = Color.White,
    surface = Color.White,
    onPrimary = NottyBlack,
    onSecondary = Color.White,
    onBackground = NottyF6,
    onSurface = NottyF6
)

@SuppressLint("NewApi")
@Composable
fun NottyTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val myColorScheme = when {
        isDarkTheme -> NottyDarkColorPalette
        else -> NottyLightColorPalette
    }

    MaterialTheme(
        colors = myColorScheme,
        typography = NottyTypography,
        shapes = NottyShapes
    ) {
        val rippleIndication = rememberRipple()
        CompositionLocalProvider(
            LocalIndication provides rippleIndication,
            content = content
        )
    }
}
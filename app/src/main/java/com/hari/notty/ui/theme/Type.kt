package com.hari.notty.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hari.notty.R

private val ManropeFontFamily = FontFamily(
    Font(R.font.manrope_regular),
    Font(R.font.manrope_light, FontWeight.Light),
    Font(R.font.manrope_medium, FontWeight.Medium),
    Font(R.font.manrope_semi_bold, FontWeight.SemiBold),
    Font(R.font.manrope_bold, FontWeight.Bold)
)

val NottyTypography = Typography(
    h1 = TextStyle(
        fontFamily = ManropeFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 96.sp,
        letterSpacing = (-1.5).sp
    ),
    h2 = TextStyle(
        fontFamily = ManropeFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 60.sp,
        letterSpacing = (-0.5).sp
    ),
    h3 = TextStyle(
        fontFamily = ManropeFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp,
        letterSpacing = 0.sp
    ),
    h4 = TextStyle(
        fontFamily = ManropeFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 34.sp,
        letterSpacing = 0.25.sp
    ),
    h5 = TextStyle(
        fontFamily = ManropeFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        letterSpacing = 0.sp
    ),
    h6 = TextStyle(
        fontFamily = ManropeFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = ManropeFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = ManropeFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.1.sp
    ),
    body1 = TextStyle(
        fontFamily = ManropeFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp
    ),
    body2 = TextStyle(
        fontFamily = ManropeFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp
    ),

    button = TextStyle(
        fontFamily = ManropeFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 1.25.sp
    ),
    caption = TextStyle(
        fontFamily = ManropeFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp
    ),
    overline = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        letterSpacing = 1.5.sp
    )
)
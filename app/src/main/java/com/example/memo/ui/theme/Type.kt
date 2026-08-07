package com.example.memo.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val defaultLetterSpacing = (-0.2).sp

val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = Font.Nunito,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),

    titleLarge = TextStyle(
        fontFamily = Font.Nunito,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = Font.Nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    labelLarge = TextStyle(
        fontFamily = Font.Nunito,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
)

package com.example.memo.ui.theme

import androidx.compose.ui.graphics.Color

data class AppColors(
    val bgColor: Color,

    val textPrimary: Color,
    val textSecondary: Color,
    val textThird: Color,
    val textFourth: Color,
    val textNavigation: Color,

    val iconPrimary: Color,
    val iconSecondary: Color,
//    val iconThird: Color,
//    val iconFourth: Color,

    val btnColor: Color,
//    val btnBlueColor: Color,

//    val borderF8Color: Color,
//    val borderF5Color: Color,
//    val borderD8Color: Color,
//    val borderEaColor: Color,
//    val borderF7Color: Color,

//    val cardColor1: Color,
//    val cardColor2: Color,
//
//    val placeIconColor: Color,
//
//    val errorRed : Color,
//    val promoRed: Color,
//    val warningColor : Color
)

val AppLightColor = AppColors(
    bgColor = Color(0xFFFFFFFF),

    textPrimary = Color(0xFF000000),
    textSecondary = Color(0xFF808080),
    textThird = Color(0xFFC2C2C2),
    textFourth = Color(0xFF212121),
    textNavigation = Color(0xFF989898),

    iconPrimary = Color(0xFF000000),
    iconSecondary = Color(0xFFC2C2C2),

    btnColor = Color(0xFFF5005E)
)

val AppDarkColor = AppColors(
    bgColor = Color(0xFF121212),

    textPrimary = Color(0xFFFFFFFF),
    textSecondary = Color(0xFFB3B3B3),
    textThird = Color(0xFF707070),
    textFourth = Color(0xFFE0E0E0),
    textNavigation = Color(0xFF989898),

    iconPrimary = Color(0xFFFFFFFF),
    iconSecondary = Color(0xFF8A8A8A),

    btnColor = Color(0xFFF5005E)
)
package com.example.memo.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf

object AppTheme {
    val colors: AppColors
        @Composable get() = LocalAppColors.current
}

val LocalAppColors = staticCompositionLocalOf<AppColors> {
    error("No AppColors provided")
}
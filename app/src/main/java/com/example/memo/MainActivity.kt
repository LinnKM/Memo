package com.example.memo

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.memo.core.navigation.AppNavHost
import com.example.memo.modules.home.ui.v.HomePage
import com.example.memo.modules.shared.ui.v.SplashPage
import com.example.memo.modules.test.HomeTestPage
import com.example.memo.modules.welcome.ui.v.WelcomePage
import com.example.memo.ui.theme.MemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()

        super.onCreate(savedInstanceState)
        setContent {
            MemoTheme {
                AppNavHost()
            }
        }
    }
}
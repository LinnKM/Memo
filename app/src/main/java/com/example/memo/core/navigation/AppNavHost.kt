package com.example.memo.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.memo.modules.home.homemain.ui.v.HomeMainPage
import com.example.memo.modules.shared.ui.v.SplashPage
import com.example.memo.modules.welcome.ui.v.WelcomePage
import kotlinx.serialization.Serializable

@Serializable
object NavMain {

    @Serializable
    data object SplashRoute

    @Serializable
    data object WelcomeRoute

    @Serializable
    data object HomeMainRoute
}

@Composable
fun AppNavHost() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavMain.HomeMainRoute
    ) {
        composable<NavMain.SplashRoute> {
            SplashPage(
                onNavigateToWelcome = {
                    navController.navigate(NavMain.WelcomeRoute) {
                        popUpTo(NavMain.SplashRoute) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable<NavMain.WelcomeRoute> {
            WelcomePage(
                onNavigateToHomeMain = {
                    navController.navigate(NavMain.HomeMainRoute) {
                        popUpTo(NavMain.WelcomeRoute) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable<NavMain.HomeMainRoute> {
            HomeMainPage()
        }
    }
}
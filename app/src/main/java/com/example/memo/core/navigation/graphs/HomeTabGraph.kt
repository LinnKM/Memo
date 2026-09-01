package com.example.memo.core.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.memo.modules.home.ui.v.HomePage
import kotlinx.serialization.Serializable

@Serializable
object HomeTabGraph {
    @Serializable
    data object HomeRoute
}


fun NavGraphBuilder.homeTabGraph(navController: NavHostController) {
    navigation<HomeTabGraph>(startDestination = HomeTabGraph.HomeRoute) {
        composable<HomeTabGraph.HomeRoute> {
            HomePage()
        }
    }
}
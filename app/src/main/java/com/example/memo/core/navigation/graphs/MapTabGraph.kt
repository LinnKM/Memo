package com.example.memo.core.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.memo.modules.map.ui.v.MapPage
import kotlinx.serialization.Serializable

@Serializable
object MapTabGraph {
    @Serializable
    data object MapRoute
}

fun NavGraphBuilder.mapTabGraph(navController: NavHostController) {
    navigation<MapTabGraph>(startDestination = MapTabGraph.MapRoute) {
        composable<MapTabGraph.MapRoute> {
            MapPage()
        }
    }
}

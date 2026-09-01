package com.example.memo.core.navigation.graphs

import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

@Serializable
object MemoDetailGraph {
    @Serializable
    data object MemoDetailRoute
}


fun NavGraphBuilder.memoDetailGraph(navController: NavHostController) {
    navigation<MemoDetailGraph>(startDestination = MemoDetailGraph.MemoDetailRoute) {
        composable<MemoDetailGraph.MemoDetailRoute> {
//            MemoDetailPage()
        }
    }
}
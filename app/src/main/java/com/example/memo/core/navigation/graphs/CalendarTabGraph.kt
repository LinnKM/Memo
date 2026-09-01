package com.example.memo.core.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.memo.modules.calendar.ui.v.CalendarPage
import kotlinx.serialization.Serializable

@Serializable
object CalendarTabGraph {
    @Serializable
    data object CalendarRoute
}


fun NavGraphBuilder.calendarTabGraph(navController: NavHostController) {
    navigation<CalendarTabGraph>(startDestination = CalendarTabGraph.CalendarRoute) {
        composable<CalendarTabGraph.CalendarRoute> {
            CalendarPage()
        }
    }
}
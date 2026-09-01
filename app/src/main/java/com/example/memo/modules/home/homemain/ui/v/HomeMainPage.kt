package com.example.memo.modules.home.homemain.ui.v

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.memo.core.extensions.shouldShowBottomBar
import com.example.memo.core.navigation.AppNavigationItem
import com.example.memo.core.navigation.graphs.HomeTabGraph
import com.example.memo.core.navigation.graphs.calendarTabGraph
import com.example.memo.core.navigation.graphs.galleryTabGraph
import com.example.memo.core.navigation.graphs.homeTabGraph
import com.example.memo.core.navigation.graphs.mapTabGraph
import com.example.memo.core.navigation.graphs.memoDetailGraph
import com.example.memo.modules.home.homemain.ui.c.HomeMainNavigationBar
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun HomeMainPage(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val showBottomBar = backStackEntry?.destination.shouldShowBottomBar()

    var selectedItem by rememberSaveable { mutableStateOf(AppNavigationItem.Home) }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            HomeMainNavigationBar(
                onSelect = { selectedItem = it }, selectedItem = selectedItem,
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = HomeTabGraph,
            modifier = modifier.padding(paddingValues)
        ) {
            homeTabGraph(navController)
            calendarTabGraph(navController)
            mapTabGraph(navController)
            galleryTabGraph(navController)

            memoDetailGraph(navController)
        }
    }

}

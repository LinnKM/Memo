package com.example.memo.core.extensions

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import com.example.memo.core.navigation.graphs.CalendarTabGraph
import com.example.memo.core.navigation.graphs.GalleryTabGraph
import com.example.memo.core.navigation.graphs.HomeTabGraph
import com.example.memo.core.navigation.graphs.MapTabGraph
import kotlin.reflect.KClass

private val BOTTOM_BAR_ROUTES: Set<KClass<*>> = setOf(
    HomeTabGraph.HomeRoute::class,
    CalendarTabGraph.CalendarRoute::class,
    MapTabGraph.MapRoute::class,
    GalleryTabGraph.GalleryRoute::class,
)

fun NavDestination?.shouldShowBottomBar(): Boolean {
    if (this == null) return false
    return BOTTOM_BAR_ROUTES.any { route -> this.hasRoute(route) }
}
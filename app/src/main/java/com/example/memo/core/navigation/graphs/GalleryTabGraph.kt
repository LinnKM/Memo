package com.example.memo.core.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.memo.modules.gallery.ui.v.GalleryPage
import kotlinx.serialization.Serializable

@Serializable
object GalleryTabGraph {
    @Serializable
    data object GalleryRoute
}

fun NavGraphBuilder.galleryTabGraph(navController: NavHostController) {
    navigation<GalleryTabGraph>(startDestination = GalleryTabGraph.GalleryRoute) {
        composable<GalleryTabGraph.GalleryRoute> {
            GalleryPage()
        }
    }
}

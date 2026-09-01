package com.example.memo.core.navigation

import androidx.annotation.DrawableRes

import com.example.memo.R

enum class AppNavigationItem(
    val label: String,
    @DrawableRes val icon: Int,
    @DrawableRes val iconFilled: Int,
) {
    Home(
        label = "Home",
        icon = R.drawable.iconsax_home,
        iconFilled = R.drawable.iconsax_homepage_filled,
    ),
    Calendar(
        label = "Calendar",
        icon = R.drawable.iconsax_calendar,
        iconFilled = R.drawable.clip_calendar_filled,
    ),
    Map(
        label = "Map",
        icon = R.drawable.iconsax_map,
        iconFilled = R.drawable.iconsax_map_illed,
    ),
    Gallery(
        label = "Gallery",
        icon = R.drawable.iconsax_gallery_favorite,
        iconFilled = R.drawable.iconsax_gallery_filled,
    ),
}
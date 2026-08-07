package com.example.memo.modules.welcome.data.model

import com.example.memo.R

data class FeatureModel(
    val icon: Int,
    val label: String,
    val content: String
)

val features = listOf(
    FeatureModel(
        icon = R.drawable.iconsax_ai_record_video,
        label = "Save more than photos",
        content = "Turn every picture into a story with notes and memories."
    ),

    FeatureModel(
        icon = R.drawable.iconsax_calendar3,
        label = "Relive Every Moment",
        content = "Browse memories by timeline, calendar, or location."
    ),

    FeatureModel(
        icon = R.drawable.iconsax_heart_circle,
        label = "Keep Memories Forever",
        content = "Your favorite moments stay organized in one beautiful place."
    )
)
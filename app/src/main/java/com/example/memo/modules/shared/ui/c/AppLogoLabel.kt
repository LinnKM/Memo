package com.example.memo.modules.shared.ui.c

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.sp
import com.example.memo.ui.theme.Font
import com.example.memo.ui.theme.Primary

@Composable
fun AppLogoLabel(
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    progress: Float = 1f
) {
    Text(
        "Memo", fontSize = 28.sp,
        color = color,
        fontFamily = Font.GochiHand,
        modifier = modifier.layout { measurable, constraints ->
            val placeable = measurable.measure(constraints)
            val width = (placeable.width * progress).toInt()
            layout(width, placeable.height) {
                placeable.placeRelative(0, 0)
            }
        }.clip(RectangleShape)
    )
}
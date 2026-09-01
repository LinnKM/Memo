package com.example.memo.modules.shared.ui.c

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedAppLogo(
    modifier: Modifier = Modifier,
    onAnimationFinish: () -> Unit = {},
    totalDuration: Int = 2100
) {
    val alpha = remember { Animatable(0f) }
    val bookmarkProgress = remember { Animatable(0f) }
    val heartScale = remember { Animatable(0f) }

    val fadeAnimationDuration = totalDuration * 1000 / 2100
    val bookmarkAnimationDuration = totalDuration * 600 / 2100
    val heartScaleAnimationDuration = totalDuration * 500 / 2100

    LaunchedEffect(Unit) {
        alpha.animateTo(1f, animationSpec = tween(fadeAnimationDuration))
        bookmarkProgress.animateTo(1f, animationSpec = tween(bookmarkAnimationDuration))
        heartScale.animateTo(1f, animationSpec = tween(heartScaleAnimationDuration))
        onAnimationFinish()
    }

    val baseRectPathData =
        "M16,0L40,0A16,16 0,0 1,56 16L56,40A16,16 0,0 1,40 56L16,56A16,16 0,0 1,0 40L0,16A16,16 0,0 1,16 0z"
    val bookmarkPathData =
        "M30.571,0C32.276,0 37,0 37,0C37,0 37,7.531 37,10.25V38.948C37,39.319 36.937,39.683 36.817,40.002C36.698,40.32 36.526,40.581 36.321,40.756C36.116,40.931 35.884,41.014 35.652,40.996C35.419,40.978 35.194,40.86 35.001,40.654L28,36.176L21.001,40.654C20.817,40.849 20.605,40.967 20.385,40.994C20.165,41.021 19.944,40.958 19.744,40.809C19.544,40.661 19.371,40.433 19.242,40.147C19.113,39.861 19.032,39.528 19.008,39.178L19,38.948V10.25C19,7.531 19,0 19,0C19,0 23.724,0 25.429,0H30.571Z"
    val heartPathData =
        "M29.85,24.292C29.096,24.292 28.421,24.658 28,25.221C27.579,24.658 26.904,24.292 26.15,24.292C24.871,24.292 23.833,25.333 23.833,26.621C23.833,27.117 23.913,27.575 24.05,28C24.708,30.083 26.737,31.329 27.742,31.671C27.883,31.721 28.117,31.721 28.258,31.671C29.263,31.329 31.292,30.083 31.95,28C32.088,27.575 32.167,27.117 32.167,26.621C32.167,25.333 31.129,24.292 29.85,24.292Z"

    val baseRectPath = remember { PathParser().parsePathString(baseRectPathData).toPath() }
    val bookmarkPath = remember { PathParser().parsePathString(bookmarkPathData).toPath() }
    val heartPath = remember { PathParser().parsePathString(heartPathData).toPath() }

    Canvas(modifier = modifier.size(56.dp)) {
        val scale = size.width / 56f
        withTransform({
            scale(scale, scale, pivot = Offset.Zero)
        }) {
            // 1. Base rectangle with fade
            drawPath(
                path = baseRectPath,
                color = Color(0xFF222222),
                alpha = alpha.value
            )

            // 2. Pink bookmark from top to bottom
            if (alpha.value > 0f) {
                clipRect(
                    top = 0f,
                    bottom = 41f * bookmarkProgress.value,
                    left = 0f,
                    right = 56f
                ) {
                    drawPath(
                        path = bookmarkPath,
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xFFF5005E), Color(0xFFAD1457)),
                            start = Offset(28f, 0f),
                            end = Offset(28f, 41f)
                        )
                    )
                }
            }

            // 3. Heart icon with scale up
            if (bookmarkProgress.value > 0f) {
                withTransform({
                    scale(heartScale.value, heartScale.value, pivot = Offset(28f, 28f))
                }) {
                    drawPath(
                        path = heartPath,
                        color = Color.White
                    )
                }
            }
        }
    }
}
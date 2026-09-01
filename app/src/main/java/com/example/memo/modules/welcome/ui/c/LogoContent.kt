package com.example.memo.modules.welcome.ui.c

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import androidx.compose.ui.text.font.FontWeight
import com.example.memo.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.memo.core.extensions.heightBox
import com.example.memo.modules.shared.ui.c.AppLogoLabel
import com.example.memo.ui.theme.Primary
@Composable
fun LogoContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest
                .Builder(LocalContext.current)
                .data(R.raw.app_logo)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(56.dp)
        )

        7.heightBox()

        Text(
            "Welcome to", fontSize = 20.sp, fontWeight = FontWeight.Normal,
            color = Color.Black
        )

        AppLogoLabel(color = Primary)
    }
}
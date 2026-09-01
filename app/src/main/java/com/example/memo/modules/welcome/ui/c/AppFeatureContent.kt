package com.example.memo.modules.welcome.ui.c

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.memo.core.extensions.widthBox
import com.example.memo.modules.welcome.data.model.features
import com.example.memo.ui.theme.AppTheme
import com.example.memo.ui.theme.Primary

@Composable
fun AppFeatureContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        repeat(features.size) { index ->
            val feature = features[index]
            FeatureItem(
                label = feature.label,
                content = feature.content,
                icon = feature.icon
            )
        }
    }
}

@Composable
private fun FeatureItem(
    modifier: Modifier = Modifier,
    label: String,
    content: String,
    icon: Int
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .padding(top = 10.dp)
                .size(24.dp),
        )

        10.widthBox()

        Column() {
            Text(
                label, color = Primary,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                content,
                color = AppTheme.colors.textFourth,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
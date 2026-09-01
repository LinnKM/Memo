package com.example.memo.modules.home.homemain.ui.c

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.memo.core.extensions.bounceClick
import com.example.memo.core.extensions.heightBox
import com.example.memo.core.navigation.AppNavigationItem
import com.example.memo.ui.theme.AppTheme


@Composable
fun HomeMainNavigationBar(
    modifier: Modifier = Modifier,
    selectedItem: AppNavigationItem,
    onSelect: (AppNavigationItem) -> Unit,
) {
    NavigationBar(
        windowInsets = NavigationBarDefaults.windowInsets,
        containerColor = AppTheme.colors.bgColor,
//        tonalElevation = 20.dp,
        modifier = modifier
            .dropShadow(
                shape = RectangleShape,
                shadow = Shadow(
                    radius = 17.6.dp,
                    spread = 0.dp,
                    offset = DpOffset(x = 0.dp, y = (-1).dp),
                    color = Color.Black.copy(alpha = 0.1f)
                )
            )
            .fillMaxWidth()
            .height(59.dp + WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding())
    ) {
        AppNavigationItem.entries.forEachIndexed { index, item ->

            val isSelected = selectedItem == item

            Box(
                modifier = Modifier
                    .bounceClick(
                        scaleDown = 0.85f,
                        onClick = {
                            onSelect(item)
                        }
                    )
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painterResource(if (isSelected) item.iconFilled else item.icon),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(20.dp)
                    )

                    4.heightBox()

                    Text(
                        item.label,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Medium,
                        color = if (isSelected) MaterialTheme.colorScheme.primary else AppTheme.colors.textNavigation
                    )
                }
            }

        }
    }
}
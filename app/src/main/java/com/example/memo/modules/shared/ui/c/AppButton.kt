package com.example.memo.modules.shared.ui.c

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.memo.core.extensions.bounceClick
import com.example.memo.ui.theme.OnPrimary
import com.example.memo.ui.theme.Primary

@Composable
fun AppButton(
    text: String,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .bounceClick(
                enabled = enabled && !isLoading,
                onClick = onClick
            )
            .background(
                color = if (enabled) Primary else Color.Gray,
                shape = RoundedCornerShape(30.dp)
            )
            .padding(horizontal = 38.dp, vertical = 11.dp),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(20.dp),
                color = OnPrimary,
                strokeWidth = 2.dp
            )
        } else {
            Text(
                text = text,
                color = OnPrimary,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

package com.example.memo.core.extensions

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val Int.widthBox: @Composable () -> Unit
    get() = {
        Spacer(
            modifier = Modifier.width(this@widthBox.dp)
        )
    }


val Int.heightBox: @Composable () -> Unit
    get() = {
        Spacer(
            modifier = Modifier.height(this@heightBox.dp)
        )
    }
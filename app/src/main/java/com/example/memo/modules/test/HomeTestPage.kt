package com.example.memo.modules.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.memo.R
import com.example.memo.core.extensions.heightBox
import com.example.memo.ui.theme.Font

@Composable
fun HomeTestPage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 17.dp),
    ) {
        TopBar()

        12.heightBox()

        Text("Today", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF808080))

        50.heightBox()

        FreshPageContent()
    }
}

@Composable
private fun TopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppDateLabel()

        Icon(
            painter = painterResource(R.drawable.tabler_icon_menu_2),
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}

@Composable
private fun AppDateLabel() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "20",
            fontFamily = Font.OdibeeSans,
            fontSize = 36.sp,
            color = Color(0xFFF5005E),
        )
        Column() {
            Text(
                "Wed \nAug",
                fontFamily = Font.OdibeeSans,
                fontSize = 16.sp,
                color = Color(0xFF808080),
                lineHeight = 12.sp,
            )
        }
    }
}

@Composable
private fun FreshPageContent() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Icon(
            painter = painterResource(R.drawable.iconsax_note),
            contentDescription = null,
            tint = Color.Unspecified
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "A fresh page",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Every day begins with a blank page. Fill it with \nmoments that matter.",
            color = Color(0xFF808080),
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            "Tap + to create one",
            color = Color(0xFFF5005E),
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp
        )
    }
}
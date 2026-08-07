package com.example.memo.modules.welcome.ui.v

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.memo.R
import com.example.memo.core.extensions.heightBox
import com.example.memo.modules.shared.ui.c.AppButton
import com.example.memo.modules.welcome.ui.c.AppFeatureContent
import com.example.memo.modules.welcome.ui.c.LogoContent

@Composable
fun WelcomePage(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            AsyncImage(
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(R.raw.onboarding_banner)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 50.dp)
            ) {
                LogoContent()

                40.heightBox()

                AppFeatureContent()

                Spacer(modifier = Modifier.weight(1f))

                AppButton(
                    text = "Let's Started",
                    onClick = {
                        // TODO: Navigate to next page
                    }
                )

                27.heightBox()
            }
        }
    }
}

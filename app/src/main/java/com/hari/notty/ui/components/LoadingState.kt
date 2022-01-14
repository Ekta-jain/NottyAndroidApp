package com.hari.notty.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.hari.notty.R
import com.hari.notty.ui.theme.Blue

@Composable
fun LoadingState(
    isLoading: Boolean = true,
    error: Throwable? = null,
    retry: (() -> Unit)? = null
) {
    val loaderComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.error))

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        if (isLoading) {
            LottieAnimation(
                modifier = Modifier.size(80.dp),
                iterations = LottieConstants.IterateForever,
                composition = loaderComposition
            )
        }

        if (error != null) {
            LottieAnimation(
                modifier = Modifier
                    .padding(16.dp)
                    .width(320.dp),
                iterations = LottieConstants.IterateForever,
                composition = composition
            )

            Text(
                text = "Ohh...",
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth(),
                text = "Something went Wrong. Something went Wrong. Something went Wrong. Something went Wrong.",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )

            ExtendedFloatingActionButton(
                modifier = Modifier.padding(10.dp),
                onClick = { retry?.invoke() },
                backgroundColor = Blue,
                text = { Text(text = "Retry") },
                icon = { Icon(imageVector = Icons.Default.Refresh, contentDescription = "Retry") }
            )
        }

    }

}
package com.hari.notty.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.hari.notty.R

@Composable
fun LoadingState() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (loader, errorTitle, errorMessage, retryButton) = createRefs()

        LottieAnimation(
            modifier = Modifier
                .constrainAs(loader) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .size(80.dp),
            iterations = LottieConstants.IterateForever,
            composition = composition
        )

    }

}
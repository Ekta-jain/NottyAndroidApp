package com.hari.notty.ui.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hari.notty.R
import com.hari.notty.ui.destinations.AllNoteScreenDestination
import com.hari.notty.ui.destinations.SplashScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/**
 * Splash Screen Composable
 * @param navigator [DestinationsNavigator]
 */
@Destination
@Composable
fun SplashScreen(
    navigator: DestinationsNavigator
) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        navigator.navigate(AllNoteScreenDestination, builder = {
            popUpTo(SplashScreenDestination.route, popUpToBuilder = {
                inclusive = true
            })
        })
    }
    SplashIcon(scale)
}

@Composable
private fun SplashIcon(scale: Animatable<Float, AnimationVector1D>) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .scale(scale.value)
                .size(150.dp)
        )
    }
}

@Preview()
@Composable
fun SplashScreenPreview() {
    SplashIcon(scale = remember {
        Animatable(1f)
    })
}
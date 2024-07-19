package com.spaigou.wbtechandroidapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.spaigou.wbtechandroidapp.R
import kotlinx.coroutines.delay

@Composable
fun LottieSplashScreen(
    modifier: Modifier = Modifier,
    onAnimationEnd: () -> Unit
) {
    LaunchedEffect(key1 = true) {
        delay(2000L)
        onAnimationEnd()
    }

    val preloaderLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.lottie_animation
        )
    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        LottieAnimation(
            composition = preloaderLottieComposition,
            modifier = modifier,
            iterations = LottieConstants.IterateForever
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LottieSplashScreenPreview() {
    LottieSplashScreen {}
}
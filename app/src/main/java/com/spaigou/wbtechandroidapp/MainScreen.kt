package com.spaigou.wbtechandroidapp

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.spaigou.wbtechandroidapp.ui.theme.BrandColorBackground

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(color = BrandColorBackground)
            .verticalScroll(state = ScrollState(0))
    ) {
        Buttons()
    }
}


package com.spaigou.wbtechandroidapp

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.spaigou.wbtechandroidapp.components.Buttons
import com.spaigou.wbtechandroidapp.components.ChipRow
import com.spaigou.wbtechandroidapp.components.DefaultAvatar
import com.spaigou.wbtechandroidapp.components.EventAvatar
import com.spaigou.wbtechandroidapp.components.ImageBase
import com.spaigou.wbtechandroidapp.components.ProfileAvatar
import com.spaigou.wbtechandroidapp.components.SearchBar

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .verticalScroll(state = ScrollState(0))
    ) {
        Buttons()
        TypographyField()
        ProfileAvatar()
        EventAvatar()
        SearchBar()
        ChipRow()
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}


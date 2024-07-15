package com.spaigou.wbtechandroidapp.lessons

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.spaigou.wbtechandroidapp.components.atoms.Buttons
import com.spaigou.wbtechandroidapp.components.atoms.ChipRow
import com.spaigou.wbtechandroidapp.components.atoms.EventAvatar
import com.spaigou.wbtechandroidapp.components.atoms.ProfileAvatar
import com.spaigou.wbtechandroidapp.components.atoms.SearchBar

@Composable
fun FirstLesson() {
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
    FirstLesson()
}


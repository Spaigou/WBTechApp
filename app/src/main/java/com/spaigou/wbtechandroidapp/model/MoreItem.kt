package com.spaigou.wbtechandroidapp.model

import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavHostController
import com.spaigou.wbtechandroidapp.ui.theme.LocalTypography

data class MoreItem(
    val iconId: Int,
    val title: String,
    val route: String? = null
)

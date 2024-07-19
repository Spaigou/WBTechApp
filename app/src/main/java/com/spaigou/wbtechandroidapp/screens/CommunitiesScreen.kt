package com.spaigou.wbtechandroidapp.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.spaigou.wbtechandroidapp.R
import com.spaigou.wbtechandroidapp.components.appbars.CustomBottomAppBar
import com.spaigou.wbtechandroidapp.components.appbars.CustomTopAppBar
import com.spaigou.wbtechandroidapp.components.atoms.CustomSearchBar

@Composable
fun CommunitiesScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        topBar = {
            CustomTopAppBar(
                title = "Сообщества",
                actionIconId = R.drawable.baseline_add_24
            )
        },
        bottomBar = { CustomBottomAppBar(navController = navController) }
    ) { padding ->
        CustomSearchBar(modifier = Modifier
            .padding(padding)
            .fillMaxWidth())
    }
}
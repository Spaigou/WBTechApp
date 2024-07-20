package com.spaigou.wbtechandroidapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.spaigou.wbtechandroidapp.R
import com.spaigou.wbtechandroidapp.components.Event
import com.spaigou.wbtechandroidapp.components.appbars.CustomBottomAppBar
import com.spaigou.wbtechandroidapp.components.appbars.CustomTopAppBar
import com.spaigou.wbtechandroidapp.mockdata.mockEvents
import com.spaigou.wbtechandroidapp.ui.theme.NeutralWhite

@Composable
fun MyEventsScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    events: List<Event>? = null
) {
    Scaffold(
        modifier = modifier,
        containerColor = NeutralWhite,
        topBar = {
            CustomTopAppBar(
                title = "Мои встречи",
                modifier = Modifier
                    .background(color = NeutralWhite)
                    .padding(horizontal = 8.dp),
                navIconId = R.drawable.up_navigation_button,
                onBackClick = { navController.popBackStack() }
            )
        },
        bottomBar = {
            CustomBottomAppBar(navController = navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        ) {
            val firstPageEvents = events?.filter { !it.isEnded }
            val secondPageEvents = events?.filter { it.isEnded }

            PageWithEvents(
                firstPageEvents = firstPageEvents,
                secondPageEvents = secondPageEvents,
                pageNames = listOf("Запланировано", "Уже прошли")
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyEventsScreenPreview() {
    MyEventsScreen(navController = rememberNavController(), events = mockEvents)
}
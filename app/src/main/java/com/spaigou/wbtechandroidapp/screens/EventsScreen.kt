package com.spaigou.wbtechandroidapp.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.spaigou.wbtechandroidapp.R
import com.spaigou.wbtechandroidapp.components.Event
import com.spaigou.wbtechandroidapp.components.EventCard
import com.spaigou.wbtechandroidapp.components.appbars.CustomBottomAppBar
import com.spaigou.wbtechandroidapp.components.appbars.CustomTopAppBar
import com.spaigou.wbtechandroidapp.components.atoms.CustomSearchBar
import com.spaigou.wbtechandroidapp.mockdata.mockEvents
import com.spaigou.wbtechandroidapp.ui.theme.BrandColorDefault
import com.spaigou.wbtechandroidapp.ui.theme.LocalTypography
import com.spaigou.wbtechandroidapp.ui.theme.NeutralActive
import com.spaigou.wbtechandroidapp.ui.theme.NeutralWhite
import kotlinx.coroutines.launch

@Composable
fun EventsScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Scaffold(
        modifier = modifier,
        containerColor = NeutralWhite,
        topBar = {
            CustomTopAppBar(
                title = "Встречи",
                actionIconId = R.drawable.baseline_add_24,
                modifier = Modifier
                    .background(color = NeutralWhite)
                    .padding(horizontal = 8.dp),
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
            CustomSearchBar(
                modifier = Modifier
                    .fillMaxWidth()
            )
            PageWithEvents(events = mockEvents)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PageWithEvents(modifier: Modifier = Modifier, events: List<Event>? = null) {
    val pageNames = listOf("Все встречи", "Активные")
    val pageCount = pageNames.size
    val pagerState = rememberPagerState(pageCount = { pageCount })
    val coroutineScope = rememberCoroutineScope()
    val selectedPageIndex by remember { derivedStateOf { pagerState.currentPage } }

    TabRow(
        modifier = modifier.padding(bottom = 12.dp),
        selectedTabIndex = selectedPageIndex,
        containerColor = NeutralWhite,
        divider = {},
        indicator = { tabPositions ->
            if (selectedPageIndex < tabPositions.size) {
                TabRowDefaults.SecondaryIndicator(
                    modifier = modifier.tabIndicatorOffset(tabPositions[selectedPageIndex]),
                    color = BrandColorDefault
                )
            }
        },
    ) {
        pageNames.forEachIndexed { index, current ->
            Tab(
                selected = selectedPageIndex == index,
                unselectedContentColor = Color(0xFF666666),
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(
                        text = current.uppercase(),
                        style = LocalTypography.current.bodyText2,
                        color = BrandColorDefault
                    )
                },
            )
        }
    }

    HorizontalPager(state = pagerState) { page ->
        when (page) {
            0 -> ListOfEvents(events = events)

            1 -> {
                val filterEvents = events?.filter { !it.isEnded }
                ListOfEvents(events = filterEvents)
            }
        }
    }
}

@Composable
fun ListOfEvents(modifier: Modifier = Modifier, events: List<Event>? = null) {
    LazyColumn(
        modifier = modifier
    ) {
        events?.let {
            items(events) { event ->
                EventCard(event = event)
            }
        } ?: item {
            Text("No events found", style = LocalTypography.current.bodyText1)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun EventsScreenPreview() {
    EventsScreen(navController = rememberNavController())
}
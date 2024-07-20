package com.spaigou.wbtechandroidapp.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
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
import com.spaigou.wbtechandroidapp.ui.theme.NeutralWhite
import kotlinx.coroutines.launch

@Composable
fun EventsScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    events: List<Event>? = null
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
            val secondPageEvents = events?.filter { !it.isEnded }
            PageWithEvents(
                firstPageEvents = events,
                secondPageEvents = secondPageEvents,
                pageNames = listOf("Все встречи", "Активные")
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PageWithEvents(
    modifier: Modifier = Modifier,
    firstPageEvents: List<Event>? = null,
    secondPageEvents: List<Event>? = null,
    pageNames: List<String>
) {
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
                selectedContentColor = BrandColorDefault,
                unselectedContentColor = Color(0xFF666666),
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(
                        text = current.uppercase(),
                        style = LocalTypography.current.roboto,
                        letterSpacing = TextUnit(1F, TextUnitType.Sp)
                    )
                },
            )
        }
    }

    HorizontalPager(state = pagerState) { page ->
        when (page) {
            0 -> ListOfEvents(events = firstPageEvents)

            1 -> {
                ListOfEvents(events = secondPageEvents)
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
            Text(
                text = "No events found",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                style = LocalTypography.current.heading2,
                textAlign = TextAlign.Center,
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun EventsScreenPreview() {
    EventsScreen(navController = rememberNavController(), events = mockEvents)
}
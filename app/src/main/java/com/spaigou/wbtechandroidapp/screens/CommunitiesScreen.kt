package com.spaigou.wbtechandroidapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.spaigou.wbtechandroidapp.R
import com.spaigou.wbtechandroidapp.components.Community
import com.spaigou.wbtechandroidapp.components.CommunityCard
import com.spaigou.wbtechandroidapp.components.EventCard
import com.spaigou.wbtechandroidapp.components.appbars.CustomBottomAppBar
import com.spaigou.wbtechandroidapp.components.appbars.CustomTopAppBar
import com.spaigou.wbtechandroidapp.components.atoms.CustomSearchBar
import com.spaigou.wbtechandroidapp.mockdata.mockCommunities
import com.spaigou.wbtechandroidapp.ui.theme.LocalTypography
import com.spaigou.wbtechandroidapp.ui.theme.NeutralWhite

@Composable
fun CommunitiesScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Scaffold(
        modifier = modifier,
        containerColor = NeutralWhite,
        topBar = {
            CustomTopAppBar(
                title = "Сообщества",
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
            PageWithCommunities(communities = mockCommunities)
        }
    }
}

@Composable
fun PageWithCommunities(modifier: Modifier = Modifier, communities: List<Community>?) {
    LazyColumn(
        modifier = modifier
    ) {
        communities?.let {
            items(communities) { community ->
                CommunityCard(community = community)
            }
        } ?: item {
            Text(
                text = "No communitites found",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                style = LocalTypography.current.heading2,
                textAlign = TextAlign.Center
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CommunitiesScreenPreview() {
    CommunitiesScreen(navController = rememberNavController())
}

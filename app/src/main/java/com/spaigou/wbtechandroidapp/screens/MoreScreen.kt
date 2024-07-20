package com.spaigou.wbtechandroidapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.spaigou.wbtechandroidapp.R
import com.spaigou.wbtechandroidapp.components.appbars.CustomBottomAppBar
import com.spaigou.wbtechandroidapp.components.appbars.CustomTopAppBar
import com.spaigou.wbtechandroidapp.components.atoms.CustomSearchBar
import com.spaigou.wbtechandroidapp.components.atoms.ProfileAvatar
import com.spaigou.wbtechandroidapp.mockdata.mockCommunities
import com.spaigou.wbtechandroidapp.mockdata.mockUser
import com.spaigou.wbtechandroidapp.model.MoreItem
import com.spaigou.wbtechandroidapp.model.User
import com.spaigou.wbtechandroidapp.model.moreItems
import com.spaigou.wbtechandroidapp.navigation.Route
import com.spaigou.wbtechandroidapp.ui.theme.LocalTypography
import com.spaigou.wbtechandroidapp.ui.theme.NeutralDisabled
import com.spaigou.wbtechandroidapp.ui.theme.NeutralWhite

@Composable
fun MoreScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Scaffold(
        modifier = modifier,
        containerColor = NeutralWhite,
        topBar = {
            CustomTopAppBar(
                title = "Еще",
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
            MoreMenu(navController = navController)
        }
    }
}

@Composable
fun MoreMenu(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            ProfileMenuItem(
                user = mockUser,
                onClick = { navController.navigate(Route.PROFILE_ACCOUNT) })
        }
        itemsIndexed(moreItems) { index, item ->
            MoreMenuItem(
                iconId = item.iconId,
                title = item.title,
                onClick = { item.route?.let { navController.navigate(it) } }
            )
            if (index == 4) {
                HorizontalDivider(
                    color = NeutralDisabled,
                    thickness = 0.dp
                )
            }
        }
    }
}

@Composable
fun ProfileMenuItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    user: User
) {
    Row(
        modifier = modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProfileAvatar(
            imageSize = 24.dp,
            placeholderSize = 50.dp,
            url = user.avatarUrl
        )
        Spacer(Modifier.width(20.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                modifier = Modifier.height(24.dp),
                text = user.name,
                style = LocalTypography.current.bodyText1,
            )
            Text(
                modifier = Modifier.height(24.dp),
                text = user.phoneNumber,
                style = LocalTypography.current.bodyText1,
                color = NeutralDisabled
            )
        }
        Icon(
            modifier = Modifier
                .size(24.dp),
            painter = painterResource(id = R.drawable.right_arrow),
            contentDescription = null
        )
    }
}

@Composable
fun MoreMenuItem(
    modifier: Modifier = Modifier,
    iconId: Int,
    title: String,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .padding(vertical = if (iconId == R.drawable.coffee_cup) 24.dp else 12.dp)
            .fillMaxWidth()
            .height(24.dp)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Icon(
            modifier = Modifier
                .padding(end = 6.dp)
                .size(24.dp),
            painter = painterResource(id = iconId),
            contentDescription = null
        )
        Text(
            text = title,
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
                .weight(1f),
            style = LocalTypography.current.bodyText1
        )
        Icon(
            modifier = Modifier
                .size(24.dp),
            painter = painterResource(id = R.drawable.right_arrow),
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MoreScreenPreview() {
    MoreScreen(navController = rememberNavController())
}

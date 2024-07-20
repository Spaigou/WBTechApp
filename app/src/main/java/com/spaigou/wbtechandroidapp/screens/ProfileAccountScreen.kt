package com.spaigou.wbtechandroidapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.spaigou.wbtechandroidapp.R
import com.spaigou.wbtechandroidapp.components.appbars.CustomBottomAppBar
import com.spaigou.wbtechandroidapp.components.appbars.CustomTopAppBar
import com.spaigou.wbtechandroidapp.components.atoms.ProfileAvatar
import com.spaigou.wbtechandroidapp.components.atoms.SecondaryButton
import com.spaigou.wbtechandroidapp.mockdata.mockEvents
import com.spaigou.wbtechandroidapp.mockdata.mockUser
import com.spaigou.wbtechandroidapp.model.User
import com.spaigou.wbtechandroidapp.ui.theme.LocalTypography
import com.spaigou.wbtechandroidapp.ui.theme.NeutralDisabled
import com.spaigou.wbtechandroidapp.ui.theme.NeutralWhite

@Composable
fun ProfileAccountScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    user: User
) {
    Scaffold(
        modifier = modifier,
        containerColor = NeutralWhite,
        topBar = {
            CustomTopAppBar(
                title = "Профиль",
                modifier = Modifier
                    .background(color = NeutralWhite)
                    .padding(horizontal = 8.dp),
                navIconId = R.drawable.up_navigation_button,
                actionIconId = R.drawable.edit_profile,
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
            LazyColumn(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    ProfileAvatar(
                        imageSize = 112.dp,
                        placeholderSize = 200.dp,
                        modifier = Modifier.padding(bottom = 15.dp),
                        url = user.avatarUrl,
                        radius = 100.dp
                    )
                }
                item {
                    ProfileInfo(user = user)
                }
                item {
                    ProfileSocialMedias()
                }
            }
        }
    }
}

@Composable
fun ProfileInfo(
    modifier: Modifier = Modifier,
    user: User
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = user.name,
            style = LocalTypography.current.heading2,
            lineHeight = 24.sp
        )
        Text(
            modifier = Modifier
                .padding(top = 4.dp, bottom = 35.dp)
                .align(Alignment.CenterHorizontally),
            text = user.phoneNumber,
            style = LocalTypography.current.subheading2,
            lineHeight = 20.sp,
            color = NeutralDisabled
        )
    }
}

@Composable
fun SocialMediaButton(
    modifier: Modifier = Modifier,
    iconId: Int,
    onClick: () -> Unit = {}
) {
    SecondaryButton(onClick = onClick, modifier = modifier) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = "Social Media Button",
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun ProfileSocialMedias(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        SocialMediaButton(iconId = R.drawable.twitter, modifier = Modifier.width(71.67.dp))
        SocialMediaButton(iconId = R.drawable.instagram, modifier = Modifier.width(71.67.dp))
        SocialMediaButton(iconId = R.drawable.linkedin, modifier = Modifier.width(71.67.dp))
        SocialMediaButton(iconId = R.drawable.facebook, modifier = Modifier.width(71.67.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileAccountScreenPreview() {
    ProfileAccountScreen(navController = rememberNavController(), user = mockUser)
}

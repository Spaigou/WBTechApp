package com.spaigou.wbtechandroidapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.spaigou.wbtechandroidapp.mockdata.mockEvents
import com.spaigou.wbtechandroidapp.mockdata.mockUser
import com.spaigou.wbtechandroidapp.screens.CommunitiesScreen
import com.spaigou.wbtechandroidapp.screens.EventDetailsScreen
import com.spaigou.wbtechandroidapp.screens.EventsScreen
import com.spaigou.wbtechandroidapp.screens.LottieSplashScreen
import com.spaigou.wbtechandroidapp.screens.MoreScreen
import com.spaigou.wbtechandroidapp.screens.MyEventsScreen
import com.spaigou.wbtechandroidapp.screens.ProfileAccountScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Route.EVENTS) {
        composable(route = Route.SPLASH) {
            LottieSplashScreen {
                navController.navigate(Route.EVENTS)
            }
        }

        composable(route = Route.EVENTS) {
            EventsScreen(navController = navController, events = mockEvents)
        }

        composable(route = Route.COMMUNITIES) {
            CommunitiesScreen(navController = navController)
        }

        composable(route = Route.MORE) {
            MoreScreen(navController = navController)
        }

        composable(route = Route.PROFILE_ACCOUNT) {
            ProfileAccountScreen(navController = navController, user = mockUser)
        }

        composable(route = Route.EVENT_DETAILS) {
            EventDetailsScreen()
        }

        composable(route = Route.MY_EVENTS) {
            MyEventsScreen(navController = navController, events = mockEvents)
        }
    }
}

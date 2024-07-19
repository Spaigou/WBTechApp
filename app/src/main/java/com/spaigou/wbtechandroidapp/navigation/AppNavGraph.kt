package com.spaigou.wbtechandroidapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.spaigou.wbtechandroidapp.screens.CommunitiesScreen
import com.spaigou.wbtechandroidapp.screens.EventDetailsScreen
import com.spaigou.wbtechandroidapp.screens.EventsScreen
import com.spaigou.wbtechandroidapp.screens.LottieSplashScreen
import com.spaigou.wbtechandroidapp.screens.MoreScreen
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
            EventsScreen(navController = navController)
        }

        composable(route = Route.COMMUNITIES) {
            CommunitiesScreen(navController = navController)
        }

        composable(route = Route.MORE) {
            MoreScreen()
        }

        composable(route = Route.PROFILE_ACCOUNT) {
            ProfileAccountScreen()
        }

        composable(route = Route.EVENT_DETAILS) {
            EventDetailsScreen()
        }
    }
}

package com.spaigou.wbtechandroidapp.components.appbars

import com.spaigou.wbtechandroidapp.R
import com.spaigou.wbtechandroidapp.navigation.Route

sealed class BottomBarStates(
    val route: String,
    val title: String,
    val iconId: Int,
) {
    data object Events : BottomBarStates(
        Route.EVENTS,
        "Встречи",
        R.drawable.coffee_cup
    )

    data object Communities : BottomBarStates(
        Route.COMMUNITIES,
        "Сообщества",
        R.drawable.user_group
    )

    data object More : BottomBarStates(
        Route.MORE,
        "Ещё",
        R.drawable.menu_more
    )

    companion object {
        val navItems = listOf(
            BottomBarStates.Events,
            BottomBarStates.Communities,
            BottomBarStates.More
        )
    }
}
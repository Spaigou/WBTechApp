package com.spaigou.wbtechandroidapp.model

import com.spaigou.wbtechandroidapp.R
import com.spaigou.wbtechandroidapp.navigation.Route

val moreItems = listOf(
    MoreItem(
        iconId = R.drawable.coffee_cup,
        title = "Мои встречи",
        route = Route.MY_EVENTS
    ),
    MoreItem(
        iconId = R.drawable.theme_sun,
        title = "Тема"
    ),
    MoreItem(
        iconId = R.drawable.notification,
        title = "Уведомления"
    ),
    MoreItem(
        iconId = R.drawable.privacy_shield,
        title = "Безопасность"
    ),
    MoreItem(
        iconId = R.drawable.file_memory,
        title = "Память и ресурсы"
    ),
    MoreItem(
        iconId = R.drawable.help_circle,
        title = "Помощь"
    ),
    MoreItem(
        iconId = R.drawable.mail_invite_friend,
        title = "Пригласи друга"
    ),
)
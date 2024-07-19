package com.spaigou.wbtechandroidapp.mockdata

import com.spaigou.wbtechandroidapp.components.Community
import com.spaigou.wbtechandroidapp.components.Event
import java.time.LocalDate

val mockEvents = List(11) {
    val event = Event(
        name = "Developer meeting",
        date = LocalDate.of(2024, 9, 13),
        city = "Москва",
        categoryList = listOf("Python", "Junior", "Moscow"),
        isEnded = false
    )
    if (it % 2 == 0) {
        event.isEnded = true
    }
    event
}

val mockCommunities = List(11) {
    Community(
        name = "Designa",
        visitorsCount = 10000
    )
}

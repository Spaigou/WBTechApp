package com.spaigou.wbtechandroidapp.lessons

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.spaigou.wbtechandroidapp.components.Community
import com.spaigou.wbtechandroidapp.components.CommunityCard
import com.spaigou.wbtechandroidapp.components.Event
import com.spaigou.wbtechandroidapp.components.EventCard
import com.spaigou.wbtechandroidapp.components.VisitorsRow
import com.spaigou.wbtechandroidapp.components.atoms.ProfileAvatar
import java.time.LocalDate

@Composable
fun SecondLesson() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        item {
            val event = Event(
                name = "Developer meeting",
                date = LocalDate.of(2024, 9, 13),
                city = "Москва",
                categoryList = listOf("Python", "Junior", "Moscow")
            )
            EventCard(event)
        }
        item {
            val event = Event(
                name = "Developer meeting",
                date = LocalDate.of(2024, 9, 13),
                city = "Москва",
                categoryList = listOf("Python", "Junior", "Moscow"),
                isEnded = true
            )
            EventCard(event)
        }
        item {
            val images = List(16) { "https://shorturl.at/ng9Tx" }
            VisitorsRow(images)
        }
        item {
            CommunityCard(community = Community("Designa", 10000))
        }
        item {
            CommunityCard(community = Community("Designa", 1000))
        }
        item {
            ProfileAvatar()
            ProfileAvatar(editMode = true)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondLessonPreview() {
    SecondLesson()
}

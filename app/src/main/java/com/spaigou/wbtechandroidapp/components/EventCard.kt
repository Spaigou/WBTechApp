package com.spaigou.wbtechandroidapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.spaigou.wbtechandroidapp.components.atoms.CategoryChip
import com.spaigou.wbtechandroidapp.components.atoms.EventAvatar
import com.spaigou.wbtechandroidapp.ui.theme.LocalTypography
import com.spaigou.wbtechandroidapp.ui.theme.NeutralDisabled
import com.spaigou.wbtechandroidapp.ui.theme.NeutralLine
import com.spaigou.wbtechandroidapp.ui.theme.NeutralWeak
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class Event(
    val name: String,
    val date: LocalDate,
    val city: String,
    val categoryList: List<String>? = null,
    var isEnded: Boolean = false,
    val imageUrl: String? = null,
)

@Composable
fun EventCard(
    event: Event,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        EventAvatar(url = event.imageUrl)
        EventDescription(event)
    }
    HorizontalDivider(
        modifier = Modifier.padding(bottom = 12.dp),
        color = NeutralDisabled,
        thickness = 0.dp
    )
}

@Composable
fun EventDescription(event: Event) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp)
                .height(24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = event.name,
                style = LocalTypography.current.bodyText1
            )
            if (event.isEnded)
                Text(
                    text = "Закончилась",
                    style = LocalTypography.current.metadata2,
                    color = NeutralWeak
                )
        }
        DateAndCityText(event.date, event.city)
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            event.categoryList?.forEach {
                CategoryChip(text = it, modifier = Modifier.padding(vertical = 4.dp))
            }
        }
    }
}

@Composable
fun DateAndCityText(date: LocalDate, city: String) {
    Text(
        modifier = Modifier.height(20.dp),
        text = "${date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))} — $city",
        style = LocalTypography.current.metadata1,
        color = NeutralWeak
    )
}


@Preview(showBackground = true)
@Composable
fun EventCardPreview() {
    Column {
        val event = Event(
            name = "Developer meeting",
            date = LocalDate.of(2024, 9, 13),
            city = "Москва",
            categoryList = listOf("Python", "Junior", "Moscow"),
            isEnded = true
        )
        EventCard(event = event)
    }
}
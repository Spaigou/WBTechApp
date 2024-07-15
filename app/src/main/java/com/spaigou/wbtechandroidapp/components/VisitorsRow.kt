package com.spaigou.wbtechandroidapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.spaigou.wbtechandroidapp.components.atoms.UserAvatar
import com.spaigou.wbtechandroidapp.ui.theme.LocalTypography

@Composable
fun VisitorsRow(
    images: List<String>,
    modifier: Modifier = Modifier,
    overlappingPercentage: Float = 36.8f / 56,
) {
    val overlappingFactor = 1 - overlappingPercentage

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy((-48 * overlappingFactor).dp)
    ) {
        images.take(5).forEachIndexed { index, image ->
            UserAvatar(
                url = image,
                modifier = modifier.zIndex(5 - index.toFloat()),
                isVisitor = true
            )
        }
        if (images.size > 5) {
            Text(
                text = "+${images.size - 5}",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = (48 * overlappingFactor + 14).dp),
                style = LocalTypography.current.bodyText1
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VisitorsRowPreview() {
    LazyRow {
        item {
            val images = List(16) { "https://shorturl.at/ng9Tx" }
            VisitorsRow(images = images)
        }
    }
}


package com.spaigou.wbtechandroidapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.spaigou.wbtechandroidapp.components.atoms.CommunityAvatar
import com.spaigou.wbtechandroidapp.ui.theme.LocalTypography
import com.spaigou.wbtechandroidapp.ui.theme.NeutralDisabled
import com.spaigou.wbtechandroidapp.ui.theme.NeutralLine
import com.spaigou.wbtechandroidapp.ui.theme.NeutralWeak

data class Community(
    val name: String,
    val visitorsCount: Long,
    val imageUrl: String? = null
)

@Composable
fun CommunityCard(
    modifier: Modifier = Modifier,
    community: Community
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        CommunityAvatar(url = community.imageUrl)
        CommunityDescription(community)
    }
    HorizontalDivider(
        modifier = Modifier.padding(bottom = 12.dp),
        color = NeutralDisabled,
        thickness = 0.dp
    )
}

@Composable
fun CommunityDescription(community: Community) {
    Column {
        Text(
            modifier = Modifier.height(24.dp).padding(top = 2.dp),
            text = community.name,
            style = LocalTypography.current.bodyText1
        )
        Text(
            modifier = Modifier.height(20.dp),
            text = "${community.visitorsCount.convertToProperString()} человек",
            style = LocalTypography.current.metadata1,
            color = NeutralWeak
        )
    }
}

fun Long.convertToProperString(): String {
    var result = ""
    val thisString = this.toString()
    val thisLength = thisString.length
    for (i in thisString.indices) {
        if (i != 0 && (thisLength - i) % 3 == 0) result += " "
        result += thisString[i]
    }
    return result
}

@Preview(showBackground = true)
@Composable
fun CommunityCardPreview() {
    CommunityCard(community = Community("Designa", 10000))
}

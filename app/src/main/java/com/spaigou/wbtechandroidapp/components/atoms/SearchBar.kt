package com.spaigou.wbtechandroidapp.components.atoms

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.spaigou.wbtechandroidapp.ui.theme.LocalTypography
import com.spaigou.wbtechandroidapp.ui.theme.NeutralDisabled
import com.spaigou.wbtechandroidapp.ui.theme.NeutralOffWhite
import com.spaigou.wbtechandroidapp.ui.theme.WBTechAndroidAppTheme

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = NeutralOffWhite,
    contentColor: Color = NeutralDisabled,
) {
    var searchText by remember { mutableStateOf("") }

    TextField(
        value = searchText,
        onValueChange = { searchText = it },
        placeholder = {
            Text(
                text = "Поиск",
                color = contentColor,
                style = LocalTypography.current.bodyText1
            )
        },
        leadingIcon = {
            Icon(
                Icons.Filled.Search,
                contentDescription = null,
                tint = contentColor
            )
        },
        modifier = modifier
            .padding(horizontal = 6.dp, vertical = 8.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = backgroundColor,
            unfocusedContainerColor = backgroundColor,
            disabledContainerColor = backgroundColor,
            cursorColor = contentColor,
            focusedIndicatorColor = backgroundColor,
            unfocusedIndicatorColor = backgroundColor,
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    WBTechAndroidAppTheme {
        SearchBar()
    }
}
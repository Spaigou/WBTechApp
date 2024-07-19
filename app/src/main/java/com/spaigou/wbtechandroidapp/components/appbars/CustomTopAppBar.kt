package com.spaigou.wbtechandroidapp.components.appbars

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.spaigou.wbtechandroidapp.R
import com.spaigou.wbtechandroidapp.ui.theme.LocalTypography
import com.spaigou.wbtechandroidapp.ui.theme.NeutralWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    navIconId: Int? = null,
    actionIconId: Int? = null,
    onBackClick: () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = NeutralWhite
        ),
        title = {
            title?.let {
                Text(
                    text = it,
                    style = LocalTypography.current.subheading1
                )
            }
        },
        navigationIcon = {
            navIconId?.let {
                IconButton(onClick = { onBackClick() }) {
                    Icon(
                        painter = painterResource(id = navIconId),
                        contentDescription = "back arrow navigation"
                    )
                }
            }
        },
        actions = {
            actionIconId?.let {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = actionIconId),
                        contentDescription = "action icon"
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CustomTopAppBarPreview(
) {
    CustomTopAppBar(
        title = "Сообщества",
        navIconId = R.drawable.baseline_keyboard_arrow_left_24,
        actionIconId = R.drawable.baseline_add_24
    )
}
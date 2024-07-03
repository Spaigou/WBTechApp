package com.spaigou.wbtechandroidapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.spaigou.wbtechandroidapp.R
import com.spaigou.wbtechandroidapp.ui.theme.WBTechAndroidAppTheme

@Composable
fun UserAvatar(
    modifier: Modifier = Modifier,
    imageResId: Int = R.drawable.profile_avatar,
    contentDescription: String? = null,
    imageSize: Dp = 48.dp,
    placeholderSize: Dp = 48.dp,
    backgroundColor: Color = Color(0xFFF0F0F0),
) {
    Box(
        modifier = modifier
            .size(imageSize)
            .background(color = backgroundColor, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = contentDescription,
            modifier = Modifier.size(placeholderSize)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    WBTechAndroidAppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            UserAvatar()
        }
    }
}

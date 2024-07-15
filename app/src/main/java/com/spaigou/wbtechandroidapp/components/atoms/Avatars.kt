package com.spaigou.wbtechandroidapp.components.atoms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.spaigou.wbtechandroidapp.R
import com.spaigou.wbtechandroidapp.ui.theme.Gradient01
import com.spaigou.wbtechandroidapp.ui.theme.VisitorsColor
import com.spaigou.wbtechandroidapp.ui.theme.WBTechAndroidAppTheme

sealed class UserStatus {
    data object Online : UserStatus()
    data object Offline : UserStatus()
    data object Story : UserStatus()
}

@Composable
fun ImageBase(
    modifier: Modifier = Modifier,
    url: String? = null,
    contentDescription: String? = null,
    placeholderId: Int = R.drawable.event_avatar,
    imageSize: Dp = 56.dp,
    radius: Dp = 16.dp,
    isVisitor: Boolean = false
) {
    Box(
        modifier = modifier
            .padding(4.dp)
            .size(imageSize)
    ) {
        AsyncImage(
            model = url,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .border(
                    BorderStroke(
                        2.dp,
                        if (isVisitor) VisitorsColor
                        else Color.Transparent
                    ),
                    RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(radius)),
            placeholder = painterResource(id = placeholderId),
            error = painterResource(id = placeholderId)
        )
    }
}

@Composable
fun DefaultAvatar(
    modifier: Modifier = Modifier,
    imageResId: Int = R.drawable.profile_avatar,
    contentDescription: String? = null,
    imageSize: Dp = 56.dp,
    placeholderSize: Dp = 100.dp,
    backgroundColor: Color = Color(0xFFF0F0F0),
    editMode: Boolean = false
) {
    Box(
        modifier = modifier
            .padding(4.dp)
            .size(placeholderSize)
            .background(color = backgroundColor, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = contentDescription,
            modifier = Modifier.size(imageSize)
        )
        if (editMode) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_add_circle_24),
                contentDescription = "Update image",
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(placeholderSize * 0.24f)
            )
        }
    }
}

@Composable
fun ProfileAvatar(
    modifier: Modifier = Modifier,
    url: String? = null,
    imageSize: Dp = 100.dp,
    editMode: Boolean = false
) {
    if (url == null) {
        DefaultAvatar(editMode = editMode)
    } else {
        ImageBase(
            modifier = modifier,
            url = url,
            contentDescription = "Profile avatar",
            imageSize = imageSize,
            radius = 50.dp
        )
    }
}

@Composable
fun EventAvatar(
    modifier: Modifier = Modifier, url: String? = null,
    imageSize: Dp = 48.dp,
) {
    ImageBase(
        modifier = modifier,
        url = url,
        imageSize = imageSize,
        contentDescription = "Event avatar",
        placeholderId = R.drawable.event_avatar
    )
}

@Composable
fun CommunityAvatar(
    modifier: Modifier = Modifier, url: String? = null,
    imageSize: Dp = 48.dp,
) {
    ImageBase(
        modifier = modifier,
        url = url,
        imageSize = imageSize,
        contentDescription = "Community avatar",
        placeholderId = R.drawable.community_avatar
    )
}

@Composable
fun UserAvatar(
    modifier: Modifier = Modifier, url: String? = null,
    imageSize: Dp = 48.dp,
    status: UserStatus = UserStatus.Offline,
    isVisitor: Boolean = false
) {
    val newModifier = when (status) {
        UserStatus.Offline -> modifier
        UserStatus.Online -> TODO()
        UserStatus.Story -> modifier.border(
            BorderStroke(2.dp, Gradient01),
            RoundedCornerShape(16.dp)
        )
    }
    ImageBase(
        modifier = newModifier,
        url = url,
        imageSize = imageSize,
        contentDescription = "User avatar",
        placeholderId = R.drawable.user_avatar,
        isVisitor = isVisitor
    )
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    WBTechAndroidAppTheme {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                ProfileAvatar(editMode = true)
            }
            item {
                ProfileAvatar()
            }
            item {
                ProfileAvatar(url = "some url")
            }
            item {
                UserAvatar()
                UserAvatar(status = UserStatus.Story)
            }
        }
    }
}

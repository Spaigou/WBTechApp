package com.spaigou.wbtechandroidapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.spaigou.wbtechandroidapp.ui.theme.BrandColorBackground
import com.spaigou.wbtechandroidapp.ui.theme.BrandColorDark
import com.spaigou.wbtechandroidapp.ui.theme.LocalTypography
import com.spaigou.wbtechandroidapp.ui.theme.WBTechAndroidAppTheme

@Composable
fun CategoryChip(
    text: String,
    modifier: Modifier = Modifier,
    contentColor: Color = BrandColorDark,
    backgroundColor: Color = BrandColorBackground,
    shape: Shape = RoundedCornerShape(40.dp),
    horizontalPadding: Dp = 8.dp,
    verticalPadding: Dp = 2.dp
) {
    Box(
        modifier = modifier
            .background(color = backgroundColor, shape = shape)
            .padding(horizontal = horizontalPadding, vertical = verticalPadding)
    ) {
        Text(
            text = text,
            color = contentColor,
            style = LocalTypography.current.metadata3
        )
    }
}

@Composable
fun ChipRow() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 0.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CategoryChip(text = "Python")
        CategoryChip(text = "Junior")
        CategoryChip(text = "Moscow")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChipRow() {
    WBTechAndroidAppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            ChipRow()
        }
    }
}
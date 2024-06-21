package com.spaigou.wbtechandroidapp

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.spaigou.wbtechandroidapp.ui.theme.LocalTypography
import com.spaigou.wbtechandroidapp.ui.theme.WBTechAndroidAppTheme

@Composable
fun TypographyField() {
    Column {
        Text(
            text = stringResource(R.string.sample_text),
            style = LocalTypography.current.heading1,
            modifier = Modifier
                .padding(12.dp)
        )
        Text(
            text = stringResource(R.string.sample_text),
            style = LocalTypography.current.heading2,
            modifier = Modifier
                .padding(12.dp)
        )
        Text(
            text = stringResource(R.string.sample_text),
            style = LocalTypography.current.subheading1,
            modifier = Modifier
                .padding(12.dp)
        )
        Text(
            text = stringResource(R.string.sample_text),
            style = LocalTypography.current.subheading1,
            modifier = Modifier
                .padding(12.dp)
        )
        Text(
            text = stringResource(R.string.sample_text),
            style = LocalTypography.current.bodyText1,
            modifier = Modifier
                .padding(12.dp)
        )
        Text(
            text = stringResource(R.string.sample_text),
            style = LocalTypography.current.bodyText2,
            modifier = Modifier
                .padding(12.dp)
        )
        Text(
            text = stringResource(R.string.sample_text),
            style = LocalTypography.current.metadata1,
            modifier = Modifier
                .padding(12.dp)
        )
        Text(
            text = stringResource(R.string.sample_text),
            style = LocalTypography.current.metadata2,
            modifier = Modifier
                .padding(12.dp)
        )
        Text(
            text = stringResource(R.string.sample_text),
            style = LocalTypography.current.metadata3,
            modifier = Modifier
                .padding(12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    WBTechAndroidAppTheme {
        MainScreen()
    }
}

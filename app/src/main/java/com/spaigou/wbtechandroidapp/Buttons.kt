package com.spaigou.wbtechandroidapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.spaigou.wbtechandroidapp.ui.theme.BrandColorBackground
import com.spaigou.wbtechandroidapp.ui.theme.BrandColorDark
import com.spaigou.wbtechandroidapp.ui.theme.BrandColorDefault
import com.spaigou.wbtechandroidapp.ui.theme.NeutralSecondaryBG
import com.spaigou.wbtechandroidapp.ui.theme.Violet20
import com.spaigou.wbtechandroidapp.ui.theme.WBTechAndroidAppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Buttons() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val primaryColors: ButtonColors = ButtonDefaults.buttonColors(
            containerColor = BrandColorDefault,
            disabledContainerColor = Violet20,
            contentColor = NeutralSecondaryBG,
            disabledContentColor = NeutralSecondaryBG
        )
        val secondaryColors: ButtonColors = ButtonDefaults.outlinedButtonColors(
            containerColor = BrandColorBackground,
            disabledContainerColor = Violet20,
            contentColor = NeutralSecondaryBG,
            disabledContentColor = NeutralSecondaryBG
        )
        val ghostColors: ButtonColors = ButtonDefaults.textButtonColors(
            containerColor = BrandColorBackground,
            disabledContainerColor = BrandColorBackground,
            contentColor = BrandColorDefault,
            disabledContentColor = Violet20
        )
        Column {
            for (i in 0..2) {
                val enabled = i != 2
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    PrimaryButton(
                        onClick = {},
                        modifier = Modifier.padding(12.dp),
                        colors = primaryColors,
                        content = { Text("Button") },
                        enabled = enabled
                    )
                    SecondaryButton(
                        onClick = {},
                        modifier = Modifier.padding(12.dp),
                        colors = secondaryColors,
                        content = { Text("Button") },
                        enabled = enabled
                    )
                    GhostButton(
                        onClick = {},
                        modifier = Modifier.padding(12.dp),
                        colors = ghostColors,
                        content = { Text("Button") },
                        enabled = enabled
                    )
                }
            }
        }
    }
}


@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = BrandColorDefault,
        disabledContainerColor = Violet20,
        contentColor = NeutralSecondaryBG,
        disabledContentColor = NeutralSecondaryBG
    ),
    content: @Composable (RowScope.() -> Unit)
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState().value

    var isTapped by remember { mutableStateOf(false) }
    val coroutine = rememberCoroutineScope()
    val onClickHandler: () -> Unit = {
        coroutine.launch {
            isTapped = true
            onClick()
            delay(150)
            isTapped = false
        }
    }
    val containerColor = if (isTapped || isPressed) BrandColorDark else colors.containerColor

    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        Button(
            onClick = onClickHandler,
            modifier = modifier,
            enabled = enabled,
            interactionSource = interactionSource,
            colors = ButtonDefaults.buttonColors(
                containerColor = containerColor,
                disabledContainerColor = colors.disabledContainerColor,
                contentColor = colors.contentColor,
                disabledContentColor = colors.disabledContentColor
            ),
            content = content
        )
    }
}

@Composable
fun SecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(
        containerColor = BrandColorBackground,
        disabledContainerColor = BrandColorBackground,
        contentColor = BrandColorDefault,
        disabledContentColor = Violet20
    ),
    content: @Composable (RowScope.() -> Unit)
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState().value

    var isTapped by remember { mutableStateOf(false) }
    val coroutine = rememberCoroutineScope()
    val onClickHandler: () -> Unit = {
        coroutine.launch {
            isTapped = true
            onClick()
            delay(150)
            isTapped = false
        }
    }

    val contentColor = if (isTapped || isPressed) BrandColorDark else BrandColorDefault

    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        OutlinedButton(
            onClick = onClickHandler,
            modifier = modifier,
            enabled = enabled,
            interactionSource = interactionSource,
            border = BorderStroke(width = 1.5.dp, color = if (enabled) contentColor else Violet20),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = colors.containerColor,
                disabledContainerColor = colors.disabledContainerColor,
                contentColor = contentColor,
                disabledContentColor = colors.disabledContentColor
            ),
            content = content
        )
    }
}

@Composable
fun GhostButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.textButtonColors(
        containerColor = BrandColorBackground,
        disabledContainerColor = BrandColorBackground,
        contentColor = BrandColorDefault,
        disabledContentColor = Violet20
    ),
    content: @Composable (RowScope.() -> Unit)
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState().value

    var isTapped by remember { mutableStateOf(false) }
    val coroutine = rememberCoroutineScope()
    val onClickHandler: () -> Unit = {
        coroutine.launch {
            isTapped = true
            onClick()
            delay(150)
            isTapped = false
        }
    }

    val contentColor = if (isTapped || isPressed) BrandColorDark else colors.contentColor

    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        TextButton(
            onClick = onClickHandler,
            enabled = enabled,
            interactionSource = interactionSource,
            colors = ButtonDefaults.buttonColors(
                containerColor = colors.containerColor,
                disabledContainerColor = colors.disabledContainerColor,
                contentColor = contentColor,
                disabledContentColor = colors.disabledContentColor
            ),
            modifier = modifier,
            content = content
        )
    }
}

private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
}

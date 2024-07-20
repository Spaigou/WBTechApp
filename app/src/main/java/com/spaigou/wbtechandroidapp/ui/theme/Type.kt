package com.spaigou.wbtechandroidapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.spaigou.wbtechandroidapp.R


@Immutable
data class MyTypography(
    val heading1: TextStyle,
    val heading2: TextStyle,
    val subheading1: TextStyle,
    val subheading2: TextStyle,
    val bodyText1: TextStyle,
    val bodyText2: TextStyle,
    val metadata1: TextStyle,
    val metadata2: TextStyle,
    val metadata3: TextStyle,
    val roboto: TextStyle
)

val sfProDisplayFontFamily = FontFamily(
    Font(R.font.sf_pro_display_bold, FontWeight.Bold),
    Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold),
    Font(R.font.sf_pro_display_regular, FontWeight.Normal),
)

val robotoFontFamily = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_bold, FontWeight.Bold)
)

val myTypography = MyTypography(
    heading1 = TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 38.19.sp
    ),
    heading2 = TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 28.64.sp
    ),
    subheading1 = TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 30.sp,
    ),
    subheading2 = TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 28.sp,
    ),
    bodyText1 = TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 24.sp,
    ),
    bodyText2 = TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp,
    ),
    metadata1 = TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 20.sp,
    ),
    metadata2 = TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 16.sp,
    ),
    metadata3 = TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp,
        lineHeight = 16.sp,
    ),
    roboto = TextStyle(
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight(500),
        fontSize = 14.sp,
        lineHeight = 24.sp,
    )
)

val LocalTypography = staticCompositionLocalOf {
    myTypography
}

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

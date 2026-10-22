package com.quadrize.projectzomboidcookbook.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.quadrize.projectzomboidcookbook.R

// Set of Material typography styles to start with
@OptIn(ExperimentalTextApi::class)
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    headlineLarge = TextStyle(
        fontSize = 32.sp,
        fontFamily = FontFamily(
            Font(
                resId = R.font.montserrat_font,
                variationSettings = androidx.compose.ui.text.font.FontVariation.Settings(
                    androidx.compose.ui.text.font.FontVariation.Setting("wght", 400F)
                )
            )
        )
    ),
    headlineMedium = TextStyle(
        fontSize = 26.sp,
        fontFamily = FontFamily(
            Font(
                resId = R.font.montserrat_font,
                variationSettings = androidx.compose.ui.text.font.FontVariation.Settings(
                    androidx.compose.ui.text.font.FontVariation.Setting("wght", 400F)
                )
            )
        )
    ),
    headlineSmall = TextStyle(
        fontSize = 22.sp,
        fontFamily = FontFamily(
            Font(
                resId = R.font.montserrat_font,
                variationSettings = androidx.compose.ui.text.font.FontVariation.Settings(
                    androidx.compose.ui.text.font.FontVariation.Setting("wght", 400F)
                )
            )
        )
    )


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
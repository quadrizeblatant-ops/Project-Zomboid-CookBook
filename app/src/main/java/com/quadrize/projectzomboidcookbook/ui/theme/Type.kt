package com.quadrize.projectzomboidcookbook.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
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
        color = Color(0xFFD5D0B8),
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
        color = Color(0xFF667A4E),
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
    titleLarge = TextStyle(
        color = Color(0xFF87A96B),
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
    titleSmall = TextStyle(
        color = Color(0xFFE1E4DC),
        fontSize = 16.sp,
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
        color = Color(0xFFD5D0B8),
        fontSize = 20.sp,
        fontFamily = FontFamily(
            Font(
                resId = R.font.montserrat_font,
                variationSettings = androidx.compose.ui.text.font.FontVariation.Settings(
                    androidx.compose.ui.text.font.FontVariation.Setting("wght", 400F)
                )
            )
        )
    ),

    bodySmall = TextStyle(
        color = Color(0xFFE1E4DC),
        fontSize = 18.sp,
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
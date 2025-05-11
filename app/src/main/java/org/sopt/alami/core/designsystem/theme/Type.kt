package org.sopt.alami.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.sopt.alami.R


val alarmiFontBold = FontFamily(Font(R.font.noto_sans_kr_bold))
val alarmiFontSemiBold = FontFamily(Font(R.font.noto_sans_kr_semibold))
val alarmiFontMedium = FontFamily(Font(R.font.noto_sans_kr_medium))
val alarmiFontRegular = FontFamily(Font(R.font.noto_sans_kr_regular))

@Immutable
data class alarmiTypography(
    //Title
    val title01b88: TextStyle,
    val title02b30: TextStyle,
    val title03b22: TextStyle,
    val title04b18: TextStyle,
    val title05b13: TextStyle,

    //Body
    val body01b15: TextStyle,
    val body02b12: TextStyle,
    val body03sb12: TextStyle,
    val body04m13: TextStyle,
    val body05r15: TextStyle,
    val body06r14: TextStyle,

    //Caption
    val caption01r13: TextStyle,
    val caption02r11: TextStyle,
    val caption03r10: TextStyle,

    )

val defaultAlarmiTypography = alarmiTypography(
    title01b88 = TextStyle(
        fontFamily = alarmiFontBold,
        fontSize = 88.sp,
        lineHeight = 120.sp,
        letterSpacing = 0.sp
    ),
    title02b30 = TextStyle(
        fontFamily = alarmiFontBold,
        fontSize = 30.sp,
        lineHeight = 100.sp,
        letterSpacing = -2.sp
    ),
    title03b22 = TextStyle(
        fontFamily = alarmiFontBold,
        fontSize = 22.sp,
        lineHeight = 150.sp,
        letterSpacing = -4.sp
    ),
    title04b18 = TextStyle(
        fontFamily = alarmiFontBold,
        fontSize = 18.sp,
        lineHeight = 120.sp,
        letterSpacing = -0.sp
    ),
    title05b13 = TextStyle(
        fontFamily = alarmiFontBold,
        fontSize = 13.sp,
        lineHeight = 150.sp,
        letterSpacing = -4.sp
    ),

//Body
    body01b15 = TextStyle(
        fontFamily = alarmiFontBold,
        fontSize = 15.sp,
        lineHeight = 120.sp,
        letterSpacing = -2.sp
    ),
    body02b12 = TextStyle(
        fontFamily = alarmiFontBold,
        fontSize = 12.sp,
        lineHeight = 120.sp,
        letterSpacing = -12.sp
    ),
    body03sb12 = TextStyle(
        fontFamily = alarmiFontSemiBold,
        fontSize = 12.sp,
        lineHeight = 120.sp,
        letterSpacing = -2.sp
    ),
    body04m13 = TextStyle(
        fontFamily = alarmiFontMedium,
        fontSize = 13.sp,
        lineHeight = 120.sp,
        letterSpacing = 0.sp
    ),
    body05r15 = TextStyle(
        fontFamily = alarmiFontRegular,
        fontSize = 15.sp,
        lineHeight = 120.sp,
        letterSpacing = -5.sp
    ),
    body06r14 = TextStyle(
        fontFamily = alarmiFontRegular,
        fontSize = 14.sp,
        lineHeight = 120.sp,
        letterSpacing = -12.sp
    ),

//Caption
    caption01r13 = TextStyle(
        fontFamily = alarmiFontRegular,
        fontSize = 13.sp,
        lineHeight = 150.sp,
        letterSpacing = -4.sp
    ),
    caption02r11 = TextStyle(
        fontFamily = alarmiFontRegular,
        fontSize = 11.sp,
        lineHeight = 150.sp,
        letterSpacing = -5.sp
    ),
    caption03r10 = TextStyle(
        fontFamily = alarmiFontRegular,
        fontSize = 10.sp,
        lineHeight = 150.sp,
        letterSpacing = -9.sp
    )

)

val localAlarmiTypographyProvider = staticCompositionLocalOf { defaultAlarmiTypography }


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
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

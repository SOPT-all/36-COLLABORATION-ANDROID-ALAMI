package org.sopt.alami.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import org.sopt.alami.R

val alarmiFontBold = FontFamily(Font(R.font.noto_sans_kr_bold))
val alarmiFontSemiBold = FontFamily(Font(R.font.noto_sans_kr_semibold))
val alarmiFontMedium = FontFamily(Font(R.font.noto_sans_kr_medium))
val alarmiFontRegular = FontFamily(Font(R.font.noto_sans_kr_regular))

@Immutable
data class alarmiTypography(
    // Title
    val title01b88: TextStyle,
    val title02b30: TextStyle,
    val title03b22: TextStyle,
    val title04b18: TextStyle,
    val title05b13: TextStyle,

    // Body
    val body01b15: TextStyle,
    val body02b12: TextStyle,
    val body03sb12: TextStyle,
    val body04m13: TextStyle,
    val body05r15: TextStyle,
    val body06r14: TextStyle,

    // Caption
    val caption01r13: TextStyle,
    val caption02r11: TextStyle,
    val caption03r10: TextStyle

)

private fun AlarmiTextStyle(
    fontFamily: FontFamily,
    fontSize: TextUnit,
    lineHeight: TextUnit,
    letterSpacing: TextUnit
): TextStyle = TextStyle(
    fontFamily = fontFamily,
    fontSize = fontSize,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing,
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None
    )
)

val defaultAlarmiTypography = alarmiTypography(
    title01b88 = AlarmiTextStyle(
        fontFamily = alarmiFontBold,
        fontSize = 88.sp,
        lineHeight = 1.45.em,
        letterSpacing = (-0.02).em
    ),
    title02b30 = AlarmiTextStyle(
        fontFamily = alarmiFontBold,
        fontSize = 30.sp,
        lineHeight = 1.45.em,
        letterSpacing = (-0.02).em
    ),
    title03b22 = AlarmiTextStyle(
        fontFamily = alarmiFontBold,
        fontSize = 22.sp,
        lineHeight = 1.45.em,
        letterSpacing = (-0.02).em
    ),
    title04b18 = AlarmiTextStyle(
        fontFamily = alarmiFontBold,
        fontSize = 18.sp,
        lineHeight = 1.45.em,
        letterSpacing = (-0.02).em
    ),
    title05b13 = AlarmiTextStyle(
        fontFamily = alarmiFontBold,
        fontSize = 13.sp,
        lineHeight = 1.45.em,
        letterSpacing = (-0.02).em
    ),

    body01b15 = AlarmiTextStyle(
        fontFamily = alarmiFontBold,
        fontSize = 15.sp,
        lineHeight = 1.45.em,
        letterSpacing = (-0.02).em
    ),
    body02b12 = AlarmiTextStyle(
        fontFamily = alarmiFontBold,
        fontSize = 12.sp,
        lineHeight = 1.45.em,
        letterSpacing = (-0.02).em
    ),
    body03sb12 = AlarmiTextStyle(
        fontFamily = alarmiFontSemiBold,
        fontSize = 12.sp,
        lineHeight = 1.45.em,
        letterSpacing = (-0.02).em
    ),
    body04m13 = AlarmiTextStyle(
        fontFamily = alarmiFontMedium,
        fontSize = 13.sp,
        lineHeight = 1.45.em,
        letterSpacing = (-0.02).em
    ),
    body05r15 = AlarmiTextStyle(
        fontFamily = alarmiFontRegular,
        fontSize = 15.sp,
        lineHeight = 1.45.em,
        letterSpacing = (-0.02).em
    ),
    body06r14 = AlarmiTextStyle(
        fontFamily = alarmiFontRegular,
        fontSize = 14.sp,
        lineHeight = 1.45.em,
        letterSpacing = (-0.02).em
    ),

    caption01r13 = AlarmiTextStyle(
        fontFamily = alarmiFontRegular,
        fontSize = 13.sp,
        lineHeight = 1.45.em,
        letterSpacing = (-0.02).em
    ),
    caption02r11 = AlarmiTextStyle(
        fontFamily = alarmiFontRegular,
        fontSize = 11.sp,
        lineHeight = 1.45.em,
        letterSpacing = (-0.02).em
    ),
    caption03r10 = AlarmiTextStyle(
        fontFamily = alarmiFontRegular,
        fontSize = 10.sp,
        lineHeight = 1.45.em,
        letterSpacing = (-0.02).em
    )
)

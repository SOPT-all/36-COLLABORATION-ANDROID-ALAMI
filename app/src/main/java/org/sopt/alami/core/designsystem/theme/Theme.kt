package org.sopt.alami.core.designsystem.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/**
 * CompositionLocal 선언을 Theme.kt로 이동
 *
 * 1. 이전에는 Color.kt와 Type.kt에 분산되어 있던 CompositionLocal을 한 곳으로 통합
 * 2. 'Provider' 네이밍 제거
 */
private val LocalAlarmiColors = staticCompositionLocalOf<alarmiColors> {
    error("No AlarmiColors provided")
}

private val LocalAlarmiTypography = staticCompositionLocalOf<alarmiTypography> {
    error("No AlarmiTypography provided")
}

private val DarkColorScheme = darkColorScheme(
    primary = white,
    background = black,

)

// alarmiTheme -> AlarmiTheme
object AlarmiTheme {
    val colors: alarmiColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAlarmiColors.current

    val typography: alarmiTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalAlarmiTypography.current
}

// Provider -> Provide
@Composable
fun ProvideAlarmiColorsAndTypography(
    colors: alarmiColors,
    typography: alarmiTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalAlarmiColors provides colors,
        LocalAlarmiTypography provides typography,
        content = content
    )
}

// 여기있던 중복함수 제거함

@Composable
fun AlamiTheme(
    content: @Composable () -> Unit,
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.run {
                WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = false
            }
        }
    }

    ProvideAlarmiColorsAndTypography(
        colors = defaultAlarmiColors,
        typography = defaultAlarmiTypography,
    ) {
        MaterialTheme(
            colorScheme = DarkColorScheme,
            content = content
        )
    }
}

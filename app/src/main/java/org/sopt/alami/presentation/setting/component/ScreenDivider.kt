package org.sopt.alami.presentation.setting.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.alami.core.designsystem.theme.AlamiTheme
import org.sopt.alami.core.designsystem.theme.AlarmiTheme

@Composable
fun ScreenDivider() {
    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth(),
        thickness = 8.dp,
        color = AlarmiTheme.colors.black

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewsdivider() {
    AlamiTheme {
        ScreenDivider()
    }
}

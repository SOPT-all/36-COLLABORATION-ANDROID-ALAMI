package org.sopt.alami.presentation.setting.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.alami.core.designsystem.theme.AlamiTheme
import org.sopt.alami.core.designsystem.theme.AlarmiTheme

@Composable
fun ScreenDivider(

) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(8.dp)
            .background(color = AlarmiTheme.colors.black)
    ) {
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewsdivider() {
    AlamiTheme {
        ScreenDivider()
    }
}

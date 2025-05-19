package org.sopt.alami.presentation.setting.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.alami.core.designsystem.theme.AlamiTheme
import org.sopt.alami.core.designsystem.theme.AlarmiTheme

@Composable
fun SelectBox(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier
            .width(316.dp)
            .height(50.dp)
            .background(color = AlarmiTheme.colors.grey700)
            .clip(RoundedCornerShape(10.dp))
    ) { }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewselectbox() {
    AlamiTheme {
        SelectBox()
    }
}

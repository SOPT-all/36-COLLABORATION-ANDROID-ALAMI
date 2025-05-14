package org.sopt.alami.presentation.morning.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.sopt.alami.core.designsystem.theme.AlarmiTheme

@Composable
fun MorningSurface(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(20.dp),
    content: @Composable () -> Unit = {}
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(AlarmiTheme.colors.grey900.copy(alpha = 0.5f))
            .padding(paddingValues),
        color = Color.Transparent
    ) {
        content()
    }
}

package org.sopt.alami.presentation.setting.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.alami.core.designsystem.theme.AlarmiTheme

@Composable
fun FloatingAlamiButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val alamiColors = AlarmiTheme.colors

    val backgroundColor = if (isPressed) {
        alamiColors.redSecondary
    } else {
        alamiColors.redPrimary
    }

    val contentColor = if (isPressed) {
        alamiColors.redThird
    } else {
        alamiColors.white
    }

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        color = backgroundColor,
        shadowElevation = 6.dp,
        onClick = onClick,
        interactionSource = interactionSource
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                style = AlarmiTheme.typography.body01b15,
                color = contentColor
            )
        }
    }
}

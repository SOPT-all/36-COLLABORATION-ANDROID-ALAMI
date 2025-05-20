package org.sopt.alami.presentation.setting.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.alami.R
import org.sopt.alami.core.designsystem.theme.AlamiTheme
import org.sopt.alami.core.designsystem.theme.AlarmiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SoundProgress(
    currentPosition: Float,
    onSeek: (Float) -> Unit,
    onValueChangeFinished: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(color = AlarmiTheme.colors.grey800)
            .padding(horizontal = 22.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_mute_on),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Slider(
            value = currentPosition,
            onValueChange = onSeek,
            onValueChangeFinished = onValueChangeFinished,
            valueRange = 0f..15f,
            modifier = Modifier.weight(1f),
            colors = SliderDefaults.colors(
                thumbColor = AlarmiTheme.colors.bluePrimary,
                activeTrackColor = AlarmiTheme.colors.bluePrimary,
                inactiveTrackColor = AlarmiTheme.colors.grey600,
                activeTickColor = AlarmiTheme.colors.bluePrimary,
                inactiveTickColor = AlarmiTheme.colors.grey600
            ),
            thumb = {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(AlarmiTheme.colors.bluePrimary)
                )
            },
            track = { sliderState ->
                SliderDefaults.Track(
                    sliderState = sliderState,
                    modifier = Modifier.height(4.dp),
                    colors = SliderDefaults.colors(
                        activeTrackColor = AlarmiTheme.colors.bluePrimary,
                        inactiveTrackColor = AlarmiTheme.colors.grey600
                    )
                )
            }
        )

        Spacer(modifier = Modifier.width(12.dp))

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_mute_off),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_vibe),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSoundProgress() {
    var volume by remember { mutableFloatStateOf(7.5f) }

    AlamiTheme {
        SoundProgress(
            currentPosition = volume,
            onSeek = { volume = it }
        )
    }
}
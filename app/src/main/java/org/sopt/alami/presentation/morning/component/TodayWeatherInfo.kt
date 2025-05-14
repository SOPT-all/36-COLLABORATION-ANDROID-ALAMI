package org.sopt.alami.presentation.morning.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.sopt.alami.R
import org.sopt.alami.core.designsystem.theme.AlarmiTheme
import org.sopt.alami.presentation.morning.model.WeatherType

@Composable
fun TodayWeatherInfo(
    currentDate: String,
    temperature: Int,
    modifier: Modifier = Modifier,
    weatherType: WeatherType = WeatherType.SUNNY
) {
    val weatherIcon = remember(weatherType) {
        when (weatherType) {
            WeatherType.SUNNY -> R.drawable.ic_morning_sun_32
            WeatherType.RAINY -> R.drawable.ic_morning_rain_32
            WeatherType.CLOUDY -> R.drawable.ic_morning_cloud_32
            WeatherType.OVERCAST -> R.drawable.ic_morning_cloud_32
        }
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = currentDate,
            style = AlarmiTheme.typography.body04m13,
            color = AlarmiTheme.colors.white
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "$temperature°C",
            style = AlarmiTheme.typography.title02b30,
            color = AlarmiTheme.colors.white
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = ImageVector.vectorResource(id = weatherIcon),
                tint = Color.Unspecified,
                contentDescription = null
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_morning_arrow_right_16),
                tint = AlarmiTheme.colors.white,
                contentDescription = null
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .clip(CircleShape)
                .background(AlarmiTheme.colors.grey900.copy(alpha = 0.5f))
                .padding(horizontal = 11.dp, vertical = 7.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_location_12),
                tint = AlarmiTheme.colors.white,
                contentDescription = null
            )
            Text(
                text = "정확한 위치:  꺼짐",
                style = AlarmiTheme.typography.body02b12,
                color = AlarmiTheme.colors.white
            )
        }
    }
}

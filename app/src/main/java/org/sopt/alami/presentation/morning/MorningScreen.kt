package org.sopt.alami.presentation.morning

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.sopt.alami.R
import org.sopt.alami.core.designsystem.theme.AlarmiTheme
import org.sopt.alami.presentation.morning.component.MorningSurface
import org.sopt.alami.presentation.morning.component.TodaySentence
import org.sopt.alami.presentation.morning.component.TodayWeatherInfo
import org.sopt.alami.presentation.morning.model.WeatherType

@Composable
fun MorningScreen(
    paddingValues: PaddingValues,
    temperature: Int,
    currentDate: String,
    weatherType: WeatherType,
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Image(
            painter = painterResource(id = R.drawable.morning_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(62.dp))

            TodayWeatherInfo(
                currentDate = currentDate,
                temperature = temperature,
                weatherType = weatherType
            )

            Spacer(modifier = Modifier.height(28.dp))

            TodaySentence(imageUrl = imageUrl)

            Spacer(modifier = Modifier.height(12.dp))

            TodayFeeling()

            Spacer(modifier = Modifier.height(12.dp))

            TodayFortune()

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
private fun TodayFeeling(modifier: Modifier = Modifier) {
    MorningSurface(
        modifier = modifier,
        paddingValues = PaddingValues(horizontal = 22.dp, vertical = 24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().background(Color.Unspecified),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "아침 기분",
                style = AlarmiTheme.typography.body01b15,
                color = AlarmiTheme.colors.white

            )
            Spacer(modifier = Modifier.weight(1f))

            Icon(
                painter = painterResource(id = R.drawable.ic_morning_mood_24),
                tint = Color.Unspecified,
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(16.dp))

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_morning_arrow_right_16),
                tint = Color.Unspecified,
                contentDescription = null
            )
        }
    }
}

@Composable
private fun TodayFortune(modifier: Modifier = Modifier) {
    MorningSurface(
        modifier = modifier,
        paddingValues = PaddingValues(22.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(9.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "별자리 운세",
                    style = AlarmiTheme.typography.body01b15,
                    color = AlarmiTheme.colors.white
                )
                Icon(
                    imageVector = ImageVector.vectorResource(
                        id = R.drawable.ic_morning_arrow_right_16
                    ),
                    tint = Color.Unspecified,
                    contentDescription = null
                )
            }

            Text(
                text = "별자리로 알아보는 오늘 나의 하루!",
                style = AlarmiTheme.typography.body05r15,
                color = AlarmiTheme.colors.grey300
            )

            Text(
                text = "당신의 생일을 알려주세요",
                style = AlarmiTheme.typography.caption02r11,
                color = AlarmiTheme.colors.grey400
            )
        }
    }
}

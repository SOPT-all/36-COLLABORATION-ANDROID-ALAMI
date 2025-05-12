package org.sopt.alami.presentation.alarmdismiss

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.sopt.alami.R
import org.sopt.alami.core.designsystem.component.AlamiButton
import org.sopt.alami.core.designsystem.theme.AlarmiTheme
import org.sopt.alami.core.util.noRippleClickable
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun AlarmDismissRoute(
    paddingValues: PaddingValues,
    navigateToHome: () -> Unit,
) {
    AlarmDismissScreen(
        paddingValues = paddingValues,
        onAlarmDismissClick = navigateToHome
    )
}

@Composable
private fun AlarmDismissScreen(
    paddingValues: PaddingValues,
    onAlarmDismissClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val now = LocalDateTime.now()
    val dayFormatter = DateTimeFormatter.ofPattern("M월 d일 E요일", Locale.KOREAN)
    val timeFormatter = DateTimeFormatter.ofPattern("H:mm", Locale.KOREAN)
    val currentDate = now.format(dayFormatter)
    val currentTime = now.format(timeFormatter)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Image(
            painter = painterResource(id = R.drawable.dismiss_alarm_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(0.5f))

            Text(
                text = currentDate,
                style = AlarmiTheme.typography.title04b18,
                color = AlarmiTheme.colors.white
            )
            Text(
                text = currentTime,
                style = AlarmiTheme.typography.title01b88,
                color = AlarmiTheme.colors.white
            )

            Spacer(modifier = Modifier.weight(0.5f))

            SnoozeButton(
                remainingTime = "3번",
                onClick = {},
            )

            Spacer(modifier = Modifier.weight(1f))

            AlamiButton(
                text = "알람 끄기",
                onClick = onAlarmDismissClick,
                verticalPadding = 24.dp,
                modifier = Modifier.padding(horizontal = 30.dp)
            )

            Spacer(modifier = Modifier.height(42.dp))
        }
    }
}

@Composable
private fun SnoozeButton(
    remainingTime: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(AlarmiTheme.colors.grey100)
            .noRippleClickable(onClick = onClick)
            .padding(horizontal = 11.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(AlarmiTheme.colors.black)
                .padding(horizontal = 7.dp, vertical = 3.dp),
            text = remainingTime,
            style = AlarmiTheme.typography.body03sb12,
            color = AlarmiTheme.colors.white
        )

        Text(
            text = "알람 미루기",
            style = AlarmiTheme.typography.body05r15,
            color = AlarmiTheme.colors.black
        )
    }
}

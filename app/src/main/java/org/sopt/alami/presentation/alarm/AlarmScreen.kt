package org.sopt.alami.presentation.alarm

import android.R.attr.data
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.collections.immutable.persistentListOf
import org.sopt.alami.R
import org.sopt.alami.core.designsystem.theme.AlamiTheme
import org.sopt.alami.core.designsystem.theme.AlarmiTheme
import org.sopt.alami.presentation.alarm.component.AddAlarmButton
import org.sopt.alami.presentation.alarm.component.AlarmCard
import org.sopt.alami.presentation.alarm.component.AlarmSurface
import org.sopt.alami.presentation.alarm.model.AlarmCardState
import org.sopt.alami.presentation.alarm.model.AlarmTime
import org.sopt.alami.presentation.alarm.model.DayType
import org.sopt.alami.presentation.alarm.model.MeridiemType
import org.sopt.alami.presentation.alarm.model.getTimeUntilAlarm
import org.sopt.alami.presentation.alarm.viewmodel.AlarmViewModel

@Composable
fun AlarmRoute(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    )
    AlarmScreen(paddingValues, onClick = {})

    AddAlarmButton(onClicked = {})
}

@Composable
fun AlarmScreen(
    paddingValues: PaddingValues,
    onClick: () -> Unit,
    viewModel: AlarmViewModel = hiltViewModel()
) {
    val alarmState = AlarmCardState(
        selectedDays = persistentListOf(DayType.SATURDAY, DayType.WEDNESDAY),
        meridiem = MeridiemType.PM,
        alarmTime = AlarmTime(hour = "12", minute = "15")
    )

    val isAlarmEnabled by viewModel.isAlarmEnabled.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Row {
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_header_menu_32),
                    contentDescription = null,
                    tint = AlarmiTheme.colors.grey200
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            NextAlarmButton(modifier = Modifier)

            Spacer(modifier = Modifier.height(4.dp))

            NextAlarmInfo(alarmTime = alarmState.alarmTime)

            Spacer(modifier = Modifier.height(32.dp))

            SleepServiceOn()

            Spacer(modifier = Modifier.height(8.dp))
        }

        items(data) {
            Column {
                AlarmCard(
                    paddingValues = PaddingValues(12.dp),
                    modifier = Modifier,
                    selectedDays = alarmState.selectedDays,
                    meridiem = alarmState.meridiem,
                    alarmTime = alarmState.alarmTime,
                    isAlarmEnabled = isAlarmEnabled,
                    onToggleAlarm = viewModel::setAlarmEnabled
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
private fun NextAlarmButton(modifier: Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(color = AlarmiTheme.colors.grey800)
            .padding(horizontal = 4.dp, vertical = 6.dp)

    ) {
        Text(
            text = "다음 알람",
            style = AlarmiTheme.typography.body04m13,
            color = AlarmiTheme.colors.grey200,
            modifier = Modifier
                .padding(start = 4.dp, end = 4.dp)

        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_morning_arrow_right_16),
            contentDescription = null,
            tint = AlarmiTheme.colors.grey200

        )
    }
}

@Composable
private fun NextAlarmInfo(alarmTime: AlarmTime) {
    val nextAlarmTime = remember(alarmTime) {
        getTimeUntilAlarm(alarmTime)
    }
    Text(

        text = nextAlarmTime,
        style = AlarmiTheme.typography.title03b22,
        color = AlarmiTheme.colors.grey100

    )
}

@Composable
private fun SleepServiceOn() {
    AlarmSurface(
        modifier = Modifier,
        paddingValues = PaddingValues(horizontal = 16.dp, vertical = 17.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 1.dp)

        ) {
            Image(
                painter = painterResource(R.drawable.img_home_zzz_45),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 12.dp)
            )

            Column(
                modifier = Modifier
                    .padding(vertical = 4.dp)

            ) {
                Text(
                    text = "과학적인 사운드로 꿀잠 자기",
                    style = AlarmiTheme.typography.caption02r11,
                    color = AlarmiTheme.colors.grey100,
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "수면 분석 켜기",
                        style = AlarmiTheme.typography.body01b15,
                        color = AlarmiTheme.colors.grey100

                    )

                    Icon(
                        imageVector = ImageVector.vectorResource(
                            R.drawable.ic_morning_arrow_right_16
                        ),
                        contentDescription = null,
                        tint = AlarmiTheme.colors.grey100
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun AlarmScreenPreview() {
    AlamiTheme {
        AlarmScreen(
            paddingValues = PaddingValues(0.dp),
            onClick = {}
        )
    }
}

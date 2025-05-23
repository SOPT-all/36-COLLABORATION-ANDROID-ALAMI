package org.sopt.alami.presentation.alarm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.delay
import org.sopt.alami.R
import org.sopt.alami.core.designsystem.theme.AlarmiTheme
import org.sopt.alami.presentation.alarm.component.AddAlarmButton
import org.sopt.alami.presentation.alarm.component.AlarmCard
import org.sopt.alami.presentation.alarm.component.AlarmSurface
import org.sopt.alami.presentation.alarm.model.AlarmCardState
import org.sopt.alami.presentation.alarm.viewmodel.AlarmViewModel

@Composable
fun AlarmRoute(
    paddingValues: PaddingValues,
    navigateToAlarmDismiss: () -> Unit,
    viewModel: AlarmViewModel = hiltViewModel()
) {
    val alarmList = viewModel.alarmList

    val shouldTrigger by viewModel.shouldTrigger.collectAsStateWithLifecycle()

    val nextAlarmTime by viewModel.nextAlarmTime.collectAsStateWithLifecycle()

    LaunchedEffect(shouldTrigger) {
        if (shouldTrigger) {
            navigateToAlarmDismiss()
        }
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            viewModel.checkAlarmTime(userId = 1)
        }
    }

    AlarmScreen(
        paddingValues = paddingValues,
        alarmList = alarmList,
        nextAlarmTime = nextAlarmTime,
        onToggleAlarm = viewModel::setAlarmEnabled,
        onClick = {}
    )

    AddAlarmButton(onClicked = {})
}

@Composable
fun AlarmScreen(
    paddingValues: PaddingValues,
    alarmList: List<AlarmCardState>,
    nextAlarmTime: String,
    onToggleAlarm: (index: Int, isEnabled: Boolean) -> Unit,
    onClick: () -> Unit

) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(horizontal = 16.dp)
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

            NextAlarmInfo(alarmTime = nextAlarmTime)

            Spacer(modifier = Modifier.height(32.dp))

            SleepServiceOn()

            Spacer(modifier = Modifier.height(8.dp))
        }

        itemsIndexed(alarmList) { index, alarmState ->

            Column {
                AlarmCard(
                    paddingValues = PaddingValues(12.dp),
                    modifier = Modifier,
                    selectedDays = alarmState.selectedDays,
                    meridiem = alarmState.meridiem,
                    alarmTime = alarmState.alarmTime,
                    isAlarmEnabled = alarmState.isAlarmEnabled,
                    onToggleAlarm = { isEnabled ->
                        onToggleAlarm(index, isEnabled)
                    }
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
private fun NextAlarmInfo(alarmTime: String) {
    Text(
        text = alarmTime,
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

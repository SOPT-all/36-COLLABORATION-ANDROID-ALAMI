package org.sopt.alami.presentation.alarm.component


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.sopt.alami.R
import org.sopt.alami.core.designsystem.theme.AlamiTheme
import org.sopt.alami.core.designsystem.theme.AlarmiTheme
import org.sopt.alami.presentation.alarm.model.AlarmTime
import org.sopt.alami.presentation.alarm.model.DayType
import org.sopt.alami.presentation.alarm.model.MeridiemType
import org.sopt.alami.presentation.alarm.viewmodel.AlarmViewModel

@Composable
fun AlarmCard(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(12.dp),
    selectedDays: List<DayType>?,
    meridiem: MeridiemType = MeridiemType.AM,
    alarmTime: AlarmTime,
    isAlarmEnabled: Boolean,
    viewModel: AlarmViewModel = hiltViewModel()

) {

    val meridiemTime = remember(meridiem) {
        when (meridiem) {
            MeridiemType.AM -> "오전"
            MeridiemType.PM -> "오후"
        }
    }

    val setColor = if (isAlarmEnabled) {
        AlarmiTheme.colors.grey100
    } else {
        AlarmiTheme.colors.grey400
    }



    AlarmSurface(
        modifier = modifier,
        paddingValues = paddingValues
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {


            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {


                DayType.Days.forEach { day ->
                    Text(
                        text = day.label,
                        style = AlarmiTheme.typography.body02b12,
                        color = if (selectedDays?.contains(day) == true) {
                            AlarmiTheme.colors.bluePrimary
                        } else {
                            AlarmiTheme.colors.grey400
                        },
                        modifier = modifier.padding(end = 4.dp)
                    )


                }
            }

            Row(

                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    modifier = Modifier.alignByBaseline(),
                    text = meridiemTime,
                    style = AlarmiTheme.typography.title03b22,
                    color = setColor

                )

                Spacer(modifier = modifier.width(4.dp))

                Text(
                    modifier = Modifier.alignByBaseline(),
                    text = "${alarmTime.hour}:${alarmTime.minute}",
                    style = AlarmiTheme.typography.title02b30,
                    color = setColor

                )

                Spacer(modifier = modifier.weight(1f))

                Switch(
                    modifier = modifier
                        .wrapContentSize(Alignment.Center)
                        .requiredSize(52.dp, 32.dp),
                    checked = isAlarmEnabled,
                    onCheckedChange = viewModel::setAlarmEnabled,
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = AlarmiTheme.colors.white,
                        checkedTrackColor = AlarmiTheme.colors.bluePrimary,
                        uncheckedThumbColor = AlarmiTheme.colors.grey400,
                        uncheckedTrackColor = AlarmiTheme.colors.grey600,
                        uncheckedBorderColor = Color.Transparent
                    )


                )
            }

            Spacer(modifier = modifier.height(12.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "미션",
                    style = AlarmiTheme.typography.body04m13,
                    color = setColor
                )

                Spacer(modifier = modifier.width(4.dp))

                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_alarm_mission_16),
                    contentDescription = null,
                    tint = setColor
                )

                Spacer(modifier = modifier.weight(1f))

                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_alarm_menu_16),
                    contentDescription = null,
                    tint = setColor
                )
            }

        }
    }

}


@Preview
@Composable
private fun AlarmCardPreview() {
    AlamiTheme {
        AlarmCard(
            selectedDays = listOf(DayType.SATURDAY, DayType.THURSDAY),
            isAlarmEnabled = false,
            meridiem = MeridiemType.AM,
            alarmTime = AlarmTime("16", "12"),
            modifier = Modifier,
            paddingValues = PaddingValues(12.dp),
            viewModel = hiltViewModel()
        )

    }

}
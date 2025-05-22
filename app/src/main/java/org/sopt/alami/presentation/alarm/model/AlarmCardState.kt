package org.sopt.alami.presentation.alarm.model

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.selects.select
import org.sopt.alami.data.dto.AlarmListDto

data class AlarmCardState(
    val selectedDays: PersistentList<DayType> = persistentListOf(),
    val meridiem: MeridiemType = MeridiemType.AM,
    val alarmTime: AlarmTime = AlarmTime(hour = "00", minute = "00"),
    var isAlarmEnabled: Boolean = true
)

fun AlarmListDto.toAlarmCardState() : AlarmCardState {
    val (hour, minute) = timestamp.split(":")

    val meridiem = if ((hour.toIntOrNull() ?: 0) < 12) MeridiemType.AM else MeridiemType.PM

    return AlarmCardState(
        selectedDays = DayType.Days,
        meridiem = meridiem,
        alarmTime = AlarmTime(hour,minute),
        isAlarmEnabled = isActive
    )
}

fun AlarmTime.toNextAlarmTime(): LocalDateTime {
    val now = LocalDateTime.now()
    val alarmHour = hour.toInt()
    val alarmMinute = minute.toInt()

    val todayAlarmTime = now.withHour(alarmHour).withMinute(alarmMinute).withSecond(0).withNano(0)

    return if (todayAlarmTime.isAfter(now)) {
        todayAlarmTime
    } else {
        todayAlarmTime.plusDays(1)
    }
}

fun getTimeUntilAlarm(alarmTime: AlarmTime): String {
    val now = LocalDateTime.now()
    val nextAlarmTime = alarmTime.toNextAlarmTime()

    val totalMinutes = ChronoUnit.MINUTES.between(now, nextAlarmTime)

    val hours = totalMinutes / 60
    val minutes = totalMinutes % 60

    return when {
        hours > 0 && minutes > 0 -> "${hours}시간 ${minutes}분 후에 울려요"
        hours > 0 -> "${hours}시간 후에 울려요"
        minutes > 0 -> "${minutes}분 후에 울려요"
        else -> ""
    }
}

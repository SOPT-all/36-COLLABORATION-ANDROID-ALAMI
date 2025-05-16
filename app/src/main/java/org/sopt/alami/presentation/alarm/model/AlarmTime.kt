package org.sopt.alami.presentation.alarm.model

data class AlarmTime(
    val hour: String,
    val minute: String
) {

    companion object{
        fun getTimestamp(timestamp: String): AlarmTime {

            val (hour, minute) = timestamp.split(":")
            return AlarmTime(hour, minute)
        }
    }
}
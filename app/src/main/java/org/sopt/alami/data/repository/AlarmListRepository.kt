package org.sopt.alami.data.repository

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import org.sopt.alami.data.dto.AlarmListDto
import org.sopt.alami.data.dto.AlarmTimeCheckDto
import org.sopt.alami.data.service.AlarmListService

class AlarmListRepository @Inject constructor(
    private val alarmListService: AlarmListService
) {
    suspend fun getAlarmList(userId: Long): Result<List<AlarmListDto>> =

        runCatching {
            val response = alarmListService.getAlarmList(userId = 1)
            if (response.success) {
                response.data.orEmpty()
            } else {
                throw Exception(response.error?.message ?: "")
            }
        }

    suspend fun getAlarmTimeCheck(userId: Long): Result<AlarmTimeCheckDto?> =

        runCatching {
            val currentTime = LocalDateTime.now()
                .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)

            val response = alarmListService.getAlarmTimeCheck(1, currentTime)
            if (response.success) {
                response.data
            } else {
                throw Exception(response.error?.message ?: "")
            }
        }
}

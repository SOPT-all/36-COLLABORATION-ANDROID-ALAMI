package org.sopt.alami.data.repository

import kotlinx.collections.immutable.ImmutableList
import org.sopt.alami.data.dto.AlarmListDto
import org.sopt.alami.data.service.AlarmListService
import javax.inject.Inject
import kotlin.concurrent.timer

class AlarmListRepository @Inject constructor(
    private val alarmListService: AlarmListService
){
    suspend fun getAlarmList(userId: Long): Result<List<AlarmListDto>> =

        runCatching {

            val response = alarmListService.getAlarmList(userId=1)
            if (response.success) {
                response.data.orEmpty()
            } else {
                throw Exception(response.error?.message?: "")

            }

        }
}
package org.sopt.alami.data.repository

import org.sopt.alami.core.network.BaseResponse
import org.sopt.alami.data.dto.request.AddAlarmRequest
import org.sopt.alami.data.dto.response.SuccessAdd
import org.sopt.alami.data.service.AddAlarmService
import javax.inject.Inject

class AlarmRepository @Inject constructor(
    private val addAlarmService: AddAlarmService
) {
    suspend fun addAlarm(userId: Long, request: AddAlarmRequest): Result<List<SuccessAdd>> {
        return runCatching {
            val response: BaseResponse<List<SuccessAdd>> = addAlarmService.addAlarm(userId, request)

            if (response.success && response.data != null) {
                response.data
            } else {
                throw Exception()
            }
        }
    }
}

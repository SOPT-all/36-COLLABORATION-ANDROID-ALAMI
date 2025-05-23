package org.sopt.alami.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.sopt.alami.data.dto.request.AddAlarmRequest
import org.sopt.alami.data.dto.response.AddAlarmResponse
import org.sopt.alami.data.service.AddAlarmService
import javax.inject.Inject

class AlarmRepository @Inject constructor(
    private val addAlarmService: AddAlarmService
) {
    suspend fun addAlarm(userId: Long, request: AddAlarmRequest): Result<AddAlarmResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = addAlarmService.addAlarm(userId, request).execute()
                if (response.isSuccessful) {
                    response.body()?.let { Result.success(it) }
                        ?: Result.failure(Exception("응답 본문이 없습니다."))
                } else {
                    Result.failure(Exception("응답 실패: ${response.code()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}

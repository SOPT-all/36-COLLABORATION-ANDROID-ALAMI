package org.sopt.alami.data.service

import org.sopt.alami.core.network.BaseResponse
import org.sopt.alami.data.dto.request.AddAlarmRequest
import org.sopt.alami.data.dto.response.SuccessAdd
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface AddAlarmService {
    @POST ("/api/v1/alarm")
    suspend fun addAlarm(
        @Header ("userId") userId : Long,
        @Body request: AddAlarmRequest
    ):BaseResponse<List<SuccessAdd>>
}
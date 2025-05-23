package org.sopt.alami.data.service

import org.sopt.alami.data.dto.request.AddAlarmRequest
import org.sopt.alami.data.dto.response.AddAlarmResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface AddAlarmService {
    @POST ("/api/v1/alarm")
    fun addAlarm(
        @Header ("userId") userId : Long,
        @Body request: AddAlarmRequest
    ):Call<AddAlarmResponse>
}
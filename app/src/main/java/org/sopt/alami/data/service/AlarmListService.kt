package org.sopt.alami.data.service

import org.sopt.alami.core.network.BaseResponse
import org.sopt.alami.data.dto.AlarmListDto
import org.sopt.alami.data.dto.AlarmTimeCheckDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface AlarmListService {

    @GET("/api/v1/alarms")
    suspend fun getAlarmList(
        @Header("userId") userId: Long
    ): BaseResponse<List<AlarmListDto>>

    @GET("/api/v1/alarm/check")
    suspend fun getAlarmTimeCheck(
        @Header("userId") userId: Long,
        @Query("currentTime") currentTime: String
    ): BaseResponse<AlarmTimeCheckDto>
}

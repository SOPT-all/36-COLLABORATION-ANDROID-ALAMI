package org.sopt.alami.data.service

import org.sopt.alami.core.network.BaseResponse
import org.sopt.alami.data.dto.response.TodaySentenceResponseDto
import org.sopt.alami.data.dto.response.TodayWeatherResponseDto
import retrofit2.http.GET

interface MorningService {
    @GET("/api/v1/phrase")
    suspend fun getTodaySentence(): BaseResponse<TodaySentenceResponseDto>

    @GET("api/v1/weather")
    suspend fun getTodayWeather(): BaseResponse<TodayWeatherResponseDto>
}

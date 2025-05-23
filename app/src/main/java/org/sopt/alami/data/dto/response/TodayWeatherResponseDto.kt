package org.sopt.alami.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TodayWeatherResponseDto(
    @SerialName("date")
    val date: String,
    @SerialName("temperature")
    val temperature: Int,
    @SerialName("weatherCode")
    val weatherCode: Int
)

package org.sopt.alami.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TodaySentenceResponseDto(
    @SerialName("imageNum")
    val imageNum: Int
)

package org.sopt.alami.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AlarmListDto (

    @SerialName("id")
    val id: Long,
    @SerialName("timestamp")
    val timestamp: String,
    @SerialName("isActive")
    val isActive: Boolean

)
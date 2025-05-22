package org.sopt.alami.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlarmTimeCheckDto(
    @SerialName("alarmInfo")
    val alarmInfo: List<AlarmInfoDto>,
)

@Serializable
data class AlarmInfoDto(
    @SerialName("id")
    val id: Long,
    @SerialName("shouldTrigger")
    val shouldTrigger: Boolean
)
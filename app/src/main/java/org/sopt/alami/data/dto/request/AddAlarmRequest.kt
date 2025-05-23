package org.sopt.alami.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddAlarmRequest(
    @SerialName ("timestamp")
    val timestamp : String
)

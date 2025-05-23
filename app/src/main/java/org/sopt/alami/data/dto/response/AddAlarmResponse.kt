package org.sopt.alami.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class AddAlarmResponse(
    @SerialName("success")
    val success : Boolean,
    @SerialName("code")
    val code : Int,
    @SerialName("message")
    val message : String,
    @SerialName("data")
    val data : List<SuccessAdd>
)
@Serializable
class SuccessAdd(
    @SerialName("id")
    val id : Long,
    @SerialName("timestamp")
    val timestamp : String,
    @SerialName("isActive")
    val isActive : Boolean
)

package com.hari.notty.core.network.request
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Serializable
data class LoginResponseDto(
    @SerializedName("accessToken")
    val accessToken: AccessToken,
    @SerializedName("user")
    val user: User
)

@Serializable
data class AccessToken(
    @SerializedName("expiresIn")
    val expiresIn: Long,
    @SerializedName("refreshToken")
    val refreshToken: String,
    @SerializedName("token")
    val token: String
)

@Serializable
data class User(
    @SerializedName("email")
    val email: String,
    @SerializedName("_id")
    val _id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("profilePic")
    val profilePic: String
)
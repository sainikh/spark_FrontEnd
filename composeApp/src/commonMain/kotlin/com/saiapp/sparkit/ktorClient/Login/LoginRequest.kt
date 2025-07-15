package com.saiapp.sparkit.ktorClient.Login
import kotlinx.serialization.Serializable


@Serializable
data class LoginRequest(
    val token: String
)
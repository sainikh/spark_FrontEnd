package com.saiapp.sparkit.ktorClient.Login

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val message: String,
    val token: Token
)

@Serializable
data class Token(
    val acessToken: String,
    val refresh_token: String
)
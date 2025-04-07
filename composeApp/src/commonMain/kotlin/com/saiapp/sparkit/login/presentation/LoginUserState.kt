package com.saiapp.sparkit.login.presentation

data class LoginUserState (
   val isLoading : Boolean = false,
    val errorMessage : String? = null
)
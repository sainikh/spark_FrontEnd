package com.saiapp.sparkit

import com.saiapp.sparkit.ktorClient.LoginViewModel
import kotlinx.coroutines.CoroutineScope


object SharedModule{
    private var androidContext: Any? = null

    fun setAndroidContext(context: Any) {
        androidContext = context
    }

    fun getAndroidContext(): Any? {
       return androidContext
    }
}

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect suspend fun signInWithGoogle(
    serverClientId: String,
    loginViewModel: LoginViewModel,
    coroutineScope: CoroutineScope
)
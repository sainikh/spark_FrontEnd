package com.saiapp.sparkit

import android.content.Context
import android.os.Build
import com.saiapp.sparkit.ktorClient.LoginViewModel
import com.saiapp.sparkit.model.GoogleAuth
import kotlinx.coroutines.CoroutineScope

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()
actual suspend fun signInWithGoogle(
    serverClientId: String,
    loginViewModel: LoginViewModel,
    coroutineScope: CoroutineScope
) {
    val mainActivityContext = SharedModule.getAndroidContext()
    GoogleAuth.launchSignIn(mainActivityContext,serverClientId,loginViewModel,coroutineScope)
}
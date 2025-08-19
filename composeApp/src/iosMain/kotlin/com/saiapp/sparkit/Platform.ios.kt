package com.saiapp.sparkit
import com.saiapp.sparkit.ktorClient.LoginViewModel
import kotlinx.coroutines.CoroutineScope
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()
actual suspend fun signInWithGoogle(
    serverClientId: String,
    loginViewModel: LoginViewModel,
    coroutineScope: CoroutineScope
) {
}
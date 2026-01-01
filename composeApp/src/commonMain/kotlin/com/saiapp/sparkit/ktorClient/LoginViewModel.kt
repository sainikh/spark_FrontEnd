package com.saiapp.sparkit.ktorClient

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saiapp.sparkit.ktorClient.Login.LoginResponse
import com.saiapp.sparkit.Preference.AppPreferences
import com.saiapp.sparkit.Preference.PreferenceKeys
import kotlinx.coroutines.flow.MutableSharedFlow
//import com.saiapp.sparkit.logger.KMMLogger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

val TAG: String = "LoginViewModel"

class LoginViewModel(private val ktorClient: KtorClient) : ViewModel() {

    private val _navigateToNextPage: MutableSharedFlow<Boolean> = MutableStateFlow(false)
    val navigateToNextPage = _navigateToNextPage.asSharedFlow()

    private val _errorMessage: MutableStateFlow<String?> = MutableStateFlow(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    suspend fun getLoginDetails(autToken: String) {
        kotlin.runCatching {
            ktorClient.login(autToken)
        }.onSuccess { response ->
            handleOnSuccess(response)
        }.onFailure { error ->
            _errorMessage.value = "Something went wrong"
//            KMMLogger.log(TAG, "Login Response Error :${error.message}")
            error.printStackTrace()
        }
    }

    private fun handleOnSuccess(response: LoginResponse) {
        viewModelScope.launch {
            AppPreferences.putString(PreferenceKeys.ACCESS_TOKEN, response.token.accessToken)
            AppPreferences.putString(PreferenceKeys.REFRESH_TOKEN, response.token.refreshToken)
            _navigateToNextPage.emit(true)
        }
    }
}
package com.saiapp.sparkit.login.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.saiapp.sparkit.login.presentation.LoggedInUserAction
import com.saiapp.sparkit.login.presentation.LoginUserState

class LoggedInUserViewModel : ViewModel() {
   private val _state = MutableStateFlow(LoginUserState())
    val state = _state.asStateFlow()

    fun onAction(action : LoggedInUserAction){
        when(action){
            is LoggedInUserAction.OnLoggedInPressed -> {
                _state.update {
                    it.copy(isLoading = true)
                }
            }
        }
    }
}
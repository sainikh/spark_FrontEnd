package com.saiapp.sparkit.login.presentation

sealed interface LoggedInUserAction {
    data class OnLoggedInPressed(val query: String) : LoggedInUserAction
}
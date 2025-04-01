package org.example.project.login.presentation

sealed interface LoggedInUserAction {
    data class OnLoggedInPressed(val query: String) : LoggedInUserAction
}
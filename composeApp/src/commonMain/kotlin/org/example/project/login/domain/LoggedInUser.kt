package org.example.project.login.domain

data class LoggedInUser(
    val userName : String,
    val gender : String,
    val authToken : String,
    val email : String
)
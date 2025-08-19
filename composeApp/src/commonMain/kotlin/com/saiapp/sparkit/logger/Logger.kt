package com.saiapp.sparkit.logger

interface Logger {
    fun log(tag: String, message: String)
}
//expect object KMMLogger : Logger
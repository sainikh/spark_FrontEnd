package com.saiapp.sparkit.logger

import android.util.Log

actual object KMMLogger : Logger {
    override fun log(tag: String, message: String) {
        Log.d(tag, message)
    }
}
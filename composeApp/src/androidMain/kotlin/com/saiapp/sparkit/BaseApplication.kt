package com.saiapp.sparkit

import android.app.Application
import android.content.Context
import com.saiapp.sparkit.Preference.initAndroidPreferences


class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
        initAndroidPreferences(this)
    }

    companion object {
        lateinit var context: Context
    }
}
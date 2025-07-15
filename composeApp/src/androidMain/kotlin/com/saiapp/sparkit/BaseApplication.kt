package com.saiapp.sparkit
import android.app.Application
import com.saiapp.sparkit.Preference.initAndroidPreferences


class BaseApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        initAndroidPreferences(this)
    }
}
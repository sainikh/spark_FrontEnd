package com.saiapp.sparkit.Preference

import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings


private lateinit var androidSettings: Settings
private lateinit var context: Context

fun initAndroidPreferences(context: Context) {
    if (!::androidSettings.isInitialized) {
        val sharedPrefs = context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
        androidSettings = SharedPreferencesSettings(sharedPrefs)
    }
}

actual fun provideSettings(): Settings = androidSettings
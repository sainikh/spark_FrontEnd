package com.saiapp.sparkit.Preference

import com.russhwolf.settings.Settings


expect fun provideSettings(): Settings

object AppPreferences {
    private val settings: Settings by lazy { provideSettings() }

    fun putString(key: String, value: String) = settings.putString(key, value)
    fun getString(key: String, defaultValue: String = "") = settings.getString(key, defaultValue)
    fun clear() = settings.clear()
}

object PreferenceKeys {
    const val ACCESS_TOKEN = "accessToken"
    const val REFRESH_TOKEN = "refreshToken"
}
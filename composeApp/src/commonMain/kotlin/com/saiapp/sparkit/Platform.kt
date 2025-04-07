package com.saiapp.sparkit

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
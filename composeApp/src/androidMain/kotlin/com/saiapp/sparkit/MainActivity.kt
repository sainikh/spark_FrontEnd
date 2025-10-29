package com.saiapp.sparkit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.saiapp.sparkit.view.LoginScreen

private val TAG: String = MainActivity::class.java.simpleName

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Set Context
        SharedModule.setAndroidContext(this)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

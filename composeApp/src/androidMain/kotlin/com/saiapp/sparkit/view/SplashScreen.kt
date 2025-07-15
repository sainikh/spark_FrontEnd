package com.saiapp.sparkit.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize   
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onDone: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(2000)
        onDone()
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Welcome to the App!")
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    Surface {
        SplashScreen { }
    }

}
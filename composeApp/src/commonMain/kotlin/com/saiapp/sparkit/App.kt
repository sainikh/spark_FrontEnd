package com.saiapp.sparkit

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.saiapp.sparkit.login.presentation.HomeScreen
import com.saiapp.sparkit.login.presentation.Screen.LoginScreen
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import sparkit.composeapp.generated.resources.Res
import sparkit.composeapp.generated.resources.login_background_img

@Composable
fun App() {
   LoginScreen()
}

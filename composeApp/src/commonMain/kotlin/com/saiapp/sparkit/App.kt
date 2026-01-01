package com.saiapp.sparkit

import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.saiapp.sparkit.Navigation.ScreenNavigation

@Composable
fun App() {
   val navController = rememberNavController()
   ScreenNavigation(navController)
}

package com.saiapp.sparkit.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.saiapp.sparkit.Home.presentation.HomeScreen
import com.saiapp.sparkit.login.presentation.Screen.LoginScreen

sealed class ScreenNavigation(var route: String) {
    data object LoginScreen : ScreenNavigation("LoginScreen")
    data object HomeScreen : ScreenNavigation("HomeScreen/{name}") {
        fun getRoute(name: String) = "HomeScreen/$name"
    }
}


@Composable
fun ScreenNavigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = ScreenNavigation.LoginScreen.route
    ) {
        addLoginScreen(navHostController)
        addHomeScreen()
    }
}


private fun NavGraphBuilder.addLoginScreen(navHostController: NavHostController) {
    composable(
        ScreenNavigation.LoginScreen.route
    ) {
        LoginScreen {
            navHostController.navigate(ScreenNavigation.HomeScreen.route)
        }
    }
}

private fun NavGraphBuilder.addHomeScreen() {
    composable(
        ScreenNavigation.HomeScreen.route
    ) {
        HomeScreen{ }
    }
}
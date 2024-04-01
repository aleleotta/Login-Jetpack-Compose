package com.example.loginjetpackcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class NavControllerHandler {
    @Composable
    fun Navigation(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "Login") {
            composable(route = "Login") { Login(navController) }
            composable(route = "AccessGranted") { AccessGranted(navController) }
            composable(route = "AccessDenied") { AccessDenied(navController) }
        }
    }
}
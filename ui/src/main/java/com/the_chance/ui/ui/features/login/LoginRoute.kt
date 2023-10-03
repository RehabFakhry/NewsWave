package com.the_chance.newswave.ui.features.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.the_chance.ui.ui.features.login.LoginScreen
import com.the_chance.ui.ui.navigation.Screen


private val ROUTE = Screen.LoginScreen.route

fun NavController.navigateToLogin() {
    navigate(ROUTE)
}

fun NavGraphBuilder.loginRoute() {
    composable(ROUTE) { LoginScreen() }
}
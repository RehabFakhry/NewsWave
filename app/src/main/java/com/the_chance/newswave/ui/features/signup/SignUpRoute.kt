package com.the_chance.newswave.ui.features.signup

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.the_chance.newswave.ui.navigation.nav_graph.Screen

private val ROUTE = Screen.SignupScreen.route

fun NavController.navigateToSignupScreen() {
    navigate(ROUTE)
}

fun NavGraphBuilder.signupRoute() {
    composable(ROUTE) { SignupScreen() }
}
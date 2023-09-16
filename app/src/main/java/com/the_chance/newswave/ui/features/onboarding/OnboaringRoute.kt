package com.the_chance.newswave.ui.features.onboarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.the_chance.newswave.ui.navigation.Screen


private val ROUTE = Screen.OnBoardingScreen.route

fun NavController.navigateToOnBoardingScreen() {
    navigate(ROUTE)
}

fun NavGraphBuilder.onboardingRoute() {
    composable(route = ROUTE) { OnboardingScreen() }
}
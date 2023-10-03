package com.the_chance.ui.ui.features.onboarding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.the_chance.ui.ui.navigation.Screen


private val ROUTE = Screen.OnBoardingScreen.route

fun NavGraphBuilder.onboardingRoute() {
    composable(route = ROUTE) { OnboardingScreen() }
}
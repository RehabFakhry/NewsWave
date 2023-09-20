package com.the_chance.newswave.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.the_chance.newswave.ui.features.home.homeRoute
import com.the_chance.newswave.ui.features.onboarding.onboardingRoute
import com.the_chance.newswave.ui.navigation.nav_graph.Graph
import com.the_chance.newswave.ui.navigation.nav_graph.Screen

fun NavGraphBuilder.onboardingNavGraph() {
    navigation(
        startDestination = Screen.OnBoardingScreen.route,
        route = Graph.ONBOARDING
    ) {
        onboardingRoute()
        homeRoute()
    }
}
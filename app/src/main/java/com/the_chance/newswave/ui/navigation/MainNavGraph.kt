package com.the_chance.newswave.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost

@Composable
fun MainNavGraph() {
    val navController = LocalNavigationProvider.current

    NavHost(
        navController = navController,
        startDestination = Graph.ONBOARDING
    ) {
        onboardingNavGraph()
        authNavGraph()
        homeNavGraph()
        discoverNavGraph()
        savedNavGraph()
        profileNvGraph()
    }
}

object Graph {
    const val ONBOARDING = "onboarding_graph"
    const val AUTH_GRAPH = "auth_graph"
    const val HOME = "home_graph"
    const val DISCOVER = "discover_graph"
    const val SAVED = "saved_graph"
    const val PROFILE = "profile_graph"

}
package com.the_chance.newswave.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost

@Composable
fun MainNavGraph() {
    val navController = LocalNavigationProvider.current

    NavHost(
        navController = navController,
        startDestination = Graph.HOME
    ) {
        authNavGraph()
        homeNavGraph()

    }
}

object Graph {
    const val AUTH_GRAPH = "auth_graph"
    const val HOME = "home_graph"
}
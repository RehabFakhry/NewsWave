package com.the_chance.newswave.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.the_chance.newswave.ui.features.home.homeRoute
import com.the_chance.newswave.ui.features.search.searchRoute

fun NavGraphBuilder.homeNavGraph() {
    navigation(
        startDestination = Screen.HomeScreen.route,
        route = Graph.HOME
    ) {
        homeRoute()
        searchRoute()
    }
}
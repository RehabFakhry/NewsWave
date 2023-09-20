package com.the_chance.newswave.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.the_chance.newswave.ui.features.discover.discoverRoute
import com.the_chance.newswave.ui.features.home.homeRoute
import com.the_chance.newswave.ui.features.news_details.newsDetailsRoute
import com.the_chance.newswave.ui.features.profile.profileRoute
import com.the_chance.newswave.ui.features.saved_news.savedNewsRoute
import com.the_chance.newswave.ui.features.search.searchRoute
import com.the_chance.newswave.ui.navigation.nav_graph.Screen

fun NavGraphBuilder.homeNavGraph() {
    navigation(
        startDestination = Screen.HomeScreen.route,
        route = Graph.HOME
    ) {
        homeRoute()
        discoverRoute()
        searchRoute()
        profileRoute()
        savedNewsRoute()
        newsDetailsRoute()
    }
}
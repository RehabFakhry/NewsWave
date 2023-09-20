package com.the_chance.newswave.ui.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.the_chance.newswave.ui.features.discover.discoverRoute
import com.the_chance.newswave.ui.features.news_details.newsDetailsRoute
import com.the_chance.newswave.ui.features.search.searchRoute
import com.the_chance.newswave.ui.navigation.nav_graph.Screen

fun NavGraphBuilder.discoverNavGraph() {
    navigation(
        startDestination = Screen.DiscoverScreen.route,
        route = Graph.DISCOVER
    ) {
        discoverRoute()
        searchRoute()
        newsDetailsRoute()
    }
}
package com.the_chance.newswave.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.the_chance.newswave.ui.features.discover.discoverRoute
import com.the_chance.newswave.ui.features.news_details.newsDetailsRoute
import com.the_chance.newswave.ui.features.search.searchRoute

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
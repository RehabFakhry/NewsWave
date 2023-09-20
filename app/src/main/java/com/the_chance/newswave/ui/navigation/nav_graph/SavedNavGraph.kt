package com.the_chance.newswave.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.the_chance.newswave.ui.features.news_details.newsDetailsRoute
import com.the_chance.newswave.ui.features.saved_news.savedNewsRoute
import com.the_chance.newswave.ui.navigation.nav_graph.Graph
import com.the_chance.newswave.ui.navigation.nav_graph.Screen

fun NavGraphBuilder.savedNavGraph() {
    navigation(
        startDestination = Screen.SavedNewsScreen.route,
        route = Graph.SAVED
    ) {
        savedNewsRoute()
        newsDetailsRoute()
    }
}
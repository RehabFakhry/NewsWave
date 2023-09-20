package com.the_chance.newswave.ui.features.news_details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.the_chance.newswave.ui.navigation.nav_graph.Screen

private val ROUTE = Screen.NewsDetailsScreen.route

fun NavController.navigateToNewsDetailsScreen(){
    navigate(ROUTE)
}

fun NavGraphBuilder.newsDetailsRoute(){
    composable(ROUTE) { NewsDetailsScreen() }
}
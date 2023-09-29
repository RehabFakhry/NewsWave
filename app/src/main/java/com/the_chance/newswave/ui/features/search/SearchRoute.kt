package com.the_chance.newswave.ui.features.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.the_chance.newswave.ui.navigation.Screen

private val Route = Screen.SearchScreen.route

fun NavController.navigateToSearchScreen(){
    navigate(Route)
}

fun NavGraphBuilder.searchRoute(){
    composable(Route) { SearchScreen() }
}
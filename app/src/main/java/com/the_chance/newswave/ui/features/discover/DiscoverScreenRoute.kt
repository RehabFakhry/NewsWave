package com.the_chance.newswave.ui.features.discover

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.the_chance.newswave.ui.navigation.Screen

private val ROUTE = Screen.DiscoverScreen.route

fun NavController.navigateToDiscoverScreen(){
    navigate(ROUTE)
}

fun NavGraphBuilder.discoverRoute(){
    composable(ROUTE) { DiscoverScreen() }
}
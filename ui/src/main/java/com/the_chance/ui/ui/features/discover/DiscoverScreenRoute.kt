package com.the_chance.newswave.ui.features.discover

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.the_chance.ui.ui.features.discover.DiscoverScreen
import com.the_chance.ui.ui.navigation.Screen

private val ROUTE = Screen.DiscoverScreen.route

fun NavGraphBuilder.discoverRoute(){
    composable(ROUTE) { DiscoverScreen() }
}
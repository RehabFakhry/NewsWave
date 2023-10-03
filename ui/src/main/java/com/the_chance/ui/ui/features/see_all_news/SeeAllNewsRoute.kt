package com.the_chance.newswave.ui.features.see_all_news

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.the_chance.ui.ui.navigation.Screen

private val ROUTE = Screen.SeeAllNewsScreen.route

fun NavController.navigateToSeeAllNewsScreen(){
    navigate(ROUTE)
}

fun NavGraphBuilder.seeAllNewsRoute(){
    composable(ROUTE) { SeeAllNewsScreen() }
}
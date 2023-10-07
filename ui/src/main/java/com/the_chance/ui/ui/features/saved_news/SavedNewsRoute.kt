package com.the_chance.ui.ui.features.saved_news

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.the_chance.ui.ui.navigation.Screen

private val ROUTE = Screen.SavedNewsScreen.route

fun NavController.navigateToSavedNewsScreen(){
    navigate(ROUTE)
}

fun NavGraphBuilder.savedNewsRoute(){
    composable(ROUTE) { SavedNewsScreen() }
}

package com.the_chance.ui.ui.features.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.the_chance.ui.ui.navigation.Screen

private val ROUTE = Screen.HomeScreen.route

fun NavController.navigateToHomeScreen(){
    navigate(ROUTE)
}

fun NavGraphBuilder.homeRoute(){
    composable(ROUTE) { HomeScreen() }
}


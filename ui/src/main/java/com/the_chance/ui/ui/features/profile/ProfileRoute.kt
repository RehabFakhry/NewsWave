package com.the_chance.ui.ui.features.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.the_chance.ui.ui.navigation.Screen

private val ROUTE = Screen.ProfileScreen.route

fun NavGraphBuilder.profileRoute(){
    composable(ROUTE) { ProfileScreen() }
}
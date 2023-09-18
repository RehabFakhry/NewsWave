package com.the_chance.newswave.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.the_chance.newswave.ui.features.profile.profileRoute


fun NavGraphBuilder.profileNvGraph() {
    navigation(
        startDestination = Screen.ProfileScreen.route,
        route = Graph.PROFILE
    ) {
        profileRoute()
    }
}
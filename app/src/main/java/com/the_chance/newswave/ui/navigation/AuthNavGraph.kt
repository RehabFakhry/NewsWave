package com.the_chance.newswave.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.the_chance.newswave.ui.features.login.loginRoute
import com.the_chance.newswave.ui.features.signup.signupRoute


fun NavGraphBuilder.authNavGraph() {

    navigation(
        route = Graph.AUTH_GRAPH,
        startDestination = Screen.LoginScreen.route
    ) {
        loginRoute()
        signupRoute()
    }
}
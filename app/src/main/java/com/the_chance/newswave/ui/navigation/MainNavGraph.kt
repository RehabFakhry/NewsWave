package com.the_chance.newswave.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.the_chance.newswave.ui.features.discover.discoverRoute
import com.the_chance.newswave.ui.features.home.homeRoute
import com.the_chance.newswave.ui.features.login.loginRoute
import com.the_chance.newswave.ui.features.news_details.newsDetailsRoute
import com.the_chance.newswave.ui.features.onboarding.onboardingRoute
import com.the_chance.newswave.ui.features.profile.profileRoute
import com.the_chance.newswave.ui.features.saved_news.savedNewsRoute
import com.the_chance.newswave.ui.features.search.searchRoute
import com.the_chance.newswave.ui.features.signup.signupRoute

@Composable
fun MainNavGraph() {
    val navController = LocalNavigationProvider.current

    NavHost(
        navController = navController,
        startDestination = Screen.OnBoardingScreen.route
    ) {
        onboardingRoute()
        loginRoute()
        signupRoute()
        homeRoute()
        discoverRoute()
        searchRoute()
        savedNewsRoute()
        newsDetailsRoute()
        profileRoute()
    }
}

//object Graph {
//    const val HOME = "home_graph"
//    const val DISCOVER = "discover_graph"
//    const val SAVED = "saved_graph"
//    const val PROFILE = "profile_graph"
//
//}
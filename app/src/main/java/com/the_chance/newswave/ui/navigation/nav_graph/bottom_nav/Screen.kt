package com.the_chance.newswave.ui.navigation.nav_graph

sealed class Screen(val route: String){

    object OnBoardingScreen : Screen("onboardingScreen")

    object LoginScreen : Screen("loginScreen")
    object SignupScreen : Screen("signupScreen")

    object HomeScreen : Screen("homeScreen")
    object DiscoverScreen : Screen("discoverScreen")
    object SearchScreen : Screen("searchScreen")
    object NewsDetailsScreen : Screen("newsDetailsScreen")
    object SavedNewsScreen : Screen("savedNewsScreen")
    object ProfileScreen : Screen("profileScreen")

}

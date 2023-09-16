package com.the_chance.newswave.ui.navigation

sealed class Screen(val route: String){
    object LoginScreen : Screen("loginScreen")
    object SignupScreen : Screen("signupScreen")

    object OnBoardingScreen : Screen("onboardingScreen")
    object HomeScreen : Screen("homeScreen")
    object DiscoverScreen : Screen("discoverScreen")
    object SearchScreen : Screen("searchScreen")
    object NewsDetailsScreen : Screen("newsDetailsScreen")
    object ProfileScreen : Screen("profileScreen")
    object SavedNewsScreen : Screen("savedNewsScreen")

}

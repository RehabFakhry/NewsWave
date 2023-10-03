package com.the_chance.ui.ui.navigation

sealed class Screen(val route: String){

    data object OnBoardingScreen : Screen("onboardingScreen")

    data object LoginScreen : Screen("loginScreen")
    data object SignupScreen : Screen("signupScreen")

    data object HomeScreen : Screen("homeScreen")
    data object DiscoverScreen : Screen("discoverScreen")
    data object SearchScreen : Screen("searchScreen")
    data object NewsDetailsScreen : Screen("newsDetailsScreen")
    data object SavedNewsScreen : Screen("savedNewsScreen")
    data object ProfileScreen : Screen("profileScreen")
    data object SeeAllNewsScreen : Screen("seeAllNewsScreen")

}

package com.the_chance.ui.ui.features.news_details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.the_chance.newswave.ui.features.discover.NewsArticleUiState
import com.the_chance.ui.ui.navigation.Screen

private val ROUTE = Screen.NewsDetailsScreen.route

fun NavController.navigateToNewsDetailsScreen(newsItem: NewsArticleUiState){
    navigate(ROUTE + "/${newsItem.title}"){
        popUpTo(Screen.DiscoverScreen.route){
            inclusive = true
        }
        launchSingleTop = true
//        arguments = bundleOf("newsItem" to newsItem)
    }
}

fun NavGraphBuilder.newsDetailsRoute(){
    composable(
        ROUTE + "/{title}",
        arguments = listOf(navArgument("title") { type = NavType.StringType } )
    ){ navBackStackEntry ->
        val title = navBackStackEntry.arguments?.getString("title")
        val newsItem = title?.let {  }
//        if (newsItem != null) {
//            NewsDetailsScreen(newsItem = newsItem)
//        } else {
//            // Handle the case when newsItem is null (e.g., show an error screen)
//        }
    }
}
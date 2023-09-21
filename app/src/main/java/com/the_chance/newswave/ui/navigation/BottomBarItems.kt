package com.the_chance.newswave.ui.navigation

import com.the_chance.newswave.R

sealed class BottomBarItems(
    val route: String,
    val label: Int,
    val selectedIcon: Int,
    val unSelectedIcon: Int,
) {
    data object Home : BottomBarItems(
        route = Screen.HomeScreen.route,
        label = R.string.home,
        selectedIcon = R.drawable.icon_home,
        unSelectedIcon = R.drawable.icon_home,
    )

    data object Discover : BottomBarItems(
        route = Screen.DiscoverScreen.route,
        label = R.string.discover,
        selectedIcon = R.drawable.icon_discover,
        unSelectedIcon = R.drawable.icon_discover
    )

    data object Saved : BottomBarItems(
        route = Screen.SavedNewsScreen.route,
        label = R.string.saved,
        selectedIcon = R.drawable.icon_saved,
        unSelectedIcon = R.drawable.icon_saved
    )

    data object Profile : BottomBarItems(
        route = Screen.ProfileScreen.route,
        label = R.string.profile,
        selectedIcon = R.drawable.icon_profile,
        unSelectedIcon = R.drawable.icon_profile
    )
}
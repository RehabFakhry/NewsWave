package com.the_chance.newswave.ui.navigation

import com.the_chance.newswave.R

sealed class BottomBarItems(
    val route: String,
    val label: Int,
    val selectedIcon: Int,
    val unSelectedIcon: Int,
) {
    object Home : BottomBarItems(
        route = Graph.HOME,
        label = R.string.home,
        selectedIcon = R.drawable.icon_home,
        unSelectedIcon = R.drawable.icon_home,
    )

    data object Discover : BottomBarItems(
        route = Graph.DISCOVER,
        label = R.string.discover,
        selectedIcon = R.drawable.icon_discover,
        unSelectedIcon = R.drawable.icon_discover
    )

    object Saved : BottomBarItems(
        route = Graph.SAVED,
        label = R.string.saved,
        selectedIcon = R.drawable.icon_saved,
        unSelectedIcon = R.drawable.icon_saved
    )

    object Profile : BottomBarItems(
        route = Graph.PROFILE,
        label = R.string.profile,
        selectedIcon = R.drawable.icon_profile,
        unSelectedIcon = R.drawable.icon_profile
    )
}

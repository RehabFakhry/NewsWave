package com.the_chance.ui.ui.features.discover

interface DiscoverInteractionListener {
    fun getNewsByCategory(category: String)
    fun onClickSearchBar()
    fun onClickNewsItem(title: String)
}
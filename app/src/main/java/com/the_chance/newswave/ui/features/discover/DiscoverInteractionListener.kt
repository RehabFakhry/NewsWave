package com.the_chance.newswave.ui.features.discover

interface DiscoverInteractionListener {
    fun getNewsByCategory(category: String)
    fun onClickSearchBar()
    fun onClickNewsItem()
}
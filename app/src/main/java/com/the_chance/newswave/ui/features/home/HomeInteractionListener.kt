package com.the_chance.newswave.ui.features.home

interface HomeInteractionListener {
    fun getAllNewsArticle()
    fun getAllNewsByDate()
    fun onClickBreakingNews()
    fun onClickSearchIcon()
    fun onClickShowMore()
    fun onClickRecommendedNews()
    fun onClickWorldNews()
}
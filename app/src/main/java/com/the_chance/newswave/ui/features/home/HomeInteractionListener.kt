package com.the_chance.newswave.ui.features.home

interface HomeInteractionListener {
    fun getAllNewsArticle()
    fun getAllNewsByDate()
    fun onClickPagerItem()
    fun onClickBreakingNews()
    fun onClickShowMore()
    fun onClickRecommendedNews()
}
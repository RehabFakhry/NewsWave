package com.the_chance.ui.ui.features.see_all_news

sealed class SeeAllNewsScreenState{
    data object BreakingNews : SeeAllNewsScreenState()
    data object RecommendedNews: SeeAllNewsScreenState()
}

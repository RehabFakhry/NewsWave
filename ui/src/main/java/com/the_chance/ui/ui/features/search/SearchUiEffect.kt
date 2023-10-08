package com.the_chance.ui.ui.features.search

import com.the_chance.newswave.ui.base.BaseUiEffect

sealed class SearchUiEffect: BaseUiEffect {

    data object OnClickNewsItemEffect: SearchUiEffect()
    data object OnClickBackEffect: SearchUiEffect()

}

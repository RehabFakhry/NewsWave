package com.the_chance.ui.ui.features.home

import com.the_chance.newswave.ui.base.BaseUiEffect

sealed interface HomeUiEffect: BaseUiEffect{

    data object NavigateToSearchScreenEffect: HomeUiEffect
    data object NavigateToSeeAllNewsEffect : HomeUiEffect

}
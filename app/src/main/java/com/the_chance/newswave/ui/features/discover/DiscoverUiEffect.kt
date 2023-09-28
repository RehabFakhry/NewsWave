package com.the_chance.newswave.ui.features.discover

import com.the_chance.newswave.ui.base.BaseUiEffect

sealed interface DiscoverUiEffect: BaseUiEffect {
    data object NavigateToSearchScreenEffect: DiscoverUiEffect
    data object NavigateToNewsDetailsEffect: DiscoverUiEffect
}
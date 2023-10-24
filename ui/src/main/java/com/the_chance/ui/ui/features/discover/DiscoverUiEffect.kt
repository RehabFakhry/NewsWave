package com.the_chance.ui.ui.features.discover

import com.the_chance.newswave.ui.base.BaseUiEffect

sealed interface DiscoverUiEffect: BaseUiEffect {
    data object ClickSearchIconEffect: DiscoverUiEffect
    data class ClickNewsItemEffect(val title: String): DiscoverUiEffect
}
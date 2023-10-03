package com.the_chance.ui.ui.features.news_details

import com.the_chance.newswave.ui.base.BaseUiEffect

sealed interface NewsDetailsUiEffect: BaseUiEffect{

    data object OnClickBackEffect: NewsDetailsUiEffect
}
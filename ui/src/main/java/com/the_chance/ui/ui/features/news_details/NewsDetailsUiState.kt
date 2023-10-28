package com.the_chance.ui.ui.features.news_details

import com.the_chance.domain.model.NewsArticle
import com.the_chance.domain.utill.ErrorHandler
import com.the_chance.ui.ui.features.home.NewsUiState

data class NewsDetailsUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val error: ErrorHandler? = null,
    val isEmptyNews: Boolean = false,
    val isConnectionError: Boolean = false,
    val newsItem: NewsArticlesUiState = NewsArticlesUiState(),
)

data class NewsArticlesUiState(
    val author: String = "",
    val title: String = "",
    val description: String = "",
    val url: String = "",
    val source: String = "",
    val image: String = "",
    val category: String = "",
    val country: String = "",
)

fun NewsArticle.toNewsDetailsUiState(): NewsUiState {
    return NewsUiState(
        author = author ?: "",
        title = title ?: "",
        description = description ?: "",
        url = url ?: "",
        source = source ?: "",
        image = image ?: "",
        category = category ?: "",
        country = country ?: "",
    )
}
package com.the_chance.newswave.ui.features.search

import com.the_chance.domain.model.NewsArticle
import com.the_chance.domain.utill.ErrorHandler


data class SearchUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val error: ErrorHandler? = null,
    val isConnectionError: Boolean = false,
    val searchQuery: String = "",
    val news: List<NewsUiState> = emptyList(),
    )

data class NewsUiState(
    val author: String = "",
    val title: String = "",
    val description: String = "",
    val url: String = "",
    val source: String = "",
    val image: String = "",
    val category: String = "",
    val language: String = "",
    val country: String = "",
    val publishedAt: String = "",
)

fun NewsArticle.toNewsUiState(): NewsUiState {
    return NewsUiState(
        author = author ?: "",
        title = title ?: "",
        description = description ?: "",
        url = url ?: "",
        source = source ?: "",
        image = image ?: "",
        category = category ?: "",
        language = language ?: "",
        country = country ?: "",
        publishedAt = publishedAt ?: "",
    )
}

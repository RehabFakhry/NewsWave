package com.the_chance.newswave.ui.features.discover

import com.the_chance.domain.model.NewsArticle
import com.the_chance.domain.utill.ErrorHandler


data class DiscoverUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val error: ErrorHandler? = null,
    val isEmptyNews: Boolean = false,
    val isConnectionError: Boolean = false,
    val news: List<NewsArticleUiState> = emptyList(),
    val chipSelected: ChipSelectedState = ChipSelectedState.GENERAL
)

data class NewsArticleUiState(
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

fun NewsArticle.toNewUiState(): NewsArticleUiState {
    return NewsArticleUiState(
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

enum class ChipSelectedState {
    GENERAL,
    BUSINESS,
    ENTERTAINMENT,
    HEALTH,
    SCIENCE,
    SPORTS,
    TECHNOLOGY
}

fun DiscoverUiState.general() = this.chipSelected == ChipSelectedState.GENERAL
fun DiscoverUiState.business() = this.chipSelected == ChipSelectedState.BUSINESS
fun DiscoverUiState.entertainment() = this.chipSelected == ChipSelectedState.ENTERTAINMENT
fun DiscoverUiState.health() = this.chipSelected == ChipSelectedState.HEALTH
fun DiscoverUiState.science() = this.chipSelected == ChipSelectedState.SCIENCE
fun DiscoverUiState.sports() = this.chipSelected == ChipSelectedState.SPORTS
fun DiscoverUiState.technology() = this.chipSelected == ChipSelectedState.TECHNOLOGY

fun DiscoverUiState.showDiscover() = news.isNotEmpty()

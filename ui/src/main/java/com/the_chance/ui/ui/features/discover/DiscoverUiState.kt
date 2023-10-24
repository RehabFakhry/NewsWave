package com.the_chance.ui.ui.features.discover

import com.the_chance.domain.model.NewsArticle
import com.the_chance.domain.utill.ErrorHandler

data class DiscoverUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val error: ErrorHandler? = null,
    val isEmptyNews: Boolean = false,
    val isConnectionError: Boolean = false,
    val news: List<NewsArticleUiState> = emptyList(),
    val newsItem: NewsArticleUiState = NewsArticleUiState(),
    val chipSelected: ChipSelectedState = ChipSelectedState.GENERAL
){
    val nonDeprecatedNews = news
        .distinctBy { it.title to it.image to it.country }
        .filter { !it.author.isNullOrEmpty() && !it.image.isNullOrEmpty() && !it.country.isNullOrEmpty() }
        .shuffled().take(5)
}

data class NewsArticleUiState(
    val author: String = "",
    val title: String = "",
    val description: String = "",
    val url: String = "",
    val source: String = "",
    val image: String = "",
    val category: String = "",
    val country: String = "",
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
        country = country?.convertCountryCodeToFullName() ?: "",
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

fun String.convertCountryCodeToFullName(): String {
    val countryMap = mapOf(
        "eg" to "Egypt",
        "tr" to "Turkey",
        "mo" to "Morocco",
        "sa" to "Saudi Arabia",
        "us" to "United States",
        "uk" to "United Kingdom",
        "ca" to "Canada",
        "au" to "Australia",
        "nz" to "New Zealand",
        "ar" to "Argentina",
        "br" to "Brazil",
        "co" to "Colombia",
        "de" to "Germany",
        "in" to "India",
        "bg" to "Bulgaria",
        "it" to "Italy",
        "fr" to "France",
        "mx" to "Mexico",
        "za" to "South Africa",
    )

    val countryCode = this.toLowerCase()
    return countryMap[countryCode] ?: this // Return the original code if not found in the map
}

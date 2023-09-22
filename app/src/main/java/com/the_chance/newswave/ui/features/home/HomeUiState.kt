package com.the_chance.newswave.ui.features.home

import android.annotation.SuppressLint
import com.the_chance.domain.model.NewsArticle
import com.the_chance.domain.utill.ErrorHandler
import java.text.SimpleDateFormat
import java.util.Date


data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val error: ErrorHandler? = null,
    val news: List<NewsUiState> = emptyList(),
    val currentNews: List<NewsUiState> = emptyList(),
    ) {
    val shuffledNews = news.filter { !it.image.isNullOrEmpty() }.shuffled().take(3)
}

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
        author = author?: "",
        title = title,
        description = description,
        url = url,
        source = source,
        image = image?: "",
        category = category,
        language = language,
        country = country,
        publishedAt = publishedAt,
    )
}

fun HomeUiState.showHome() = news.isNotEmpty()


@SuppressLint("SimpleDateFormat")
fun Date.toDateFormat(): String {
    val dateFormat = SimpleDateFormat("dd MMM  HH:mm")
    return dateFormat.format(this)
}
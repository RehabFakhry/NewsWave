package com.the_chance.newswave.ui.features.home

import android.os.Build
import androidx.annotation.RequiresApi
import com.the_chance.domain.model.NewsArticle
import com.the_chance.domain.utill.ErrorHandler
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.features.discover.ChipSelectedState
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val error: ErrorHandler? = null,
    val isConnectionError: Boolean = false,
    val news: List<NewsUiState> = emptyList(),
    val currentNews: List<NewsUiState> = emptyList(),
    val chipSelected: ChipSelectedState = ChipSelectedState.GENERAL
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

val worldNewsImages: List<Int> = listOf(
    R.drawable.egypt_flag,
    R.drawable.canada_flag,
    R.drawable.barzil_flag,
    R.drawable.australia_flag,
    R.drawable.germany_flag,
    R.drawable.frence_flag,
    R.drawable.greece_flag,
    R.drawable.italy_flag,
    R.drawable.morocco_flag,
    R.drawable.hong_kong_flag,
    )

fun HomeUiState.showHome() = news.isNotEmpty() && currentNews.isNotEmpty()

@RequiresApi(Build.VERSION_CODES.O)
fun String.formatPublishedDate(): String {
    val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
    val publishedDateTime = LocalDateTime.parse(this, dateFormatter)
    val now = LocalDateTime.now()
    val daysAgo = Duration.between(publishedDateTime, now).toDays()

    return when {
        daysAgo < 1 -> "Today"
        daysAgo == 1L -> "Yesterday"
        else -> "$daysAgo days ago"
    }
}

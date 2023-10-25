package com.the_chance.ui.ui.features.home

import com.the_chance.domain.model.NewsArticle
import com.the_chance.domain.utill.ErrorHandler
import com.the_chance.ui.R
import com.the_chance.ui.ui.features.discover.ChipSelectedState
import java.time.Duration
import java.time.ZonedDateTime
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
    val newsNotNull = news.distinctBy { it.image }
    val shuffledCurrentNews = currentNews.shuffled().take(6)
    val randomNonDeprecatedNews = news
        .distinctBy { it.author to it.title to it.image to it.category to it.publishedAt }
        .filter { !it.author.isNullOrEmpty() && !it.image.isNullOrEmpty() }
        .shuffled().take(5)
}

data class NewsUiState(
    val author: String = "",
    val title: String = "",
    val description: String = "",
    val url: String = "",
    val source: String = "",
    val image: String = "",
    val category: String = "",
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
        country = country ?: "",
        publishedAt = publishedAt?.formatPublishedDate() ?: "",
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

fun String.formatPublishedDate(): String {
    val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")
    val publishedDateTime = ZonedDateTime.parse(this, dateFormatter)
    val now = ZonedDateTime.now()
    val daysAgo = Duration.between(publishedDateTime, now).toDays()

    return when {
        daysAgo < 1 -> "Today"
        daysAgo == 1L -> "Yesterday"
        daysAgo < 7 -> "$daysAgo day${if (daysAgo > 1) "s" else ""} ago"
        daysAgo < 14 -> "1 week ago"
        daysAgo < 21 -> "2 weeks ago"
        daysAgo < 28 -> "3 weeks ago"
        daysAgo < 30 -> "4 weeks ago"
        else -> {
            val monthsAgo = (daysAgo / 30).toInt()
            if (monthsAgo == 1)
                " 1 month ago"
            else
                "$monthsAgo months ago"
        }
    }
}

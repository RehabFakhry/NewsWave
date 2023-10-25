package com.the_chance.domain.usecase

import com.the_chance.domain.model.NewsArticle
import com.the_chance.domain.repository.NewsRepository
import java.time.LocalDate
import javax.inject.Inject

class GetAllNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository,
) {
    suspend operator fun invoke(currentDate: LocalDate): List<NewsArticle> {
        val oneMonthAgo = currentDate.minusMonths(1)
        val dateRange = "$oneMonthAgo,$currentDate"
        return newsRepository.getAllNews(dateRange) ?: emptyList()
    }
}
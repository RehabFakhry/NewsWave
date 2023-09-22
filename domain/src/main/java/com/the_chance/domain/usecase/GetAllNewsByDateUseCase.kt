package com.the_chance.domain.usecase

import com.the_chance.domain.model.NewsArticle
import com.the_chance.domain.repository.NewsRepository
import javax.inject.Inject

class GetAllNewsByDateUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(date: String): List<NewsArticle> {
        return newsRepository.getAllNewsByDate(date)?: emptyList()
    }
}
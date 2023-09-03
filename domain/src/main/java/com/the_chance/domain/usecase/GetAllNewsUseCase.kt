package com.the_chance.domain.usecase

import com.the_chance.domain.model.NewsArticle
import com.the_chance.domain.repository.NewsRepository
import javax.inject.Inject

class GetAllNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository,
) {
    suspend operator fun invoke(): List<NewsArticle> {
        return newsRepository.getAllNews() ?: emptyList()
    }
}
package com.the_chance.data.repository

import com.the_chance.data.source.remote.mapper.toNewsArticle
import com.the_chance.data.source.remote.network.NewsService
import com.the_chance.domain.model.NewsArticle
import com.the_chance.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService
) : BaseRepository(), NewsRepository {
    override suspend fun getAllNews(dateRange: String): List<NewsArticle> {
        return (wrap { newsService.getNewsArticle(dateRange) }.data.map { it.toNewsArticle() })
    }

    override suspend fun getAllNewsByDate(date: String): List<NewsArticle> {
        return (wrap { newsService.getNewsArticleByDate(date) }.data.map { it.toNewsArticle() })
    }

    override suspend fun getAllNewsByCategory(category: String): List<NewsArticle> {
        return (wrap { newsService.getNewsArticleByCategory(category) }.data.map { it.toNewsArticle() })
    }

    override suspend fun searchForNewsArticle(query: String): List<NewsArticle>? {
        return (wrap { newsService.searchForNewsArticle(query) }.data.map { it.toNewsArticle() })
    }
}
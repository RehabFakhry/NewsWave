package com.the_chance.data.repository

import com.the_chance.data.source.remote.mapper.toNewsArticleEntity
import com.the_chance.data.source.remote.network.NewsService
import com.the_chance.domain.model.NewsArticle
import com.the_chance.domain.repository.NewsRepository
import com.the_chance.domain.utill.NotFoundException
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService
) : BaseRepository(), NewsRepository {
    override suspend fun getAllNews(): List<NewsArticle> {
        return (wrap { newsService.getNewsArticle() }.data?.map { it?.toNewsArticleEntity()!! }
            ?: throw NotFoundException())
    }
}

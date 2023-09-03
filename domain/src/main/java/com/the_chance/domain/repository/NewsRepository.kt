package com.the_chance.domain.repository

import com.the_chance.domain.model.NewsArticle

interface NewsRepository {
    suspend fun getAllNews(): List<NewsArticle>?
}
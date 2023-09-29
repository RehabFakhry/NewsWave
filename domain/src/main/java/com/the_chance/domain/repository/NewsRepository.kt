package com.the_chance.domain.repository

import com.the_chance.domain.model.NewsArticle

interface NewsRepository {
    suspend fun getAllNews(): List<NewsArticle>?

    suspend fun getAllNewsByDate(date: String): List<NewsArticle>?

    suspend fun getAllNewsByCategory(category: String): List<NewsArticle>?

    suspend fun searchForNewsArticle(query: String): List<NewsArticle>?

}
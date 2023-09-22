package com.the_chance.data.source.remote.network

import com.the_chance.data.source.remote.models.NewsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("news")
    suspend fun getNewsArticle(): Response<NewsDto>
    suspend fun getNewsArticleByDate(@Query("date") date: String): Response<NewsDto>

//    @GET("news")

}

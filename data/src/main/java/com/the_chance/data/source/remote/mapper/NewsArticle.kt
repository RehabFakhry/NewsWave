package com.the_chance.data.source.remote.mapper

import com.the_chance.data.source.remote.models.NewsDto
import com.the_chance.domain.model.NewsArticle

fun NewsDto.Data.toNewsArticleEntity() = NewsArticle(
    author = author?: "",
    title = title ,
    description = description ,
    url = url ,
    source = source ,
    image = image?: "" ,
    category = category ,
    language = language ,
    country = country ,
    publishedAt = publishedAt ,
)
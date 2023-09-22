package com.the_chance.data.source.remote.models


import com.google.gson.annotations.SerializedName

data class NewsDto(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("pagination")
    val pagination: Pagination
) {
    data class Data(
        @SerializedName("author")
        val author: String?,
        @SerializedName("category")
        val category: String,
        @SerializedName("country")
        val country: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("image")
        val image: String?,
        @SerializedName("language")
        val language: String,
        @SerializedName("published_at")
        val publishedAt: String,
        @SerializedName("source")
        val source: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("url")
        val url: String
    )

    data class Pagination(
        @SerializedName("count")
        val count: Int,
        @SerializedName("limit")
        val limit: Int,
        @SerializedName("offset")
        val offset: Int,
        @SerializedName("total")
        val total: Int
    )
}
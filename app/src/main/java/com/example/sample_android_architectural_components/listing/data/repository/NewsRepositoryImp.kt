package com.example.sample_android_architectural_components.listing.data.repository

import com.example.sample_android_architectural_components.listing.data.model.LikesCommentsApiResponse
import com.example.sample_android_architectural_components.listing.data.api.NewsDataSource
import com.example.sample_android_architectural_components.listing.data.model.NewsListingApiResponse


class NewsRepositoryImp(private val newsDataSource: NewsDataSource) : NewsRepository {

    override suspend fun getTopNews(country: String, apiKey: String): NewsListingApiResponse {
        return newsDataSource.getTopNews(country, apiKey)
    }

    override suspend fun getComments(url: String): LikesCommentsApiResponse {
        return newsDataSource.getComments(url)
    }

    override suspend fun getLikes(url: String): LikesCommentsApiResponse {
        return newsDataSource.getLikes(url)
    }
}
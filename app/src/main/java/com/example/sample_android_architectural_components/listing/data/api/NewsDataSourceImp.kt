package com.example.sample_android_architectural_components.listing.data.api

import com.example.sample_android_architectural_components.listing.data.model.CommentsApiResponse
import com.example.sample_android_architectural_components.listing.data.model.LikesApiResponse
import com.example.sample_android_architectural_components.listing.data.model.NewsListingApiResponse


class NewsDataSourceImp(private val newsApiServices: NewsApiServices) : NewsDataSource {

    override suspend fun getTopNews(country: String, apiKey: String): NewsListingApiResponse {
        return newsApiServices.getTopNews(country, apiKey)
    }

    override suspend fun getComments(url: String): CommentsApiResponse {
        return newsApiServices.getComments(url)
    }

    override suspend fun getLikes(url: String): LikesApiResponse {
        return newsApiServices.getLikes(url)
    }
}
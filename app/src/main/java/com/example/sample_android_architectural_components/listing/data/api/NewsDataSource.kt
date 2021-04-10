package com.example.sample_android_architectural_components.listing.data.api

import com.example.sample_android_architectural_components.listing.data.model.LikesCommentsApiResponse
import com.example.sample_android_architectural_components.listing.data.model.NewsListingApiResponse

interface NewsDataSource {
    suspend fun getTopNews(
        country: String, apiKey: String
    ): NewsListingApiResponse

    suspend fun getComments(
        url: String
    ): LikesCommentsApiResponse

    suspend fun getLikes(
        url: String
    ): LikesCommentsApiResponse
}
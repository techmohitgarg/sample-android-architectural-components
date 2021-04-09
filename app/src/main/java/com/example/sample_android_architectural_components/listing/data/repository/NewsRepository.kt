package com.example.sample_android_architectural_components.listing.data.repository

import com.example.sample_android_architectural_components.listing.data.model.CommentsApiResponse
import com.example.sample_android_architectural_components.listing.data.model.LikesApiResponse
import com.example.sample_android_architectural_components.listing.data.model.NewsListingApiResponse

interface NewsRepository {
    suspend fun getTopNews(country: String, apiKey: String): NewsListingApiResponse
    suspend fun getComments(url: String): CommentsApiResponse
    suspend fun getLikes(url: String): LikesApiResponse
}
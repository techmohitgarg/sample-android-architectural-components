package com.example.sample_android_architectural_components.listing.data.api

import com.example.sample_android_architectural_components.listing.data.model.LikesCommentsApiResponse
import com.example.sample_android_architectural_components.listing.data.model.NewsListingApiResponse
import com.example.sample_android_architectural_components.network.NetWorkConfigurations
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


interface NewsApiServices {

    @GET(NetWorkConfigurations.top_headlines)
    suspend fun getTopNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): NewsListingApiResponse

    @GET
    suspend fun getComments(
        @Url url: String
    ): LikesCommentsApiResponse

    @GET
    suspend fun getLikes(
        @Url url: String
    ): LikesCommentsApiResponse
}
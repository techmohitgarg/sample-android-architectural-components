package com.example.sample_android_architectural_components.listing.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsListingApiResponse(
    val status: String, val totalResults: Int, val articles: List<Articles>
) : Parcelable

@Parcelize
data class Articles(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
) : Parcelable
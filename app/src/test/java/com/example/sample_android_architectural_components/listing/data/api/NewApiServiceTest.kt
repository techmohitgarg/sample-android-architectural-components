package com.example.sample_android_architectural_components.listing.data.api

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.sample_android_architectural_components.R
import com.example.sample_android_architectural_components.listing.data.model.LikesCommentsApiResponse
import com.example.sample_android_architectural_components.listing.data.model.NewsListingApiResponse
import com.example.sample_android_architectural_components.utils.Util
import org.junit.Before


class NewApiServiceTest : NewsApiServices {

    lateinit var util: Util
    private val context: Context = ApplicationProvider.getApplicationContext()


    @Before
    fun setUp() {
        util = Util()
    }

    override suspend fun getTopNews(country: String, apiKey: String): NewsListingApiResponse {
        val jsonString: String = util.getStringFromRawResource(context, R.raw.list_api_response)
        return util.convertJsonToObject(jsonString, NewsListingApiResponse::class.java)
    }

    override suspend fun getComments(url: String): LikesCommentsApiResponse {
        val jsonString: String = util.getStringFromRawResource(context, R.raw.commnet_api_reponse)
        return util.convertJsonToObject(jsonString, LikesCommentsApiResponse::class.java)
    }

    override suspend fun getLikes(url: String): LikesCommentsApiResponse {
        val jsonString: String = util.getStringFromRawResource(context, R.raw.like_api_reponse)
        return util.convertJsonToObject(jsonString, LikesCommentsApiResponse::class.java)
    }
}
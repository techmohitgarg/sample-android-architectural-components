package com.example.sample_android_architectural_components.listing.data.api

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sample_android_architectural_components.DummyTestCaseApplication
import com.example.sample_android_architectural_components.R
import com.example.sample_android_architectural_components.Utils
import com.example.sample_android_architectural_components.listing.data.model.LikesCommentsApiResponse
import com.example.sample_android_architectural_components.listing.data.model.NewsListingApiResponse
import com.example.sample_android_architectural_components.listing.data.repository.NewsRepository
import com.example.sample_android_architectural_components.listing.data.repository.NewsRepositoryImp
import com.example.sample_android_architectural_components.utils.Constants
import com.example.sample_android_architectural_components.utils.Util
import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.annotation.Config
import kotlin.test.assertNotNull

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@Config(application = DummyTestCaseApplication::class)
class NewsRepositoryTest {

    private lateinit var newsApiServices: NewApiServiceTest
    private lateinit var newsRepository: NewsRepository
    private lateinit var util: Util
    private val context: Context? = ApplicationProvider.getApplicationContext()

    @get:Rule
    val testCoroutineRule = Utils.TestCoroutineRule()

    @Before
    fun setUp() {
        newsApiServices = mock()
        util = Util()
        newsRepository = NewsRepositoryImp(NewsDataSourceImp(newsApiServices))
    }


    @Test
    fun `test getTopNews api return response`() {
        testCoroutineRule.runBlockingTest {
            // Given
            val jsonString: String = util.getStringFromRawResource(context, R.raw.list_api_response)
            whenever(newsApiServices.getTopNews(any(), any())).thenReturn(
                util.convertJsonToObject(
                    jsonString,
                    NewsListingApiResponse::class.java
                )
            )
            //when
            newsRepository.getTopNews(
                country = Constants.country_code,
                apiKey = Constants.api_key
            )
            //then
            verify(newsApiServices, atLeastOnce()).getTopNews(
                country = Constants.country_code,
                apiKey = Constants.api_key
            )
        }
    }

    @Test
    fun `test getLikes api return response`() {
        testCoroutineRule.runBlockingTest {
            // Given
            val jsonString: String = util.getStringFromRawResource(context, R.raw.like_api_reponse)
            whenever(newsApiServices.getLikes(any())).thenReturn(
                util.convertJsonToObject(
                    jsonString,
                    LikesCommentsApiResponse::class.java
                )
            )
            //when
            val articleID =
                util.getArticleID("https://www.nbcnews.com/news/world/bbc-sets-complaints-line-too-much-tv-coverage-prince-philip-n1263711")
            newsRepository.getLikes(articleID)

            //then
            verify(newsApiServices, atLeastOnce()).getLikes(articleID)
        }
    }

    @Test
    fun `test getComments api return response`() {
        testCoroutineRule.runBlockingTest {
            // Given
            val jsonString: String =
                util.getStringFromRawResource(context, R.raw.commnet_api_reponse)
            whenever(newsApiServices.getComments(any())).thenReturn(
                util.convertJsonToObject(
                    jsonString,
                    LikesCommentsApiResponse::class.java
                )
            )
            //when
            val articleID =
                util.getArticleID("https://www.nbcnews.com/news/world/bbc-sets-complaints-line-too-much-tv-coverage-prince-philip-n1263711")
            newsRepository.getComments(articleID)

            //then
            verify(newsApiServices, atLeastOnce()).getComments(articleID)
        }
    }


}
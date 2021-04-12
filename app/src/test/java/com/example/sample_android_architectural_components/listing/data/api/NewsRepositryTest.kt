package com.example.sample_android_architectural_components.listing.data.api

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sample_android_architectural_components.DummyTestCaseApplication
import com.example.sample_android_architectural_components.listing.data.repository.NewsRepository
import com.example.sample_android_architectural_components.listing.data.repository.NewsRepositoryImp
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.annotation.Config
import kotlin.test.assertNotNull

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@Config(application = DummyTestCaseApplication::class)
class NewsRepositryTest {

    var newsApiServices: NewApiServiceTest = Mockito.mock(NewApiServiceTest::class.java)
    lateinit var newsRepository: NewsRepository

    @Before
    fun setUp() {
        newsRepository = NewsRepositoryImp(NewsDataSourceImp(newsApiServices))
    }


    @Test
    fun `test getTopNews api response`() {
        runBlockingTest {
            val response = newsRepository.getTopNews("", "")
            assertNotNull(response)
        }
    }
}
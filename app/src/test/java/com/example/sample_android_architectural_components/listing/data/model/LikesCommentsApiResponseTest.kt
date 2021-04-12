package com.example.sample_android_architectural_components.listing.data.model

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sample_android_architectural_components.DummyTestCaseApplication
import com.example.sample_android_architectural_components.R
import com.example.sample_android_architectural_components.utils.Util
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@RunWith(AndroidJUnit4::class)
@Config(application = DummyTestCaseApplication::class)
class LikesCommentsApiResponseTest {

    private lateinit var util: Util
    private val context: Context = ApplicationProvider.getApplicationContext()


    @Before
    fun setUp() {
        util = Util()
    }


    @Test
    fun `test_deserialization_like_api_response`() {
        val jsonString: String = util.getStringFromRawResource(context, R.raw.like_api_reponse)
        assertNotNull(jsonString)
        val likesCommentsApiResponse: LikesCommentsApiResponse =
            util.convertJsonToObject(jsonString, LikesCommentsApiResponse::class.java)
        assertNotNull(likesCommentsApiResponse)

        assertEquals(10, likesCommentsApiResponse.likes)
        assertEquals(0, likesCommentsApiResponse.comments)
    }

    @Test
    fun `test_deserialization_comment_api_response`() {
        val jsonString: String = util.getStringFromRawResource(context, R.raw.commnet_api_reponse)
        assertNotNull(jsonString)
        val likesCommentsApiResponse: LikesCommentsApiResponse =
            util.convertJsonToObject(jsonString, LikesCommentsApiResponse::class.java)
        assertNotNull(likesCommentsApiResponse)

        assertEquals(0, likesCommentsApiResponse.likes)
        assertEquals(20, likesCommentsApiResponse.comments)
    }
}
package com.example.sample_android_architectural_components.listing.ui.main.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.example.sample_android_architectural_components.R
import com.example.sample_android_architectural_components.listing.data.model.Articles
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ListItemDetailsActivityTest {

    var mContext: Context? = null

    @get:Rule
    var mRule: ActivityTestRule<ListItemDetailsActivity> =
        ActivityTestRule(ListItemDetailsActivity::class.java, false, false)

    @Before
    fun setUp() {
        mContext = ApplicationProvider.getApplicationContext()
    }


    @Test
    fun testListActivity_whenLaunched_And_DisplayTheListData() {
        val bundle = Bundle()
        val articles: Articles = setArticleIntentData()
        bundle.putParcelable("data", articles)
        val intent = Intent(mContext, ListItemDetailsActivity::class.java)
        intent.putExtras(bundle)
        mRule.launchActivity(intent)


        onView(withId(R.id.img)).check(matches(isDisplayed()))
        onView(withId(R.id.txtAuthor)).check(matches(withText(articles.author)))
        onView(withId(R.id.txtTitle)).check(matches(withText(articles.title)))
        onView(withId(R.id.txtDescription)).check(matches(withText(articles.description)))
        onView(withId(R.id.txtLikesCount)).check(matches(isDisplayed()))
        onView(withId(R.id.txtCommentCount)).check(matches(isDisplayed()))
    }


    private fun setArticleIntentData(): Articles {
        return Articles(
            "Variety",
            "BBC sets up complaints line for 'too much TV coverage' of Prince Philip's death - NBC News",
            "The BBC has set up a complaints line after getting complaints of too much television coverage of the death of Prince Philip, Duke of Edinburgh. He died at the age of 99.",
            "https://www.nbcnews.com/news/world/bbc-sets-complaints-line-too-much-tv-coverage-prince-philip-n1263711",
            "https://media2.s-nbcnews.com/j/newscms/2021_06/3449445/210211-bbc-hq-london-jm-1354_ad8cb95e88b0ea311ec57600110f9f6f.nbcnews-fp-1200-630.jpg",
            "2021-04-10T03:31:00Z",
            "LOS ANGELES The BBC has set up a dedicated complaints page for viewers fed up with its blanket coverage of the death of Prince Philip."
        )

    }
}
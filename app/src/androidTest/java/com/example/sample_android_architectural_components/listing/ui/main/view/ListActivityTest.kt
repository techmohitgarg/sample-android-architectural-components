package com.example.sample_android_architectural_components.listing.ui.main.view

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.example.sample_android_architectural_components.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ListActivityTest {
    var mContext: Context? = null

    @get:Rule
    var mRule: ActivityTestRule<ListActivity> =
        ActivityTestRule(ListActivity::class.java, false, false)

    @Before
    fun setUp() {
        mContext = ApplicationProvider.getApplicationContext()
    }


    @Test
    fun testListActivity_whenLaunched_And_DisplayTheListData() {
        val intent = Intent(mContext, ListActivity::class.java)
        mRule.launchActivity(intent)
        onView(withId(R.id.progressBar)).check(matches(isDisplayed()))
        // Adding the 5 sec sleep here until the api response load
        Thread.sleep(5000)
        onView(withId(R.id.rv_list_articles)).check(matches(isDisplayed()))
    }
}
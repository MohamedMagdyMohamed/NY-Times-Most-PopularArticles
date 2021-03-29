package com.example.nytimesmostpopulararticles.ui.articleslist

import android.os.SystemClock
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.navigation.findNavController
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread
import com.example.nytimesmostpopulararticles.R
import com.example.nytimesmostpopulararticles.base.BaseUITest
import com.example.nytimesmostpopulararticles.di.generateTestAppComponent
import com.example.nytimesmostpopulararticles.ui.activities.MainActivity
import com.example.nytimesmostpopulararticles.utils.TestUtils
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import java.net.HttpURLConnection

@RunWith(AndroidJUnit4::class)
class ArticlesListTest : BaseUITest() {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    var mActivityTestRule = activityScenarioRule<MainActivity>()

    private val onePosition = 0
    private val mTitleTestOne = "Teen Vogue Editor Resigns After Fury Over Racist Tweets"
    private val mByLineTestOne = "By Katie Robertson"

    @Before
    fun start() {
        super.setUp()
        loadKoinModules(generateTestAppComponent(getMockWebServerUrl()).toMutableList())
        mActivityTestRule.scenario.onActivity {
            runOnUiThread {
                it.findNavController(R.id.main_nav_fragment).navigate(R.id.articlesListFragment)
            }
        }
    }

    @Test
    fun test_recyclerview_first_element_for_expected_response() {
        mockNetworkResponseWithFileContent("articles-list.json", HttpURLConnection.HTTP_OK)

        //Wait for MockWebServer to get back with response
        SystemClock.sleep(1000)

        onView(
            TestUtils.withRecyclerView(R.id.rvArticles)?.atPositionOnView(onePosition, R.id.tvTitle)
        ).check(matches(withText(mTitleTestOne)))
        onView(
            TestUtils.withRecyclerView(R.id.rvArticles)
                ?.atPositionOnView(onePosition, R.id.tvByLine)
        ).check(matches(withText(mByLineTestOne)))
    }
}

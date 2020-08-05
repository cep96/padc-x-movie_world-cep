package com.cep.moviesworld.uitests

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.cep.moviesworld.R
import com.cep.moviesworld.activities.MainActivity
import com.cep.moviesworld.views.viewholders.BestPopularFilmsAndSerialsViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class GoMovieDetailsTest {

    private val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    open fun setUp(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun onTapMovie_GoToMovieDetails(){
        onView(withId(R.id.rvPopularFilmsAndSerials))
            .perform(RecyclerViewActions.actionOnItemAtPosition<BestPopularFilmsAndSerialsViewHolder>(0, click()))
        onView(withId(R.id.ivMovieImage))
            .check(matches(isDisplayed()))
    }
}
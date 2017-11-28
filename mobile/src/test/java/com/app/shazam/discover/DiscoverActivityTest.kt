package com.app.shazam.discover

import org.junit.runner.RunWith
import android.support.test.runner.AndroidJUnit4
import android.test.suitebuilder.annotation.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.app.shazam.R
import org.junit.Rule
import org.junit.Test

/**
 * Created by Ajax on 11/28/2017.
 */


@RunWith(AndroidJUnit4::class)

@LargeTest
class DiscoverActivityTest {

	@JvmField
	@Rule
	val mDiscoverActivityTestRule = ActivityTestRule<DiscoverActivity>(DiscoverActivity::class.java)

	@Test
	fun onViewLoadDiscoverFragment() {
		onView(withId(R.id.discoverFragmentView)).check(matches(isDisplayed()))
	}
}
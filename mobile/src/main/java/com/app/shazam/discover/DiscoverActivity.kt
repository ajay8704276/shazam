package com.app.shazam.discover

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.app.shazam.R
import com.app.shazam.utils.FragmentUtils

class DiscoverActivity : AppCompatActivity() {

	private val TAG_DISCOVER_FRAGMENT = "DiscoverFragment"

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_discover)

		val  discoverfragment = DiscoverFragment();
		supportFragmentManager.beginTransaction()
				.add(R.id.discoverFragmentContainer , discoverfragment,TAG_DISCOVER_FRAGMENT)
				.commit()

		// add fragment here
		//FragmentUtils.addIfNotExist(supportFragmentManager,R.id.discoverFragmentContainer,DiscoverFragment(),"DiscoverFragment")
	}
}

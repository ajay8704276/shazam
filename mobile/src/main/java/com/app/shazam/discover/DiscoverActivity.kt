package com.app.shazam.discover

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.app.shazam.R
import com.app.shazam.utils.FragmentUtils

class DiscoverActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_discover)

		// add fragment here
		FragmentUtils.addIfNotExist(supportFragmentManager,R.id.discoverFragmentContainer,DiscoverFragment(),"DiscoverFragment")
	}
}

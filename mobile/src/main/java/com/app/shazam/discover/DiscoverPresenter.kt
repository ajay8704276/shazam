package com.app.shazam.discover

import com.app.shazam.data.identify.Song
import com.app.shazam.data.identify.SongIdentifyService

/**
 * Created by admin on 15/12/17.
 */
class DiscoverPresenter(private val songIdentifyService: SongIdentifyService) : DiscoverContract.Presenter, SongIdentifyService.SongIdentificationCallback {

    private var mDiscoverView: DiscoverContract.View? = null

    override fun onOfflineError() {

        mDiscoverView?.hideIdentifyProgressView()
        mDiscoverView?.showStartIdentifyButtonView()
        mDiscoverView?.hideStopIdentifyButtonView()
        mDiscoverView?.showOfflineErrorView()
    }

    override fun genericError() {

        mDiscoverView?.hideIdentifyProgressView()
        mDiscoverView?.showStartIdentifyButtonView()
        mDiscoverView?.hideStopIdentifyButtonView()
        mDiscoverView?.showGenericErrorView()
    }

    override fun songNotFoundError() {


        mDiscoverView?.hideIdentifyProgressView()
        mDiscoverView?.showStartIdentifyButtonView()
        mDiscoverView?.hideStopIdentifyButtonView()
        mDiscoverView?.showNotFoundErrorView()
    }

    override fun onSongFound(song: Song) {

        mDiscoverView?.hideIdentifyProgressView()
        mDiscoverView?.showStartIdentifyButtonView()
        mDiscoverView?.hideStopIdentifyButtonView()
        mDiscoverView?.openSongDetailPage(song)

    }


    override fun takeView(view: DiscoverContract.View) {

        mDiscoverView = view

    }

    override fun dropView() {

        mDiscoverView = null
    }

    override fun onStartIdentifyButtonClicked() {

        mDiscoverView?.hideStartIdentifyButtonView()
        mDiscoverView?.showStopIdentifyButtonView()
        mDiscoverView?.showIdentifyProgressView()
        mDiscoverView?.hideErrorViews()
        songIdentifyService.startIdentification(this)
    }

    override fun onStopIdentifyButtonClicked() {

        songIdentifyService.stopIdentification()
        mDiscoverView?.hideIdentifyProgressView()
        mDiscoverView?.hideStopIdentifyButtonView()
        mDiscoverView?.showStartIdentifyButtonView()
    }

    override fun onDonateButtonClicked() {

        mDiscoverView?.openDonatePage()
    }

    override fun onHistoryButtonClicked() {


        mDiscoverView?.openHistoryPage()

    }
}
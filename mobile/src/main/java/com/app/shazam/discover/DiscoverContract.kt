package com.app.shazam.discover

import android.view.View
import com.app.shazam.BasePresenter
import com.app.shazam.BaseView

/**
 * Created by admin on 15/12/17.
 */
interface DiscoverContract {

    interface View: BaseView<Presenter> {

        fun showIdentifyProgressView()
        fun hideIdentifyProgressView()
        fun showStartIdentifyButtonView()
        fun hideStartIdentifyButtonView()
        fun showStopIdentifyButtonView()
        fun hideStopIdentifyButtonView()
        fun showOfflineErrorView()
        fun showGenericErrorView()
        fun showNotFoundErrorView()
        fun hideErrorViews()
        fun openSongDetailPage(song: Song)
        fun openDonatePage()
        fun openHistoryPage()

    }


    interface Presenter: BasePresenter<View> {

        fun onStartIdentifyButtonClicked()
        fun onStopIdentifyButtonClicked()
        fun onDonateButtonClicked()
        fun onHistoryButtonClicked()

    }
}
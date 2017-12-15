package com.app.shazam.discover


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.shazam.R
import kotlinx.android.synthetic.main.fragment_discover.*


/**
 * A simple [Fragment] subclass.
 *
 */
class DiscoverFragment : Fragment(), DiscoverContract.View {


    private lateinit var mDiscoverPresenter: DiscoverContract.Presenter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mDiscoverPresenter = DiscoverPresenter(Injection
                .provideSongIdentifyService(activity!!.applicationContext))
        mDiscoverPresenter.takeView(this)
        discoverStartIdentifyButton.setOnClickListener({ mDiscoverPresenter.onStartIdentifyButtonClicked() })
        discoverStopIdentifyButton.setOnClickListener({ mDiscoverPresenter.onStopIdentifyButtonClicked() })
        discoverHistoryButton.setOnClickListener({ mDiscoverPresenter.onHistoryButtonClicked() })
        discoverDonateButton.setOnClickListener({ mDiscoverPresenter.onDonateButtonClicked() })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        mDiscoverPresenter.dropView()
    }

    override fun showIdentifyProgressView() {

        discoverIdentifyProgressView.visibility = View.VISIBLE
    }

    override fun hideIdentifyProgressView() {


        discoverIdentifyProgressView.visibility = View.GONE
    }

    override fun showStartIdentifyButtonView() {


        discoverStartIdentifyButton.visibility = View.VISIBLE
    }

    override fun hideStartIdentifyButtonView() {


        discoverStartIdentifyButton.visibility = View.GONE
    }

    override fun showStopIdentifyButtonView() {


        discoverStopIdentifyButton.visibility = View.VISIBLE
    }

    override fun hideStopIdentifyButtonView() {


        discoverStopIdentifyButton.visibility = View.GONE
    }

    override fun showOfflineErrorView() {


        activity?.let {
            AlertDialog.Builder(it)
                    .setTitle(R.string.discoverErrorTitle)
                    .setMessage(R.string.discoverErrorOfflineMessage)
                    .setPositiveButton(android.R.string.ok, { dialogInterface, _ -> dialogInterface.dismiss() })
                    .show()
        }
    }

    override fun showGenericErrorView() {


        activity?.let {
            AlertDialog.Builder(it)
                    .setTitle(R.string.discoverErrorTitle)
                    .setMessage(R.string.discoverErrorGenericMessage)
                    .setPositiveButton(android.R.string.ok, { dialogInterface, _ -> dialogInterface.dismiss() })
                    .show()
        }
    }

    override fun showNotFoundErrorView() {

        activity?.let {
            AlertDialog.Builder(it)
                    .setTitle(R.string.discoverErrorTitle)
                    .setMessage(R.string.discoverErrorNotFoundMessage)
                    .setPositiveButton(android.R.string.ok, { dialogInterface, _ -> dialogInterface.dismiss() })
                    .show()
        }
    }

    override fun hideErrorViews() {
    }

    override fun openSongDetailPage(song:) {

        activity?.let { SongDetailActivity.start(it, song) }
    }

    override fun openDonatePage() {

        activity?.let { DonateActivity.start(it) }
    }

    override fun openHistoryPage() {

        activity?.let { HistoryActivity.start(it) }
    }


}

package com.app.shazam.data.identify

/**
 * Created by admin on 15/12/17.
 */
interface SongIdentifyService {

    fun startIdentification(callback : SongIdentificationCallback)
    fun stopIdentification()

    interface  SongIdentificationCallback {
        fun onOfflineError()
        fun genericError()
        fun songNotFoundError()
        fun onSongFound(song : Song)
    }
}
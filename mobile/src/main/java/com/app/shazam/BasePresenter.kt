package com.app.shazam

/**
 * Created by admin on 15/12/17.
 */
interface BasePresenter<in V> {


    fun takeView(view: V)

    fun dropView()

}
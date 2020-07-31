package com.cep.moviesworld.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.cep.moviesworld.mvp.views.MainView

class MainPresenterImpl: MainPresenter, AbstractBasePresenter<MainView>() {

    private val strArray: List<String> = arrayListOf("1", "2", "3", "4", "5")

    override fun onUIReadyForPopularFilmsAndSerials(lifecycleOwner: LifecycleOwner) {
        mView?.displayPopularFilmsAndSerials(strArray)
    }

    override fun onUIReadyForShowcases(lifecycleOwner: LifecycleOwner) {
        mView?.displayShowcases(strArray)
    }

    override fun onUIReadyForActors(lifecycleOwner: LifecycleOwner) {
        mView?.displayBestActors(strArray)
    }

}
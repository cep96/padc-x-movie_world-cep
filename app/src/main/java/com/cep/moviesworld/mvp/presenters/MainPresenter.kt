package com.cep.moviesworld.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.cep.moviesworld.mvp.views.MainView

interface MainPresenter: BasePresenter<MainView> {

    fun onUIReadyForPopularFilmsAndSerials(lifecycleOwner: LifecycleOwner)
    fun onUIReadyForShowcases(lifecycleOwner: LifecycleOwner)
    fun onUIReadyForActors(lifecycleOwner: LifecycleOwner)
}
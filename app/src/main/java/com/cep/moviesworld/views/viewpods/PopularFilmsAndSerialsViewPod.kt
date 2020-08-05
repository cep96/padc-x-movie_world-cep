package com.cep.moviesworld.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.viewpod_popular_films_and_serials.view.*

class PopularFilmsAndSerialsViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var mDelegate: Delegate? = null
    private var movieId: Int = 0

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    private fun setUpListener() {
        rvPopularFilmsAndSerials.setOnClickListener {
            mDelegate?.onTapItem(movieId)
        }
    }

    fun setDelegate(delegate: Delegate){
        mDelegate = delegate
    }

    interface Delegate{
        fun onTapItem(movieId: Int)
    }
}
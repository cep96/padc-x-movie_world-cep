package com.cep.moviesworld.mvp.presenters.impls

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cep.moviesworld.data.dummydata.getDummyMovies
import com.cep.moviesworld.data.dummydata.getDummyPeople
import com.cep.moviesworld.data.models.MovieModelImpl
import com.cep.moviesworld.mvp.presenters.MainPresenterImpl
import com.cep.moviesworld.mvp.views.MainView
import com.cep.moviesworld.network.responses.GetMovieDetailsResponse
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MainPresenterImplTest {

    private lateinit var mPresenter: MainPresenterImpl

    @RelaxedMockK
    private lateinit var mView: MainView

//    private lateinit var mMovieModel: MovieModelImpl
    private lateinit var mMovieModel: MovieModelImpl

    @Before
    fun setUpPresenter(){
        MockKAnnotations.init(this)

        MovieModelImpl.init(ApplicationProvider.getApplicationContext())
        mMovieModel = MovieModelImpl

        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mMovieModel = mMovieModel
    }

    @Test
    fun onTapPopularMovie_callNavigateToMovieDetails(){
        val tappedMovie = GetMovieDetailsResponse()

        tappedMovie.title = "Ashes of love"
        tappedMovie.voteCount = 290
        tappedMovie.popularity = 200.00
        tappedMovie.id = 1

        val movieId = tappedMovie.id

        mPresenter.onTapItem(movieId)

        verify {
            mView.navigateToMovieDetails(movieId)
        }
    }

    @Test
    fun onUIReady_callDisplayPopularMovieList(){
        val lifecycleOwner = mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)

        `when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)

        mPresenter.onUIReadyForPopularFilmsAndSerials(lifecycleOwner)
        verify {
            mView.displayPopularFilmsAndSerials(getDummyMovies())
        }
    }

    @Test
    fun onUIReady_callDisplayPersonList(){
        val lifecycleOwner = mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)

        `when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)

        mPresenter.onUIReadyForActors(lifecycleOwner)
        verify {
            mView.displayBestActors(getDummyPeople())
        }
    }
}
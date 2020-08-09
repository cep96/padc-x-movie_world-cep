package com.cep.moviesworld.mvp.views

import com.cep.moviesworld.data.vos.CastVO
import com.cep.moviesworld.data.vos.CrewVO
import com.cep.moviesworld.data.vos.PersonVO
import com.cep.moviesworld.network.responses.GetMovieDetailsResponse
import com.cep.shared.BaseView

interface MovieDetailsView: BaseView {

    fun displayMovieInformation(movie: GetMovieDetailsResponse)
//    fun displayActors(actors: List<PersonVO>)
//    fun displayCreators(creators: List<PersonVO>)

    fun displayCasts(casts: List<CastVO>)
    fun displayCrew(crew: List<CrewVO>)
}
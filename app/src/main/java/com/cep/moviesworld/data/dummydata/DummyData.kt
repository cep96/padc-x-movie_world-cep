package com.cep.moviesworld.data.dummydata

import com.cep.moviesworld.data.vos.GenreVO
import com.cep.moviesworld.data.vos.PersonVO
import com.cep.moviesworld.data.vos.ResultsVO
import com.cep.moviesworld.network.responses.GetMovieDetailsResponse
import com.cep.moviesworld.network.responses.GetMovieTrailerResponse
import com.cep.moviesworld.network.responses.PopularFilmsAndSerialsResponse

fun getDummyMovies(): ArrayList<ResultsVO>{
    val movieOne = ResultsVO()

    movieOne.title = "Ashes of love"
    movieOne.voteAverage = 3.5

    val movieTwo = ResultsVO()

    movieTwo.title = "Sweet Dream"
    movieTwo.voteAverage = 2.5

    val movieThree = ResultsVO()
    movieThree.title = "Mr.Fighting"
    movieThree.voteAverage = 3.0

    return arrayListOf(movieOne, movieTwo, movieThree)
}

fun getDummyGenre(): GenreVO{
    return GenreVO(0, "")
}

fun getDummyTrailer(): GetMovieTrailerResponse{
    return GetMovieTrailerResponse(0, arrayListOf())
}

fun getDummyFilms(): PopularFilmsAndSerialsResponse{
    return PopularFilmsAndSerialsResponse(0,0,0, arrayListOf())
}

fun getDummyMovie(): ResultsVO{
    return ResultsVO(0.0, 0, false, "",
    0, false, "", "", "", arrayListOf(), "",
    0.0, "")
}

fun getDummyMovieDetails(): GetMovieDetailsResponse{
    return GetMovieDetailsResponse(false,"","",0, arrayListOf(),
    "",0,"","", "", "", 0.0,"",
    arrayListOf(), arrayListOf(), "", 0, 0, arrayListOf(), "","", "",false,
    0.0,0 )
}

fun getDummyPeople(): ArrayList<PersonVO>{
    val personOne = PersonVO(3.0, "actor", 1, 1, "string",
    false, arrayListOf(), "Deng Lun")

    val personTwo = PersonVO(3.0, "actor", 1, 2, "string",
        false, arrayListOf(), "Deng Lun")

    val personThree = PersonVO(3.0, "actor", 1, 3, "string",
        false, arrayListOf(), "Deng Lun")

    val personFour = PersonVO(3.0, "actor", 1, 4, "string",
        false, arrayListOf(), "Deng Lun")

    val personFive = PersonVO(3.0, "actor", 1, 5, "string",
        false, arrayListOf(), "Deng Lun")

    val personSix = PersonVO(3.0, "actor", 1, 6, "string",
        false, arrayListOf(), "Deng Lun")

    val personSeven = PersonVO(3.0, "actor", 1, 7, "string",
        false, arrayListOf(), "Deng Lun")

    val personEight = PersonVO(3.0, "actor", 1, 8, "string",
        false, arrayListOf(), "Deng Lun")

    val personNine = PersonVO(3.0, "actor", 1, 9, "string",
        false, arrayListOf(), "Deng Lun")

    val personTen = PersonVO(3.0, "actor", 1, 10, "string",
        false, arrayListOf(), "Deng Lun")


    return arrayListOf(personOne, personTwo, personThree, personFour,
    personFive, personSix, personSeven, personEight, personNine, personTen)

}

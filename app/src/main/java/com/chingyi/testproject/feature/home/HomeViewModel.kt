package com.chingyi.testproject.feature.home


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chingyi.testproject.domain.details.usecase.GetMovieDetailsUseCase
import com.chingyi.testproject.domain.favourite.FavouriteMovieRepository
import com.chingyi.testproject.domain.favourite.model.MovieFavourite
import com.chingyi.testproject.domain.popular.usecase.GetPopularMovieList
import com.chingyi.testproject.domain.upcoming.model.Movie
import com.chingyi.testproject.domain.upcoming.usecase.GetUpComingMovieList
import com.chingyi.testproject.helper.Coroutine
import com.chingyi.testproject.helper.NetworkException
import com.chingyi.testproject.helper.viewstate.ViewStateLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val upComingMovieUseCase : GetUpComingMovieList,
    private val popularMovieUseCase : GetPopularMovieList,
    private val detailsUseCase :GetMovieDetailsUseCase,
    private val favouriteRepository : FavouriteMovieRepository)
: ViewModel() {

    //MARK:- ViewModel's Properties
    private var _upComingMovieList  = ViewStateLiveData<List<Movie>>()
    val upComingMovieList : ViewStateLiveData<List<Movie>>  get() =  _upComingMovieList

    private var _popularMovieList  = ViewStateLiveData<List<Movie>>()
    val popularMovieList : ViewStateLiveData<List<Movie>>  get() =  _popularMovieList

    private var _movieDetail  = ViewStateLiveData<Movie>()
    val movieDetail : ViewStateLiveData<Movie>  get() =  _movieDetail

    val isFavourite =  MutableLiveData<Boolean>()

    //MARK:- MOVIE
    fun getUpComingMovieList() {

        _upComingMovieList.postLoading()
        Coroutine.io {

            try {
                val data = upComingMovieUseCase.execute(GetUpComingMovieList.Params(param = ""))
                _upComingMovieList.postSuccess(data = data)
            } catch (e : Exception) {
                if (e is NetworkException) {
                    _upComingMovieList.postError(e , e.message.toString())
                }
            }
        }
    }

    fun getPopularMovieList() {

        _popularMovieList.postLoading()
        Coroutine.io {

            try {
                val data = popularMovieUseCase.execute(GetPopularMovieList.Params(param = ""))
                _popularMovieList.postSuccess(data = data)
            } catch (e : Exception) {
                if (e is NetworkException) {
                    _popularMovieList.postError(e , e.message.toString())
                }
                _popularMovieList.postError(e , e.message.toString())
            }
        }
    }

    fun getMovieDetails(id : Int,movieType : String) {

        _movieDetail.postLoading()
        Coroutine.io {

            try {
                val data = detailsUseCase.
                execute(GetMovieDetailsUseCase.
                Params(id = id.toLong(),movieType = movieType))
                _movieDetail.postSuccess(data = data)
                isMovieFavourite(id = id.toLong()).isFavourite?.let {
                    isFavourite.postValue(it)
                }
            } catch (e : Exception) {
                if (e is NetworkException) {
                    _movieDetail.postError(e , e.message.toString())
                }
                _movieDetail.postError(e , e.message.toString())
                Timber.e(e)
            }
        }
    }
    //MARK:- Favourite Movie
    suspend fun setMovieFavourite(movie : MovieFavourite){
        favouriteRepository.setMovieFavourite(movieFavourite = movie)
    }

    suspend fun isMovieFavourite(id : Long) : MovieFavourite{
      return  favouriteRepository.isMovieFavourite(id = id)
    }
}
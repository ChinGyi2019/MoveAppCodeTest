package com.chingyi.testproject.feature.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import coil.load
import coil.size.Scale
import com.chingyi.testproject.R

import com.chingyi.testproject.databinding.DetailActivityBinding
import com.chingyi.testproject.domain.favourite.model.MovieFavourite
import com.chingyi.testproject.domain.upcoming.model.Movie
import com.chingyi.testproject.feature.home.HomeViewModel
import com.chingyi.testproject.helper.Coroutine
import com.chingyi.testproject.helper.viewstate.ViewState
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private lateinit var binding : DetailActivityBinding
    private val viewModel by viewModels<HomeViewModel>()
    var movieID : String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        movieID  = bundle?.getString("movieID")
        val movieType : String? = bundle?.getString("movieType")
        movieID?.toInt()?.let {
            viewModel.getMovieDetails(it, movieType.toString())
        }

        setUpMovieDetails()

        backBtnClick()



    }
    private fun setUpMovieDetails(){
        viewModel.movieDetail.observe(this){viewState->
            when (viewState) {
                is ViewState.Loading -> {
                }
                is ViewState.Success -> {
                    bindMovieDetails(viewState.value)
                  Timber.tag("details").e(viewState.value.toString())
                }
                is ViewState.Error -> {
                    Timber.w(viewState.exception)
                }

            }
        }
        }
    private fun bindMovieDetails(movie : Movie){
        binding.apply {
            movieTitle.text = movie.originalTitle
            durationTv.text = movie.releaseDate
            originalTitle.text = movie.originalTitle
            description.text = movie.overview

            val posterPath = "https://image.tmdb.org/t/p/w500/${movie.posterPath}"
            backDrop.load(posterPath){
                crossfade(true)
                scale(Scale.FIT)
            }
            val voteAverage =(movie.voteAverage ?: 0.0).toFloat()
            val rating = (voteAverage * 0.5).toFloat()

            binding.detailRatingBar.apply {
                this.rating = rating
                numStars = 5
            }

            movie.id?.let { favouriteAction(it) }

        }

    }

    private  fun favouriteAction(id : Long){
        var toogle = false

            viewModel.isFavourite.observe(this){isFavourite->
                toogle = isFavourite
                if(isFavourite){
                    binding.favouriteBtn.setImageResource(R.drawable.ic_favourite_fill)
                }else{
                    binding.favouriteBtn.setImageResource(R.drawable.ic_favourite_hole)
                }
            }
            binding.favouriteBtn.setOnClickListener {
                Coroutine.main {
                    if (!toogle) {

                        viewModel.setMovieFavourite(MovieFavourite(id = movieID?.toLong() , true))
                        binding.favouriteBtn.setImageResource(R.drawable.ic_favourite_fill)
                        toogle = true
                    } else {
                        viewModel.setMovieFavourite(MovieFavourite(id = movieID?.toLong() , false))
                        binding.favouriteBtn.setImageResource(R.drawable.ic_favourite_hole)
                        toogle = false
                    }
                }
        }
    }

    private fun backBtnClick(){

        binding.backBtn.setOnClickListener {
            this.finish()
        }
    }
    }

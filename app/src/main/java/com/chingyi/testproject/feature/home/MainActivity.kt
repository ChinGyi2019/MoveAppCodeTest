package com.chingyi.testproject.feature.home


import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.chingyi.testproject.R
import com.chingyi.testproject.databinding.ActivityMainBinding
import com.chingyi.testproject.databinding.DetailActivityBinding
import com.chingyi.testproject.feature.details.DetailsActivity
import com.chingyi.testproject.feature.home.adapter.MoviesRecyclerAdapter
import com.chingyi.testproject.helper.AppExecutors
import com.chingyi.testproject.helper.util.NetworkUtils
import com.chingyi.testproject.helper.util.hide
import com.chingyi.testproject.helper.util.show
import com.chingyi.testproject.helper.view.HorizontalContentItemDecoration
import com.chingyi.testproject.helper.viewstate.ViewState
import dagger.hilt.android.AndroidEntryPoint

import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val homeViewModel by viewModels<HomeViewModel>()

    @Inject
    lateinit var appExecutors : AppExecutors

    private lateinit var  popularMovieAdapter  : MoviesRecyclerAdapter
    private lateinit var  upComingMovieAdapter  : MoviesRecyclerAdapter
    @Inject
    lateinit var  networkUtils : NetworkUtils
    private var connectionState = false

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        fetchDataFromNetwork()

        bindUpComingMovies()
        bindPopularMovies()

        onClickMovie()
        handleNetworkChange()

        retryState()


    }
    private  fun initView(){
        popularMovieAdapter = MoviesRecyclerAdapter(appExecutors = appExecutors)
        upComingMovieAdapter = MoviesRecyclerAdapter(appExecutors = appExecutors)

        //RecyclerAdapterSetUP
        setUpRecyclerAdapter()
        showLoading()
    }

    private fun setUpRecyclerAdapter() {
        binding.upComingRecycler.apply {
            layoutManager = LinearLayoutManager(
                this@MainActivity ,
                LinearLayoutManager.HORIZONTAL , false
            )
            adapter = upComingMovieAdapter
            setHasFixedSize(true)
            addItemDecoration(
                HorizontalContentItemDecoration(
                    startOffset = 64 ,
                    itemOffset = 12
                )
            )

        }

        binding.popularRecycler.apply {
            layoutManager = LinearLayoutManager(
                this@MainActivity ,
                LinearLayoutManager.HORIZONTAL , false
            )
            adapter = popularMovieAdapter
            setHasFixedSize(true)
            addItemDecoration(
                HorizontalContentItemDecoration(
                    startOffset = 64 ,
                    itemOffset = 12
                )
            )

        }


    }

    //MARK:- Network
    private fun fetchDataFromNetwork(){
        homeViewModel.getUpComingMovieList()
        homeViewModel.getPopularMovieList()
    }

    private fun bindUpComingMovies() {
        homeViewModel.upComingMovieList.observe(this) { viewState->
            when (viewState) {
                is ViewState.Loading -> {
                   showLoading()
                }
                is ViewState.Success -> {
                    upComingMovieAdapter.submitList(viewState.value)
                    endLoading()
                    if(viewState.value.isEmpty()){
                        isError()
                    }

                }
                is ViewState.Error -> {
                    Timber.w(viewState.exception)
                    isError()
                }

            }
        }
    }


    private fun bindPopularMovies() {
        homeViewModel.popularMovieList.observe(this) { viewState->
            when (viewState) {
                is ViewState.Loading -> {
                    showLoading()
                }
                is ViewState.Success -> {
                    popularMovieAdapter.submitList(viewState.value)
                    endLoading()
                    if(viewState.value.isEmpty()){
                        isError()

                    }


                }
                is ViewState.Error -> {
                    Timber.w(viewState.exception)
                    isError()

                }

            }
        }
    }

    private fun onClickMovie(){
        //UpComing Movie Click
        upComingMovieAdapter.movieItemClick = { movie->
            Timber.e(movie.id.toString())
            val id = movie.id.toString()
            val movieType = movie.movieType
            val intent= Intent(this,DetailsActivity::class.java)
            intent.putExtra("movieID",id)
            intent.putExtra("movieType",movieType)
            startActivity(intent)

        }

        //Popular Movie Click
        popularMovieAdapter.movieItemClick = { movie->
            Timber.e(movie.id.toString())
            val id = movie.id.toString()
            val movieType = movie.movieType
            val intent= Intent(this,DetailsActivity::class.java)

            intent.putExtra("movieID",id)
            intent.putExtra("movieType",movieType)
            startActivity(intent)

        }
    }
    private fun showLoading(){
        binding.upcomingView.hide()
        binding.popularView.hide()
        binding.progressBar.show()
    }
    private fun endLoading(){
        binding.errorTv.hide()
        binding.popularMovieTextView.show()
        binding.upComingMovieTextView.show()
        binding.upcomingView.show()
        binding.popularView.show()
        binding.progressBar.hide()

    }
    private fun isError(){
        binding.popularMovieTextView.hide()
        binding.upComingMovieTextView.hide()
        binding.upcomingView.hide()
        binding.popularView.hide()
        binding.progressBar.hide()

        binding.errorTv.text = getString(R.string.error_text)
        binding.errorTv.show()

    }

    @SuppressLint("ResourceType")
    private fun handleNetworkChange(){
        networkUtils.getNetworkLiveData(this).observe(this ) { isConnected ->

            connectionState = isConnected

                if (!isConnected) {
                binding.textViewNetworkStatus.text = getString(R.string.text_no_connectivity)
                binding.networkStatusLayout.apply {
                   show()
                    setBackgroundColor(Color.parseColor(getString(R.color.colorStatusNotConnected)))
                    animate()
                        .alpha(1f)
                        .setStartDelay(700)
                        .setDuration(1000)
                        .setListener(object : AnimatorListenerAdapter() {
                            override fun onAnimationEnd(animation : Animator) {
                                visibility = View.GONE


                            }
                        })
                }


            } else {
                homeViewModel.getUpComingMovieList()
                homeViewModel.getPopularMovieList()

                binding.textViewNetworkStatus.text = getString(R.string.text_connectivity)
                binding.networkStatusLayout.apply {
                    setBackgroundColor(Color.parseColor(getString(R.color.green)))
                    animate()
                        .alpha(1f)
                        .setStartDelay(700)
                        .setDuration(700)
                        .setListener(object : AnimatorListenerAdapter() {
                            override fun onAnimationEnd(animation : Animator) {
                               hide()

                            }
                        })
                }
            }
        }


    }

    private fun retryState(){
        binding.errorTv.setOnClickListener {
            if(!connectionState) {
                Toast.makeText(this,"No Internet Connection",Toast.LENGTH_SHORT).show()
            }
            fetchDataFromNetwork()
        }
    }
    }
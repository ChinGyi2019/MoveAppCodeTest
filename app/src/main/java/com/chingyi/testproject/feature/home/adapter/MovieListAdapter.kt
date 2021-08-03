package com.chingyi.testproject.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import coil.load
import coil.size.Scale
import com.chingyi.testproject.R
import com.chingyi.testproject.binding.DataBoundListAdapter
import com.chingyi.testproject.databinding.MovieItemLayoutBinding
import com.chingyi.testproject.domain.upcoming.model.Movie
import com.chingyi.testproject.helper.AppExecutors

class MoviesRecyclerAdapter(
    appExecutors: AppExecutors
) : DataBoundListAdapter<Movie ,
        MovieItemLayoutBinding>(appExecutors = appExecutors,
    diffCallback = object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id && oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.title == newItem.title
                    && oldItem.id == newItem.id
        }
    }) {

    var movieItemClick : ((Movie)->Unit)? = null

    override fun createBinding(parent : ViewGroup) : MovieItemLayoutBinding {
        val binding = DataBindingUtil.inflate<MovieItemLayoutBinding>(
            LayoutInflater.from(parent.context),
            R.layout.movie_item_layout,
            parent,
            false
        )
        binding.root.setOnClickListener {
            binding.movie?.let { movieItemClick?.invoke(it)  }

        }
        return binding

    }

    override fun bind(binding : MovieItemLayoutBinding , item : Movie) {
        binding.movie = item
        binding.bestMovieTitle.text = item.originalTitle ?: item.originalName
        val posterPath = "https://image.tmdb.org/t/p/w500/${item.posterPath}"
        binding.ivBestMovieBackDrop.load(posterPath){
            crossfade(true)
            scale(Scale.FIT)
         //   placeholder(R.drawable.dummy_profile)
//            transformations(CircleCropTransformation())
        }
        val voteAverage =(item.voteAverage ?: 0.0).toFloat()
        val rating = (voteAverage * 0.5).toFloat()

        binding.ratingBar.apply {
            this.rating = rating
            numStars = 5
        }
    }
}
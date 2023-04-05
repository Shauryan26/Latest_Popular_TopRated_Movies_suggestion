package com.example.majorproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_popular_movie.*
import kotlinx.android.synthetic.main.fragment_top_rated_movie.*

class TopRatedMovie : Fragment(R.layout.fragment_top_rated_movie) {
    private lateinit var viewModel: MovieViewModel2
    lateinit var movieAdapter: MovieAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[MovieViewModel2::class.java]

        viewModel.getTopRatedMovies()
        viewModel.observeMovieLiveData().observe(viewLifecycleOwner, Observer { movieList ->
            movieAdapter.setMoviesData(movieList)
        })
    }

    private fun prepareRecyclerView() {
        movieAdapter = MovieAdapter()
        rv_movies2.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = movieAdapter

        }
    }
}
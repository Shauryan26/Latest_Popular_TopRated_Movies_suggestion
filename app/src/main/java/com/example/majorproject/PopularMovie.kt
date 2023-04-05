package com.example.majorproject
import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.majorproject.MovieAdapter
import com.example.majorproject.MovieViewModel
import com.example.majorproject.databinding.ActivityMainBinding

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_popular_movie.*


class PopularMovie : Fragment(R.layout.fragment_popular_movie) {
    private lateinit var viewModel: MovieViewModel
    lateinit var movieAdapter: MovieAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]

        viewModel.getPopularMovies()
        viewModel.observeMovieLiveData().observe(viewLifecycleOwner, Observer { movieList ->
            movieAdapter.setMoviesData(movieList)
        })
    }

    private fun prepareRecyclerView() {
        movieAdapter = MovieAdapter()
        rv_movies.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = movieAdapter

        }
    }
}

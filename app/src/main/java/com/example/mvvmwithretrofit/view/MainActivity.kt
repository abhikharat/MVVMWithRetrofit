package com.example.mvvmwithretrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mvvmwithretrofit.databinding.ActivityMainBinding
import com.example.mvvmwithretrofit.view.adapter.MovieListAdapter
import com.example.mvvmwithretrofit.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieAdapter : MovieListAdapter
    private lateinit var viewModel : MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        movieAdapter= MovieListAdapter()
        binding.rvMovie.apply {
            layoutManager=GridLayoutManager(applicationContext,2)
            adapter=movieAdapter

        }

        viewModel=ViewModelProvider(this)[MovieViewModel::class.java]
        viewModel.getPopularMovies()
        viewModel.observeMovieLiveData().observe(this, Observer{ movieList ->

            movieAdapter.setMovieList(movieList)
        })



    }
}
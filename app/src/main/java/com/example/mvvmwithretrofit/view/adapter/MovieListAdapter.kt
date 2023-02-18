package com.example.mvvmwithretrofit.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmwithretrofit.databinding.MovieItemBinding
import com.example.mvvmwithretrofit.model.Result

class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    //List for movie
    private var movieList=ArrayList<Result>()

    fun setMovieList(movieList : List<Result>){

        this.movieList=movieList as ArrayList<Result>
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(movieList.get(position))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class ViewHolder(var binder : MovieItemBinding) : RecyclerView.ViewHolder(binder.root) {

        //Binding data to view
        fun bind( movie : Result){

            Glide.with(binder.movieImage)
                .load("https://image.tmdb.org/t/p/w500"+movie.poster_path)
                .into(binder.movieImage)

            binder.movieName.text=movie.title

        }

    }
}
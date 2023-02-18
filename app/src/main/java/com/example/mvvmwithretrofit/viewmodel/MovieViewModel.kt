package com.example.mvvmwithretrofit.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmwithretrofit.model.Movies
import com.example.mvvmwithretrofit.model.Result
import com.example.mvvmwithretrofit.net.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {

    private var movieLiveData = MutableLiveData<List<Result>>()

    fun getPopularMovies(){

        RetrofitInstance.api.getPopularMovies("c716c1ed1433b0105c63aae873771f9f").enqueue(object :
            Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {

                if(response.body()!=null){
                    movieLiveData.value= response.body()!!.results

                }else{
                    response.errorBody()?.let { Log.d("TAG", it.string()) }
                    return
                }
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }

        })

    }

    fun observeMovieLiveData() : LiveData<List<Result>>{

        return movieLiveData
    }
}
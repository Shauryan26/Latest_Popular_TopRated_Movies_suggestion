package com.example.majorproject

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.majorproject.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    private var movieLiveData=MutableLiveData<List<Result>>()
    fun getPopularMovies(){
        RetrofitInstance.api.getPopularMovies("0cb614af61a951e8dc575e2bbcf5d4a4").enqueue(object : Callback<Movies>{
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if(response.body()!=null) {
                    movieLiveData.value = response.body()!!.results

                }
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.i("Tag",t.message.toString())
            }

        })
    }
    fun observeMovieLiveData() : MutableLiveData<List<Result>>{
           return movieLiveData

    }
}
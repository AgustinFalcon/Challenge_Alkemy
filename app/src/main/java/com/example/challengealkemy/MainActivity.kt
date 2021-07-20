package com.example.challengealkemy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.ProxyFileDescriptorCallback
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengealkemy.databinding.ActivityMainBinding
import com.example.challengealkemy.models.Movie
import com.example.challengealkemy.models.MovieResponse
import com.example.challengealkemy.services.MovieApiInterface
import com.example.challengealkemy.services.MovieApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movies : List<Movie> -> rv_movies_list.adapter = MovieAdapter(movies) }
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : retrofit2.Callback<MovieResponse>{

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}
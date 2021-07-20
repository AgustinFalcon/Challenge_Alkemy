package com.example.challengealkemy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.challengealkemy.models.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter (
    private val movies : List<Movie>
        ) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

            class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view){
                private val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
                fun bindMovies (movie: Movie){
                    itemView.movie_title.text = movie.title
                    itemView.movie_release_date.text = movie.release
                    Glide.with(itemView).load(IMAGE_URL + movie.poster).into(itemView.movie_poster)
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovies(movies.get(position))
    }

    override fun getItemCount(): Int = movies.size
}
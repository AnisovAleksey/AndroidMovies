package com.podlodka.crew.movies.pages.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.podlodka.crew.movies.R
import com.podlodka.crew.movies.pages.movies.view.MovieViewHolder
import com.squareup.picasso.Picasso

class MoviesAdapter : RecyclerView.Adapter<MovieViewHolder>() {
    private var movies: List<Movie> = listOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.one_movie_cell, viewGroup, false)

        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.titleTextView.text = movie.title
        holder.descriptionTextView.text = movie.overview

        Picasso.get().load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
            .resize(0, 80 * 3) // TODO: hard-coded device scale
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun updateMovies(movies: List<Movie>) {
        this.movies = movies
    }
}

data class Movie(
    val id: Int,
    val title: String,
    val releaseDate: String,
    val overview: String,
    val posterPath: String
)
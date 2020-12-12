package com.podlodka.crew.movies.pages.movies

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.podlodka.crew.movies.R
import info.movito.themoviedbapi.TmdbApi
import info.movito.themoviedbapi.model.Discover

class MoviesFragment : Fragment() {
    private val adapter = MoviesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.moviesRecyclerView).run {
            adapter = this@MoviesFragment.adapter
            layoutManager = LinearLayoutManager(this@MoviesFragment.requireContext())
        }
        adapter.notifyDataSetChanged()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val result = MoviesLoadTask().execute("7350a6c7c9b9924c18f1f6e23d3c7470")
        adapter.updateMovies(result.get())
        adapter.notifyDataSetChanged()
    }
}

internal class MoviesLoadTask :
    AsyncTask<String, Void?, List<Movie>>() {
    override fun doInBackground(vararg param: String?): List<Movie> {
        val discover = Discover().apply {
            this.page(1)
            this.sortBy("popularity.desc")
        }
        return TmdbApi(param[0]).discover.getDiscover(discover).results.map {
            Movie(it.id, it.title, it.releaseDate, it.overview, it.posterPath)
        }
    }
}
package com.podlodka.crew.movies.pages.movies.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.podlodka.crew.movies.R

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val titleTextView = view.findViewById<TextView>(R.id.title)
    val descriptionTextView = view.findViewById<TextView>(R.id.description)
    val imageView = view.findViewById<ImageView>(R.id.imageView)
}
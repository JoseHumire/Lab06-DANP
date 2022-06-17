package org.idnp.jetpackpagingsample

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val idText = view.findViewById<TextView>(R.id.textViewQualification) as TextView
    val nameText = view.findViewById<TextView>(R.id.textViewMovieName) as TextView
    val releaseText = view.findViewById<TextView>(R.id.textViewDate) as TextView
    val genderText = view.findViewById<TextView>(R.id.textViewMovieGender) as TextView

    fun bind(movie: Movie) {
        with(movie) {
            idText.text = movie.qualification.toString()
            nameText.text = movie.name
            genderText.text = movie.gender
            releaseText.setText(""+movie.releaseYear+"/"+movie.releaseMonth+"/"+movie.releaseDay)
        }
    }
}
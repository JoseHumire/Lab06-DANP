package org.idnp.jetpackpagingsample

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "movie")
data class Movie(
    val name: String,
    val description:String,
    val gender:String,
    val qualification:Int,
    val releaseYear:Int,
    val releaseMonth:Int,
    val releaseDay:Int
)



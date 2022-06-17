package org.idnp.jetpackpagingsample

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<Movie>)

    @Query("SELECT * FROM movie")
    fun pagingSource(query: String): PagingSource<Int, Movie>

    @Query("DELETE FROM movie")
    suspend fun clearAll()
}
package org.idnp.jetpackpagingsample

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.paging.PagingSource
import androidx.paging.PagingState
import java.io.IOException

class ExamplePagingSource(
    val backendService: ExampleBackendService
) : PagingSource<Int, Movie>() {

    override val keyReuseSupported: Boolean = true

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPageNumber = params.key ?: 1
            val movies = backendService.searchMovies(nextPageNumber)

            return LoadResult.Page(
                data = movies ?: listOf(),
                prevKey = null,
                nextKey = null
            )

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {

        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }


}
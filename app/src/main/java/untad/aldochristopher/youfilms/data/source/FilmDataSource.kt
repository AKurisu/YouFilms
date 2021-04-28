package untad.aldochristopher.youfilms.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import untad.aldochristopher.youfilms.data.source.local.entity.MovieEntity
import untad.aldochristopher.youfilms.data.source.local.entity.TvEntity
import untad.aldochristopher.youfilms.vo.Resource

interface FilmDataSource {

    fun getMovie(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getTvshow(): LiveData<Resource<PagedList<TvEntity>>>

    fun getMovieDetail(filmId: String): LiveData<MovieEntity>

    fun getTvDetail(filmId: String): LiveData<TvEntity>

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>>

    fun getFavoriteTv(): LiveData<PagedList<TvEntity>>

    fun setMovieFavorite(movie: MovieEntity, favStatus: Boolean)

    fun setTvFavorite(tv: TvEntity, favStatus: Boolean)
}
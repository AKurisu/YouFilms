package untad.aldochristopher.youfilms.data.source

import androidx.lifecycle.LiveData
import untad.aldochristopher.youfilms.data.source.local.entity.FilmEntity
import untad.aldochristopher.youfilms.data.source.local.entity.MovieEntity
import untad.aldochristopher.youfilms.data.source.local.entity.TvEntity
import untad.aldochristopher.youfilms.vo.Resource

interface FilmDataSource {

    fun getMovie(): LiveData<Resource<List<MovieEntity>>>

    fun getTvshow(): LiveData<Resource<List<TvEntity>>>

    fun getMovieDetail(filmId: String): LiveData<MovieEntity>

    fun getTvDetail(filmId: String): LiveData<TvEntity>

    fun getFavoriteMovie(): LiveData<List<MovieEntity>>

    fun getFavoriteTv(): LiveData<List<TvEntity>>

    fun setMovieFavorite(movie: MovieEntity, favStatus: Boolean)

    fun setTvFavorite(tv: TvEntity, favStatus: Boolean)
}
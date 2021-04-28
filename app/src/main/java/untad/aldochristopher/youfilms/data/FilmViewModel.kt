package untad.aldochristopher.youfilms.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import untad.aldochristopher.youfilms.data.source.FilmRepository
import untad.aldochristopher.youfilms.data.source.local.entity.MovieEntity
import untad.aldochristopher.youfilms.data.source.local.entity.TvEntity
import untad.aldochristopher.youfilms.vo.Resource

class FilmViewModel(private val filmRepository: FilmRepository): ViewModel() {

    fun getMovie(): LiveData<Resource<PagedList<MovieEntity>>> = filmRepository.getMovie()

    fun getTv(): LiveData<Resource<PagedList<TvEntity>>> = filmRepository.getTvshow()

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> = filmRepository.getFavoriteMovie()

    fun getFavoriteTv(): LiveData<PagedList<TvEntity>> = filmRepository.getFavoriteTv()

    fun setFavorite(movieEntity: MovieEntity?, tvEntity: TvEntity?, filmType: Int){
        val status : Boolean
        if (filmType == 1){
            val movie = movieEntity
            if (movie != null){
                status = !movie.favorited
                filmRepository.setMovieFavorite(movie, status)
            }
        } else {
            val tv = tvEntity
            if (tv != null){
                status = !tv.favorited
                filmRepository.setTvFavorite(tv, status)
            }
        }
    }
}
package untad.aldochristopher.youfilms.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import untad.aldochristopher.youfilms.data.source.FilmRepository
import untad.aldochristopher.youfilms.data.source.local.entity.FilmEntity
import untad.aldochristopher.youfilms.data.source.local.entity.MovieEntity
import untad.aldochristopher.youfilms.data.source.local.entity.TvEntity

class FilmDetailViewModel(private val filmRepository: FilmRepository): ViewModel() {

    val filmId = MutableLiveData<String>()
    private var filmType = 0

    fun setId(filmId: String, filmType: Int){
        this.filmId.value = filmId
        this.filmType = filmType
    }

    var getMovieDetail: LiveData<MovieEntity> = Transformations.switchMap(filmId){
        filmRepository.getMovieDetail(it)
    }

    var getTvDetail: LiveData<TvEntity> = Transformations.switchMap(filmId){
        filmRepository.getTvDetail(it)
    }

    fun setFavorite(){
        val status : Boolean
        if (filmType == 1){
           val movie = getMovieDetail.value
           if (movie != null){
               status = !movie.favorited
               filmRepository.setMovieFavorite(movie, status)
           }
        } else {
           val tv = getTvDetail.value
           if (tv != null){
               status = !tv.favorited
               filmRepository.setTvFavorite(tv, status)
           }
        }
    }
}
package untad.aldochristopher.youfilms.data.source

import androidx.lifecycle.LiveData
import untad.aldochristopher.youfilms.data.FilmEntity

interface FilmDataSource {

    fun getMovie(): LiveData<List<FilmEntity>>

    fun getTvshow(): LiveData<List<FilmEntity>>

    fun getFilmDetail(filmId: String, filmType: Int): LiveData<FilmEntity>
}
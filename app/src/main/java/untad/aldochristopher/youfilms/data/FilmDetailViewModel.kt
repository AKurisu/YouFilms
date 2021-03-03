package untad.aldochristopher.youfilms.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import untad.aldochristopher.youfilms.data.source.FilmRepository

class FilmDetailViewModel(private val filmRepository: FilmRepository): ViewModel() {

    private lateinit var filmId : String
    private var filmType = 0

    fun setId(filmId: String, filmType: Int){
        this.filmId = filmId
        this.filmType = filmType
    }

    fun getFilm(): LiveData<FilmEntity> = filmRepository.getFilmDetail(filmId, filmType)
}
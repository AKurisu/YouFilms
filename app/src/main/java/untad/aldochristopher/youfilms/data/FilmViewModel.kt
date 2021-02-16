package untad.aldochristopher.youfilms.data

import androidx.lifecycle.ViewModel
import untad.aldochristopher.youfilms.data.source.FilmRepository
import untad.aldochristopher.youfilms.utils.DataDummy

class FilmViewModel(private val filmRepository: FilmRepository): ViewModel() {

    fun getMovie(): List<FilmEntity> = filmRepository.getMovie()

    fun getTv(): List<FilmEntity> = filmRepository.getTvshow()
}
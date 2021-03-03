package untad.aldochristopher.youfilms.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import untad.aldochristopher.youfilms.data.source.FilmRepository

class FilmViewModel(private val filmRepository: FilmRepository): ViewModel() {

    fun getMovie(): LiveData<List<FilmEntity>> = filmRepository.getMovie()

    fun getTv(): LiveData<List<FilmEntity>> = filmRepository.getTvshow()
}
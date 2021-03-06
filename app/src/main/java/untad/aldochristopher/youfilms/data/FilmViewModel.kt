package untad.aldochristopher.youfilms.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import untad.aldochristopher.youfilms.data.source.FilmRepository
import untad.aldochristopher.youfilms.data.source.local.entity.FilmEntity
import untad.aldochristopher.youfilms.data.source.local.entity.MovieEntity
import untad.aldochristopher.youfilms.data.source.local.entity.TvEntity
import untad.aldochristopher.youfilms.vo.Resource

class FilmViewModel(private val filmRepository: FilmRepository): ViewModel() {

    fun getMovie(): LiveData<Resource<List<MovieEntity>>> = filmRepository.getMovie()

    fun getTv(): LiveData<Resource<List<TvEntity>>> = filmRepository.getTvshow()

    fun getFavoriteMovie(): LiveData<List<MovieEntity>> = filmRepository.getFavoriteMovie()

    fun getFavoriteTv(): LiveData<List<TvEntity>> = filmRepository.getFavoriteTv()
}
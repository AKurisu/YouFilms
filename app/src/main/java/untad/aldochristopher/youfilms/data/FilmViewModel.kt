package untad.aldochristopher.youfilms.data

import androidx.lifecycle.ViewModel
import untad.aldochristopher.youfilms.utils.DataDummy

class FilmViewModel: ViewModel() {

    fun getMovie(): List<FilmEntity> = DataDummy.generateDataMovie()

    fun getTv(): List<FilmEntity> = DataDummy.generateDataTvShow()
}
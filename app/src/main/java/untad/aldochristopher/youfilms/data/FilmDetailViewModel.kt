package untad.aldochristopher.youfilms.data

import androidx.lifecycle.ViewModel
import untad.aldochristopher.youfilms.utils.DataDummy

class FilmDetailViewModel: ViewModel() {

    private lateinit var filmId : String
    private var filmType = 0

    fun setId(filmId: String, filmType: Int){
        this.filmId = filmId
        this.filmType = filmType
    }

    fun getFilm(): FilmEntity{
        var film = DataDummy.generateDummy()
        val dataDummy : List<FilmEntity>
        if (filmType == 1){
            dataDummy = DataDummy.generateDataMovie()
        } else {
            dataDummy = DataDummy.generateDataTvShow()
        }

        for (filmSearch in dataDummy) {
            if (filmSearch.id == filmId) {
                film = filmSearch
            }
        }
        return film
    }
}
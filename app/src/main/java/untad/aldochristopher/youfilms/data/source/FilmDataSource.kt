package untad.aldochristopher.youfilms.data.source

import untad.aldochristopher.youfilms.data.FilmEntity

interface FilmDataSource {

    fun getMovie(): List<FilmEntity>

    fun getTvshow(): List<FilmEntity>
}
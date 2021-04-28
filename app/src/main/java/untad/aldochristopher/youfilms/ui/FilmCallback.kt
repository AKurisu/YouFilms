package untad.aldochristopher.youfilms.ui

import untad.aldochristopher.youfilms.data.source.local.entity.MovieEntity
import untad.aldochristopher.youfilms.data.source.local.entity.TvEntity

interface FilmCallback {
    fun onShareClick(film: MovieEntity)
}

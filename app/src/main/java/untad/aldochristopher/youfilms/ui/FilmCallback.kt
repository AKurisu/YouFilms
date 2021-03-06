package untad.aldochristopher.youfilms.ui

import untad.aldochristopher.youfilms.data.source.local.entity.FilmEntity

interface FilmCallback {
    fun onShareClick(film: FilmEntity)
}

package untad.aldochristopher.youfilms.ui

import untad.aldochristopher.youfilms.data.FilmEntity

interface FilmCallback {
    fun onShareClick(film: FilmEntity)
}

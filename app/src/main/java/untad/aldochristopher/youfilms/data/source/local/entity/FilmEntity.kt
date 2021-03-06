package untad.aldochristopher.youfilms.data.source.local.entity

data class FilmEntity(
    var id: String,
    var title: String,
    var description: String,
    var date: String,
    var genre: String,
    var img: Int
)
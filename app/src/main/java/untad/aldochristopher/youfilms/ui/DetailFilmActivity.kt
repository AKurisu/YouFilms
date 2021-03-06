package untad.aldochristopher.youfilms.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import untad.aldochristopher.youfilms.R
import untad.aldochristopher.youfilms.data.FilmDetailViewModel
import untad.aldochristopher.youfilms.data.ToFilmEntity
import untad.aldochristopher.youfilms.data.source.local.entity.FilmEntity
import untad.aldochristopher.youfilms.data.source.local.entity.MovieEntity
import untad.aldochristopher.youfilms.data.source.local.entity.TvEntity
import untad.aldochristopher.youfilms.data.source.viewmodel.ViewModelFactory
import untad.aldochristopher.youfilms.databinding.ActivityDetailFilmBinding
import untad.aldochristopher.youfilms.databinding.ContentDetailFilmBinding

class DetailFilmActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_FILM = "extra_film"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var contentDetailFilmBinding: ContentDetailFilmBinding
    private lateinit var activityDetailFilmBinding: ActivityDetailFilmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        activityDetailFilmBinding = ActivityDetailFilmBinding.inflate(layoutInflater)
        contentDetailFilmBinding = activityDetailFilmBinding.contentDetail

        setContentView(activityDetailFilmBinding.root)

        setSupportActionBar(activityDetailFilmBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var status = false
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[FilmDetailViewModel::class.java]

        contentDetailFilmBinding.progressBar.visibility = View.VISIBLE
        activityDetailFilmBinding.fab.visibility = View.GONE
        val extras = intent.extras
        if (extras != null){
            val filmId = extras.getString(EXTRA_FILM)
            val filmType = extras.getInt(EXTRA_TYPE)
            if (filmId != null && filmType != 0){
                viewModel.setId(filmId, filmType)
                if (filmType == 1){
                    viewModel.getMovieDetail.observe(this, {
                        status = it.favorited
                        setFavorite(status)
                        movieToFilm(it)})
                } else {
                    viewModel.getTvDetail.observe(this, {
                        status = it.favorited
                        setFavorite(status)
                        tvToFilm(it)})
                }
            }
        }

        activityDetailFilmBinding.fab.setOnClickListener {
            viewModel.setFavorite()
            status = !status
            setFavorite(status)
        }
    }

    private fun setFavorite(favorited: Boolean) {
        if (favorited){
            activityDetailFilmBinding.fab.setImageResource(R.drawable.ic_baseline_favorite_24)
        } else {
            activityDetailFilmBinding.fab.setImageResource(R.drawable.ic_baseline_favorite_not_24)
        }
    }

    private fun tvToFilm(tv: TvEntity) {
        val film = ToFilmEntity.takeTv(tv)

        populateDetail(film)
    }

    private fun movieToFilm(movie: MovieEntity){
        val film = ToFilmEntity.takeMovie(movie)

        populateDetail(film)
    }

    private fun populateDetail(film: FilmEntity) {
        contentDetailFilmBinding.txtTitle.text = film.title
        contentDetailFilmBinding.txtGenre.text = film.genre
        contentDetailFilmBinding.txtDate.text = film.date
        contentDetailFilmBinding.txtDesc.text = film.description


        Glide.with(this)
                .load(film.img)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_broken_image))
                .into(contentDetailFilmBinding.imgPoster)

        contentDetailFilmBinding.progressBar.visibility = View.GONE
        activityDetailFilmBinding.fab.visibility = View.VISIBLE
    }
}
package untad.aldochristopher.youfilms.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import untad.aldochristopher.youfilms.R
import untad.aldochristopher.youfilms.data.FilmDetailViewModel
import untad.aldochristopher.youfilms.data.FilmEntity
import untad.aldochristopher.youfilms.data.source.viewmodel.ViewModelFactory
import untad.aldochristopher.youfilms.databinding.ActivityDetailFilmBinding
import untad.aldochristopher.youfilms.databinding.ContentDetailFilmBinding

class DetailFilmActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_FILM = "extra_film"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var contentDetailFilmBinding: ContentDetailFilmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val activityDetailFilmBinding = ActivityDetailFilmBinding.inflate(layoutInflater)
        contentDetailFilmBinding = activityDetailFilmBinding.contentDetail

        setContentView(activityDetailFilmBinding.root)

        setSupportActionBar(activityDetailFilmBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[FilmDetailViewModel::class.java]

        contentDetailFilmBinding.progressBar.visibility = View.VISIBLE
        val extras = intent.extras
        if (extras != null){
            val filmId = extras.getString(EXTRA_FILM)
            val filmType = extras.getInt(EXTRA_TYPE)
            if (filmId != null && filmType != 0){
                viewModel.setId(filmId, filmType)
                viewModel.getFilm().observe(this, {
                        film -> populateDetail(film)
                        contentDetailFilmBinding.progressBar.visibility = View.GONE
                })

            }
        }
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

    }
}
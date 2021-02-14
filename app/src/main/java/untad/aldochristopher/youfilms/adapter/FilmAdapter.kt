package untad.aldochristopher.youfilms.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import untad.aldochristopher.youfilms.R
import untad.aldochristopher.youfilms.data.FilmEntity
import untad.aldochristopher.youfilms.databinding.ItemFilmBinding
import untad.aldochristopher.youfilms.ui.DetailFilmActivity
import untad.aldochristopher.youfilms.ui.FilmCallback

class FilmAdapter(private val callback : FilmCallback) : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

    private var listFilm = ArrayList<FilmEntity>()
    private var filmType = 0

    fun setFilm(film: List<FilmEntity>, filmType: Int){
        this.listFilm.clear()
        this.listFilm.addAll(film)
        this.filmType = filmType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val itemFilm = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(itemFilm)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = listFilm[position]
        holder.bind(film)
    }

    override fun getItemCount(): Int = listFilm.size

    inner class FilmViewHolder (private val binding: ItemFilmBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(film: FilmEntity){
            with(binding){
                txtItemTitle.text = film.title
                txtItemDate.text = film.date
                txtItemGenre.text = film.genre

                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailFilmActivity::class.java)
                    intent.putExtra(DetailFilmActivity.EXTRA_FILM, film.id)
                    intent.putExtra(DetailFilmActivity.EXTRA_TYPE, filmType)
                    itemView.context.startActivity(intent)
                }
                btnShare.setOnClickListener{ callback.onShareClick(film)}
                Glide.with(itemView.context)
                        .load(film.img)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_broken_image))
                        .into(imgItemPoster)
            }
        }

    }
}
package untad.aldochristopher.youfilms.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import untad.aldochristopher.youfilms.R
import untad.aldochristopher.youfilms.data.source.local.entity.MovieEntity
import untad.aldochristopher.youfilms.databinding.ItemFilmBinding
import untad.aldochristopher.youfilms.ui.DetailFilmActivity
import untad.aldochristopher.youfilms.ui.FilmCallback

class MovieAdapter(private val callback : FilmCallback) : PagedListAdapter<MovieEntity, MovieAdapter.FilmViewHolder>(DIFF_CALLBACK) {

    private var listFilm = ArrayList<MovieEntity>()
    private var filmType = 1

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    fun setFilm(film: List<MovieEntity>, filmType: Int){
        this.listFilm.clear()
        this.listFilm.addAll(film)
        this.filmType = filmType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val itemFilm = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(itemFilm)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = getItem(position)
        if (film != null) {
            holder.bind(film)
        }
    }

    fun getSwipedData(swipedPosition: Int): MovieEntity? = getItem(swipedPosition)
//    override fun getItemCount(): Int {
//        Log.d("Adapter", list)
//        return listFilm.size
//    }

    inner class FilmViewHolder (private val binding: ItemFilmBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(film: MovieEntity){
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
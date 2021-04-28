package untad.aldochristopher.youfilms.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import untad.aldochristopher.youfilms.R
import untad.aldochristopher.youfilms.adapter.MovieAdapter
import untad.aldochristopher.youfilms.data.source.local.entity.FilmEntity
import untad.aldochristopher.youfilms.data.FilmViewModel
import untad.aldochristopher.youfilms.data.ToFilmEntity
import untad.aldochristopher.youfilms.data.source.local.entity.MovieEntity
import untad.aldochristopher.youfilms.data.source.local.entity.TvEntity
import untad.aldochristopher.youfilms.data.source.viewmodel.ViewModelFactory
import untad.aldochristopher.youfilms.databinding.FragmentMovieBinding
import untad.aldochristopher.youfilms.vo.Status

class MovieFragment(private val activity: String) : Fragment(), FilmCallback {

    private lateinit var fragment: FragmentMovieBinding
    private lateinit var mAdapter: MovieAdapter
    private lateinit var viewModel: FilmViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragment = FragmentMovieBinding.inflate(inflater, container, false)
        return fragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireContext())
            viewModel = ViewModelProvider(this, factory)[FilmViewModel::class.java]

            mAdapter = MovieAdapter(this)

            if (activity == "Main"){
                getMain(mAdapter, viewModel)
            } else if (activity == "Fav"){
                itemTouchHelper.attachToRecyclerView(fragment.rvMovie)
                getFavorite(mAdapter, viewModel)
            }

            with(fragment.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = mAdapter
            }
        }
    }

    private fun getFavorite(adapter: MovieAdapter, viewModel: FilmViewModel) {
        viewModel.getFavoriteMovie().observe(viewLifecycleOwner, { film ->
            if (film != null) {
                fragment.progressBar.visibility = View.GONE
                adapter.submitList(film)
            }
        })
    }

    private fun getMain(adapter: MovieAdapter, viewModel: FilmViewModel) {
        viewModel.getMovie().observe(viewLifecycleOwner, { film ->
            if (film != null) {
                Log.d("Fragment", film.status.name)
                when (film.status) {
                    Status.LOADING -> fragment.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        fragment.progressBar.visibility = View.GONE
                        Log.d("Frag", film.data?.size.toString())
                        adapter.submitList(film.data)
                    }
                    Status.ERROR -> {
                        fragment.progressBar.visibility = View.GONE
                        Toast.makeText(context, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

//    private fun setRv(adapter: MovieAdapter){
//        with(fragment.rvMovie) {
//            layoutManager = LinearLayoutManager(context)
//            setHasFixedSize(true)
//            this.adapter = adapter
//        }
//    }

    override fun onShareClick(film: MovieEntity) {
        if (activity != null) {
            val filmLink = "http:\\\\imdb.com\\" + film.id

            ShareCompat.IntentBuilder
                    .from(requireActivity())
                    .setType("text/html")
                    .setText(resources.getString(R.string.share, film.title, filmLink))
                    .startChooser()
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
                makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val favSwiped = mAdapter.getSwipedData(swipedPosition)
                favSwiped?.let { viewModel.setFavorite(it, null, 1) }
                val snackbar = Snackbar.make(view as View, "Undo", Snackbar.LENGTH_LONG)
                snackbar.setAction("OK") { v ->
                    favSwiped?.let { viewModel.setFavorite(it, null, 1) }
                }
                snackbar.show()
            }
        }
    })
}
package untad.aldochristopher.youfilms.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import untad.aldochristopher.youfilms.R
import untad.aldochristopher.youfilms.adapter.FilmAdapter
import untad.aldochristopher.youfilms.data.source.local.entity.FilmEntity
import untad.aldochristopher.youfilms.data.FilmViewModel
import untad.aldochristopher.youfilms.data.ToFilmEntity
import untad.aldochristopher.youfilms.data.source.viewmodel.ViewModelFactory
import untad.aldochristopher.youfilms.databinding.FragmentTvBinding
import untad.aldochristopher.youfilms.vo.Status

class TvFragment(private val activity: String) : Fragment(), FilmCallback {

    private lateinit var fragment: FragmentTvBinding

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragment = FragmentTvBinding.inflate(inflater, container, false)
        return fragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireContext())
            val viewModel = ViewModelProvider(this, factory)[FilmViewModel::class.java]
            val adapter = FilmAdapter(this)

            if (activity == "Main"){
                getMain(adapter, viewModel)
            } else if (activity == "Fav"){
                getFavorite(adapter, viewModel)
            }


//            viewModel.getTv().observe(viewLifecycleOwner, { film ->
//                if (film != null){
//                    when(film.status){
//                        Status.LOADING -> fragment.progressBar.visibility = View.VISIBLE
//                        Status.SUCCESS -> {
//                            fragment.progressBar.visibility = View.GONE
//                            val movie = ToFilmEntity.takeTv(film.data)
//                            adapter.setFilm(movie, 2)
//                            adapter.notifyDataSetChanged()
//                        }
//                        Status.ERROR ->{
//                            fragment.progressBar.visibility = View.GONE
//                            Toast.makeText(context, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
//                        }
//                    }
//                }
//            })

//            with(fragment.rvTv) {
//                layoutManager = LinearLayoutManager(context)
//                setHasFixedSize(true)
//                this.adapter = adapter
//            }
        }
    }

    private fun getFavorite(adapter: FilmAdapter, viewModel: FilmViewModel) {
        viewModel.getFavoriteTv().observe(viewLifecycleOwner, { film ->
            if (film != null) {
                fragment.progressBar.visibility = View.GONE
                val movie = ToFilmEntity.takeTv(film)
                adapter.setFilm(movie, 2)
                adapter.notifyDataSetChanged()
                setRv(adapter)
            }
        })
    }

    private fun getMain(adapter: FilmAdapter, viewModel: FilmViewModel) {
        viewModel.getTv().observe(viewLifecycleOwner, { film ->
            if (film != null) {
                Log.d("Fragment", film.status.name)
                when (film.status) {
                    Status.LOADING -> fragment.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        fragment.progressBar.visibility = View.GONE
                        val movie = ToFilmEntity.takeTv(film.data)
                        adapter.setFilm(movie, 2)
                        adapter.notifyDataSetChanged()
                        setRv(adapter)
                    }
                    Status.ERROR -> {
                        fragment.progressBar.visibility = View.GONE
                        Toast.makeText(context, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun setRv(adapter: FilmAdapter){
        with(fragment.rvTv) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            this.adapter = adapter
        }
    }

    override fun onShareClick(film: FilmEntity) {
        if (activity != null) {
            val filmLink = "http:\\\\imdb.com\\" + film.id

            ShareCompat.IntentBuilder
                    .from(requireActivity())
                    .setType("text/html")
                    .setText(resources.getString(R.string.share, film.title, filmLink))
                    .startChooser()
        }
    }
}
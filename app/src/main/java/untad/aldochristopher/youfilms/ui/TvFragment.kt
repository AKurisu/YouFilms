package untad.aldochristopher.youfilms.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import untad.aldochristopher.youfilms.R
import untad.aldochristopher.youfilms.adapter.FilmAdapter
import untad.aldochristopher.youfilms.data.FilmEntity
import untad.aldochristopher.youfilms.data.FilmViewModel
import untad.aldochristopher.youfilms.databinding.FragmentTvBinding
import untad.aldochristopher.youfilms.utils.DataDummy

class TvFragment : Fragment(), FilmCallback {

    lateinit var fragment: FragmentTvBinding

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
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[FilmViewModel::class.java]
            val film = viewModel.getTv()

            val adapter = FilmAdapter(this)
            adapter.setFilm(film, 2)
            with(fragment.rvTv) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
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
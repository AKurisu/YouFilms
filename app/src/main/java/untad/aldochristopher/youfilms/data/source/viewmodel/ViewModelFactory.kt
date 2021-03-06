package untad.aldochristopher.youfilms.data.source.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import untad.aldochristopher.youfilms.data.FilmDetailViewModel
import untad.aldochristopher.youfilms.data.FilmViewModel
import untad.aldochristopher.youfilms.data.source.FilmRepository
import untad.aldochristopher.youfilms.data.source.remote.di.Injection

class ViewModelFactory private constructor(private val mFilmRepository: FilmRepository): ViewModelProvider.NewInstanceFactory(){

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideRepository(context))
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when{
            modelClass.isAssignableFrom(FilmViewModel::class.java) ->{
                return FilmViewModel(mFilmRepository) as T
            }

            modelClass.isAssignableFrom(FilmDetailViewModel::class.java) ->{
                return FilmDetailViewModel(mFilmRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}
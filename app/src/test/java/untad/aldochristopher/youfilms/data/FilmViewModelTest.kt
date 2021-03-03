package untad.aldochristopher.youfilms.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import untad.aldochristopher.youfilms.data.source.FilmRepository
import untad.aldochristopher.youfilms.utils.DataDummy

@RunWith(MockitoJUnitRunner::class)
class FilmViewModelTest{

    private lateinit var viewModel: FilmViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<List<FilmEntity>>

    @Before
    fun setUp(){
        viewModel = FilmViewModel(filmRepository)
    }

    @Test
    fun getFilm(){
        val dummyFilm = DataDummy.generateDummy()
        val film = MutableLiveData<List<FilmEntity>>()
        film.value = dummyFilm

        `when`(filmRepository.getMovie()).thenReturn(film)
        val moviesEntity = viewModel.getMovie().value
        verify(filmRepository).getMovie()
        assertNotNull(moviesEntity)
        assertEquals(3, moviesEntity?.size)
        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyFilm)

        `when`(filmRepository.getTvshow()).thenReturn(film)
        val tvEntities = viewModel.getTv().value
        verify(filmRepository).getTvshow()
        assertNotNull(tvEntities)
        assertEquals(3, tvEntities?.size)
        viewModel.getTv().observeForever(observer)
        verify(observer).onChanged(dummyFilm)
    }
}
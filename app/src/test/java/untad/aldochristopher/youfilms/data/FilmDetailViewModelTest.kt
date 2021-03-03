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
class FilmDetailViewModelTest {

    private lateinit var viewModel: FilmDetailViewModel
    private val dummy = DataDummy.generateDummy()[0]
    private val dummyTwo = DataDummy.generateDummy()[1]
    private val dummyId = dummy.id
    private val dummyIdTwo = dummyTwo.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<FilmEntity>

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Before
    fun setUp(){
        viewModel = FilmDetailViewModel(filmRepository)
        viewModel.setId(dummyId, 1)
    }

    @Test
    fun getMovieDetail(){
        val filmDummy = MutableLiveData<FilmEntity>()
        filmDummy.value = dummy

        `when`(filmRepository.getFilmDetail(dummyId, 1)).thenReturn(filmDummy)
        val film = viewModel.getFilm().value
        verify(filmRepository).getFilmDetail(dummyId, 1)
        assertNotNull(film)
        assertEquals("A123", film?.id)
        assertEquals("Dummy", film?.title)
        assertEquals("1 January 1970", film?.date)
        assertEquals("-", film?.genre)
        assertEquals("Lorem Ipsum", film?.description)
        assertEquals(1, film?.img)

        viewModel.getFilm().observeForever(observer)
        verify(observer).onChanged(dummy)
    }

    @Test
    fun getTvDetail(){
        val filmDummy = MutableLiveData<FilmEntity>()
        filmDummy.value = dummyTwo
        viewModel.setId(dummyIdTwo, 2)

        `when`(filmRepository.getFilmDetail(dummyIdTwo, 2)).thenReturn(filmDummy)
        val film = viewModel.getFilm().value
        verify(filmRepository).getFilmDetail(dummyIdTwo, 2)
        assertNotNull(film)
        assertEquals("B456", film?.id)
        assertEquals("Dummy", film?.title)
        assertEquals("1 January 1900", film?.date)
        assertEquals("-", film?.genre)
        assertEquals("Lorem Ipsum", film?.description)
        assertEquals(1, film?.img)

        viewModel.getFilm().observeForever(observer)
        verify(observer).onChanged(dummyTwo)
    }
}
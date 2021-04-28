package untad.aldochristopher.youfilms.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
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
import untad.aldochristopher.youfilms.data.source.local.entity.MovieEntity
import untad.aldochristopher.youfilms.data.source.local.entity.TvEntity
import untad.aldochristopher.youfilms.utils.DataDummy
import untad.aldochristopher.youfilms.vo.Resource

@RunWith(MockitoJUnitRunner::class)
class FilmDetailViewModelTest {

    private lateinit var viewModel: FilmDetailViewModel
    private val dummy = DataDummy.generateDummyMovie()[0]
    private val dummyTwo = DataDummy.generateDummyTv()[1]
    private val dummyId = dummy.id
    private val dummyIdTwo = dummyTwo.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observerMovie: Observer<MovieEntity>

    @Mock
    private lateinit var observerTv: Observer<TvEntity>

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Before
    fun setUp(){
        viewModel = FilmDetailViewModel(filmRepository)
        viewModel.setId(dummyId, 1)
    }

    @Test
    fun getMovieDetail(){
        val dummyMovie = DataDummy.generateDummyDetailMovie(dummy, true)
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie
        `when`(filmRepository.getMovieDetail(dummyId)).thenReturn(movie)
        viewModel.getMovieDetail.observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)
//        val filmDummy = MutableLiveData<MovieEntity>()
//        filmDummy.value = dummy
//
//        `when`(filmRepository.getMovieDetail(dummyId)).thenReturn(filmDummy)
//        val film = viewModel.getMovieDetail.value
//        verify(filmRepository).getMovieDetail(dummyId)
//        assertNotNull(film)
//        assertEquals("A123", film?.id)
//        assertEquals("Dummy", film?.title)
//        assertEquals("1 January 1970", film?.date)
//        assertEquals("-", film?.genre)
//        assertEquals("Lorem Ipsum", film?.description)
//        assertEquals(1, film?.img)
//        assertEquals(false, film?.favorited)
//
//        viewModel.getMovieDetail.observeForever(observerMovie)
//        verify(observerMovie).onChanged(dummy)
    }

    @Test
    fun getTvDetail(){
        val dummyTv = DataDummy.generateDummyDetailTv(dummyTwo, true)
        val tv = MutableLiveData<TvEntity>()
        tv.value = dummyTv
        `when`(filmRepository.getTvDetail(dummyIdTwo)).thenReturn(tv)
        viewModel.getTvDetail.observeForever(observerTv)
        verify(observerTv).onChanged(dummyTv)
//        val filmDummy = MutableLiveData<TvEntity>()
//        filmDummy.value = dummyTwo
//        viewModel.setId(dummyIdTwo, 2)
//
//        `when`(filmRepository.getTvDetail(dummyIdTwo)).thenReturn(filmDummy)
//        val film = viewModel.getTvDetail.value
//        verify(filmRepository).getTvDetail(dummyIdTwo)
//        assertNotNull(film)
//        assertEquals("B456", film?.id)
//        assertEquals("Dummy", film?.title)
//        assertEquals("1 January 1900", film?.date)
//        assertEquals("-", film?.genre)
//        assertEquals("Lorem Ipsum", film?.description)
//        assertEquals(1, film?.img)
//
//        viewModel.getTvDetail.observeForever(observerTv)
//        verify(observerTv).onChanged(dummyTwo)
    }
}
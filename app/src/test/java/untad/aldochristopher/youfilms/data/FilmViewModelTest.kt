package untad.aldochristopher.youfilms.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.DataSource
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.mock
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
class FilmViewModelTest{

    private lateinit var viewModel: FilmViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observerMovie: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var observerTv: Observer<Resource<PagedList<TvEntity>>>

    @Mock
    private lateinit var pagedListMovie: PagedList<MovieEntity>

    @Mock
    private lateinit var pagedListTv: PagedList<TvEntity>

    @Before
    fun setUp(){
        viewModel = FilmViewModel(filmRepository)
    }

    @Test
    fun getMovie(){

//        val dummyMovie = Resource.success(DataDummy.generateDummyMovie())
        val dummyMovie = Resource.success(pagedListMovie)
        `when`(dummyMovie.data?.size).thenReturn(3)
        val movie = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movie.value = dummyMovie

        `when`(filmRepository.getMovie()).thenReturn(movie)
        val moviesEntity = viewModel.getMovie().value?.data
        verify(filmRepository).getMovie()
        assertNotNull(moviesEntity)
        assertEquals(3, moviesEntity?.size)
        viewModel.getMovie().observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)
    }

    @Test
    fun getTv() {
        val dummyTv = Resource.success(pagedListTv)
        `when`(dummyTv.data?.size).thenReturn(3)
        val tv = MutableLiveData<Resource<PagedList<TvEntity>>>()
        tv.value = dummyTv

        `when`(filmRepository.getTvshow()).thenReturn(tv)
        val tvEntities = viewModel.getTv().value?.data
        verify(filmRepository).getTvshow()
        assertNotNull(tvEntities)
        assertEquals(3, tvEntities?.size)
        viewModel.getTv().observeForever(observerTv)
        verify(observerTv).onChanged(dummyTv)
    }
}
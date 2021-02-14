package untad.aldochristopher.youfilms.data

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class FilmViewModelTest{

    private lateinit var viewModel: FilmViewModel

    @Before
    fun setUp(){
        viewModel = FilmViewModel()
    }

    @Test
    fun getFilm(){
        val moviesEntity = viewModel.getMovie()
        assertNotNull(moviesEntity)
        assertEquals(10, moviesEntity.size)

        val tvEntities = viewModel.getTv()
        assertNotNull(tvEntities)
        assertEquals(10, tvEntities.size)
    }
}
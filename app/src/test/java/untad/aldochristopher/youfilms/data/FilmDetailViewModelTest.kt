package untad.aldochristopher.youfilms.data

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import untad.aldochristopher.youfilms.R

class FilmDetailViewModelTest {

    private lateinit var viewModel: FilmDetailViewModel

    @Before
    fun setUp(){
        viewModel = FilmDetailViewModel()
    }

    @Test
    fun getDetail(){
        viewModel.setId("A123", 1)
        var film = viewModel.getFilm()
        assertNotNull(film)
        assertEquals("Dummy", film.title)
        assertEquals("1 January 1970", film.date)
        assertEquals("-", film.genre)
        assertEquals("Lorem Ipsum", film.description)
        assertEquals(1, film.img)

        viewModel.setId("tt0318871", 2)
        film = viewModel.getFilm()
        assertNotNull(film)
        assertEquals("Berserk", film.title)
        assertEquals("1997 - 1998", film.date)
        assertEquals("Animation, Action, Adventure, Horror", film.genre)
        assertNotNull(film.description)
        assertEquals(R.drawable.poster_berserk, film.img)

        viewModel.setId("tt0081398", 1)
        film = viewModel.getFilm()
        assertNotNull(film)
        assertEquals("Raging Bull", film.title)
        assertEquals("19 December 1980", film.date)
        assertEquals("Biography, Drama, Sport", film.genre)
        assertNotNull(film.description)
        assertEquals(R.drawable.poster_ragingbull, film.img)
    }
}
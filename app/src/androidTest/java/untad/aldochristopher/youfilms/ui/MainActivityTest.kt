package untad.aldochristopher.youfilms.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import untad.aldochristopher.youfilms.R
import untad.aldochristopher.youfilms.utils.DataDummy
import untad.aldochristopher.youfilms.utils.EspressoIdlingResources

class MainActivityTest{

    private val dummyMovie = DataDummy.generateDataMovie()
    private val dummyTv = DataDummy.generateDataTvShow()


    @Before
    fun setUp(){
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.espressoTestIdlingResource)
    }

    @After
    fun tearUp(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.espressoTestIdlingResource)
    }

    @Test
    fun checkMovie(){
        onView(withId(R.id.rvMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun checkDetailMovie(){
        onView(withId(R.id.rvMovie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
        onView(withId(R.id.txt_title)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.txt_date)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_date)).check(matches(withText(dummyMovie[0].date)))
        onView(withId(R.id.txt_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_genre)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.txt_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_desc)).check(matches(withText(dummyMovie[0].description)))
    }

    @Test
    fun checkTv(){
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rvTv)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTv.size))

    }

    @Test
    fun checkDetailTv(){
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rvTv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
        onView(withId(R.id.txt_title)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_title)).check(matches(withText(dummyTv[0].title)))
        onView(withId(R.id.txt_date)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_date)).check(matches(withText(dummyTv[0].date)))
        onView(withId(R.id.txt_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_genre)).check(matches(withText(dummyTv[0].genre)))
        onView(withId(R.id.txt_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_desc)).check(matches(withText(dummyTv[0].description)))
    }
}
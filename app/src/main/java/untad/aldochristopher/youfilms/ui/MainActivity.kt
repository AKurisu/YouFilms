package untad.aldochristopher.youfilms.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import untad.aldochristopher.youfilms.R
import untad.aldochristopher.youfilms.adapter.SectionPagerAdapter
import untad.aldochristopher.youfilms.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager,"Main")
        activityMainBinding.viewPager.adapter = sectionPagerAdapter
        activityMainBinding.tabs.setupWithViewPager(activityMainBinding.viewPager)

        supportActionBar?.elevation = 0f
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.fav_menu){
            val intent = Intent(this, FavoriteActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
}
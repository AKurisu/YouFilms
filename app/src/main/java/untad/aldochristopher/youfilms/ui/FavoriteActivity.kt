package untad.aldochristopher.youfilms.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import untad.aldochristopher.youfilms.adapter.SectionPagerAdapter
import untad.aldochristopher.youfilms.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)

        Log.d("Fav", this.localClassName)
        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager, "Fav")
        activityFavoriteBinding.viewPager.adapter = sectionPagerAdapter
        activityFavoriteBinding.tabs.setupWithViewPager(activityFavoriteBinding.viewPager)

        supportActionBar?.elevation = 0f

    }
}
package com.hungnd.androidday9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.hungnd.androidday9.model.WallpaperModel

class WallpaperActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallpaper_activityy)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, WallpaperFragment())
            .commit()

    }

    fun DetailWallpaper(wallPaper: WallpaperModel) {
        supportFragmentManager.beginTransaction().replace(R.id.frame, DetailWallpaperFragment(wallPaper))
            .commit()
    }
}
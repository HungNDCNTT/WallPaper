package com.hungnd.androidday9

import android.app.WallpaperManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.hungnd.androidday9.model.WallpaperModel
import kotlinx.android.synthetic.main.show_items_click.*
import java.lang.Exception

class DetailWallpaperFragment(wallpaper: WallpaperModel) : Fragment() {

    val wallpaperModel: WallpaperModel = wallpaper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.show_items_click, container, false)
        val tvShowName = view.findViewById<TextView>(R.id.tv_Show_Name)
        val tvShowMonth = view.findViewById<TextView>(R.id.tv_Show_Month)
        val imvShowWallpaper = view.findViewById<ImageView>(R.id.imv_Show)
        val btnSetWallpaper = view.findViewById<Button>(R.id.btn_Set_Wallpaper)
        tvShowName.text = wallpaperModel?.tvName
        tvShowMonth.text = wallpaperModel?.tvMonth
        Glide.with(view).load(wallpaperModel?.imvAvt).placeholder(R.mipmap.ic_launcher)
            .into(imvShowWallpaper)
        btnSetWallpaper.setOnClickListener {
            Thread {
                try {
                    if (wallpaperModel != null) {
                     WallpaperManager.getInstance(context).setResource(wallpaperModel.imvAvt)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }.start()
            btnSetWallpaper.visibility=View.INVISIBLE
            Snackbar.make(view, "Success !!", Snackbar.LENGTH_LONG).show()
        }
        return view
    }


}



package com.hungnd.androidday9

import android.content.Intent
import android.os.Bundle
import android.transition.Transition
import android.transition.TransitionInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.hungnd.androidday9.adpater.WallpaperAdapter
import com.hungnd.androidday9.interfaces.ItemsClick
import com.hungnd.androidday9.model.WallpaperModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), ItemsClick {
    private val dataWallPaper = ArrayList<WallpaperModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecycleView()
        initData()
    }

    private fun initData() {
        dataWallPaper.add(WallpaperModel(R.drawable.january, "January", "HungND"))
        dataWallPaper.add(WallpaperModel(R.drawable.february, "February", "HungND"))
        dataWallPaper.add(WallpaperModel(R.drawable.march, "March", "HungND"))
        dataWallPaper.add(WallpaperModel(R.drawable.april, "April", "HungND"))
        dataWallPaper.add(WallpaperModel(R.drawable.may, "May", "HungND"))
        dataWallPaper.add(WallpaperModel(R.drawable.june, "June", "HungND"))
        dataWallPaper.add(WallpaperModel(R.drawable.july, "July", "HungND"))
        dataWallPaper.add(WallpaperModel(R.drawable.august, "August", "HungND"))
        dataWallPaper.add(WallpaperModel(R.drawable.september, "September", "HungND"))
        dataWallPaper.add(WallpaperModel(R.drawable.october, "October", "HungND"))
        dataWallPaper.add(WallpaperModel(R.drawable.november, "November", "HungND"))
        dataWallPaper.add(WallpaperModel(R.drawable.december, "December", "HungND"))

    }

    private fun setRecycleView() {
        rcv_Show_WallPaper.setHasFixedSize(true)
        rcv_Show_WallPaper.layoutManager = GridLayoutManager(this, 2)
        rcv_Show_WallPaper.adapter = WallpaperAdapter(dataWallPaper, this)
    }

    override fun onItemsClick(position: Int) {
        val intent = Intent(this, ShowItemsClickActivity::class.java)
        val bundle = Bundle()
        bundle.putInt("imvAvt", dataWallPaper.get(position).imvAvt)
        bundle.putString("tvMonth", dataWallPaper.get(position).tvMonth)
        bundle.putString("tvName", dataWallPaper.get(position).tvName)
        intent.putExtras(bundle)
        val exitTransition: Transition =
            TransitionInflater.from(this).inflateTransition(android.R.transition.explode)
        window.exitTransition = exitTransition
        val enterTransition: Transition =
            TransitionInflater.from(this).inflateTransition(android.R.transition.fade)
        window.enterTransition = enterTransition
        startActivity(intent)
    }
}
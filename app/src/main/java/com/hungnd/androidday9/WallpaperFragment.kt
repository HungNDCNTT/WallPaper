package com.hungnd.androidday9


import android.os.Bundle
import android.transition.Transition
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hungnd.androidday9.adpater.WallpaperAdapter
import com.hungnd.androidday9.interfaces.ItemsClick
import com.hungnd.androidday9.model.WallpaperModel
import java.util.*

class WallpaperFragment : Fragment(), ItemsClick {
    private val dataWallPaper = ArrayList<WallpaperModel>()
    private var rcvWallpaper: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_main, container, false)
        initData()
        rcvWallpaper = view?.findViewById(R.id.rcv_Show_WallPaper)
        rcvWallpaper?.layoutManager = GridLayoutManager(activity, 2)
        rcvWallpaper?.adapter = WallpaperAdapter(dataWallPaper, this)
        return view
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


    override fun onItemsClick(position: Int) {
        val exitTransition: Transition =
            TransitionInflater.from(activity).inflateTransition(android.R.transition.explode)
        setExitTransition(exitTransition)
        val enterTransition: Transition =
            TransitionInflater.from(activity).inflateTransition(android.R.transition.fade)
        setEnterTransition(enterTransition)
        (activity as WallpaperActivity?)
            ?.DetailWallpaper(dataWallPaper[position])

    }
}
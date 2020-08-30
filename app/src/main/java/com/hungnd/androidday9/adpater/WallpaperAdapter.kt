package com.hungnd.androidday9.adpater

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hungnd.androidday9.MainActivity
import com.hungnd.androidday9.interfaces.ItemsClick
import com.hungnd.androidday9.R
import com.hungnd.androidday9.model.WallpaperModel
import java.util.ArrayList

class WallpaperAdapter(
    val dataWallpaper: ArrayList<WallpaperModel>,
    private val itemsClick: ItemsClick
) :
    RecyclerView.Adapter<WallpaperAdapter.HungDzHolder>() {
    inner class HungDzHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val imvAvatar = view.findViewById<ImageView>(R.id.imv_Avt)
        val tvMonth = view.findViewById<TextView>(R.id.tv_Month)
        val tvName = view.findViewById<TextView>(R.id.tv_Name)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            itemsClick.onItemsClick(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HungDzHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_wallpaper, parent, false)
        return HungDzHolder(view)
    }

    override fun onBindViewHolder(holder: HungDzHolder, position: Int) {
        holder.imvAvatar.setImageResource(dataWallpaper[position].imvAvt)
        holder.tvMonth.text = dataWallpaper[position].tvMonth
        holder.tvName.text = dataWallpaper[position].tvName
    }

    override fun getItemCount(): Int {
        return dataWallpaper.size
    }


}
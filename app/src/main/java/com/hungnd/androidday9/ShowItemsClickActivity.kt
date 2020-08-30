package com.hungnd.androidday9

import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.show_items_click.*


class ShowItemsClickActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_items_click)
        val bundle = intent.extras
        if (bundle != null) {
            imv_Show.setImageResource(bundle.getInt("imvAvt"))
            tv_Show_Month.text = bundle.getString("tvMonth")
            tv_Show_Name.text = bundle.getString("tvName")
        } else {
            Toast.makeText(this, "No Hope", Toast.LENGTH_SHORT).show()
        }
        btn_Set_Wallpaper.setOnClickListener {
            val bitmap: Bitmap =
                BitmapFactory.decodeResource(resources, bundle?.getInt("imvAvt")!!)
            val wallpaperManager = WallpaperManager.getInstance(baseContext)
            wallpaperManager.setBitmap(bitmap)
            val snack = Snackbar.make(it, "Success !!", Snackbar.LENGTH_LONG)
            snack.show()
            btn_Set_Wallpaper.visibility = View.GONE
            finish()
        }

    }
}
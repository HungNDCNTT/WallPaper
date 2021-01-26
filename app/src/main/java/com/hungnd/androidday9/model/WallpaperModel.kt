package com.hungnd.androidday9.model

class WallpaperModel {
    constructor()
    constructor(imvAvt: Int, tvMonth: String, tvName: String) : this() {
        this.imvAvt = imvAvt
        this.tvMonth = tvMonth
        this.tvName = tvName
    }
    var imvAvt: Int = 0
    var tvMonth: String = ""
    var tvName: String = ""


}


package com.maytemur.besinlerkitabi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName



data class Besin (

    @SerializedName ("isim") val besinIsim : String?, // 800 veride protein var 100 tanesinde yok

    @SerializedName ("kalori")  val besinKalori : String?,//ihtimallerine karşılık nullable tanımlıyoruz

    @SerializedName("karbonhidrat") val besinKarbonhidrat : String?,
    @SerializedName("protein") val besinProtein : String?,
    @SerializedName("yag") val besinYag : String?,
    @SerializedName("gorsel") val besinGorsel : String?){

}
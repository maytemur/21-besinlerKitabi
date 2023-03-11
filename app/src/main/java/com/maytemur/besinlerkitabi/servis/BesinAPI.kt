package com.maytemur.besinlerkitabi.servis

import com.maytemur.besinlerkitabi.model.Besin
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface BesinAPI {
    //GET isteği , POST(sunucuya veri gönderirken) isteği
    //https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json
    // Base - Url -> https://raw.githubusercontent.com/
    // atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json

    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
        fun getBesin() : Single<List<Besin>>    //Call<List<Besin>> şeklinde de kullanılabilir
                                                //RxJava kullanmak için böyle yaptık
}
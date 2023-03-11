package com.maytemur.besinlerkitabi.viewmodel
//herbir view için bir viewmodel oluştur der mvvm model yapısı

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maytemur.besinlerkitabi.model.Besin

class BesinDetayiViewModel : ViewModel() {
    val besinLiveData = MutableLiveData<Besin>()

    fun roomVerisiniAl() {
        val muz = Besin("Muz", "40", "3", "2", "1", "www.test.com")
        besinLiveData.value = muz

    }
}
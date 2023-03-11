package com.maytemur.besinlerkitabi.viewmodel
//herbir view için bir viewmodel oluştur der mvvm model yapısı
import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maytemur.besinlerkitabi.model.Besin
import com.maytemur.besinlerkitabi.servis.BesinAPIServis
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class BesinListesiViewModel : ViewModel() {
    val besinler = MutableLiveData<List<Besin>>()
    val besinHataMesaji = MutableLiveData<Boolean>()
    val besinYukleniyor = MutableLiveData<Boolean>()

    private val besinApiServis = BesinAPIServis()
    private val disposable = CompositeDisposable() // kullan at veri

    fun refreshData() {
//        val muz = Besin("Muz","40","3","2","1","www.test.com")
//        val cilek = Besin("Çilek","45","3","2","1","www.test.com")
//        val elma = Besin("Elma","50","3","2","1","www.test.com")
//
//        val besinListesi = arrayListOf<Besin>(muz,cilek,elma)
//
//        besinler.value = besinListesi
//        besinHataMesaji.value = false
//        besinYukleniyor.value = false
        // retrofit sonrası örnek verilere ihtiyaç kalmadı
        verileriInternettenAl()
    }

    private fun verileriInternettenAl() {
        besinYukleniyor.value = true
        //IO thread -input output ver, alış verişi için genelde thread -
        // default -daha çok cpu yoğun görsel işlerlerde - UI kullanıcının arayüzü ile ilgili işlemleri yaptığımız
        disposable.add( //kullan at data
            besinApiServis.getData()
                .subscribeOn(Schedulers.newThread())  //yeni bir threadde asenkron olarak
                .observeOn(AndroidSchedulers.mainThread()) //single gözlemlenebilir objesine bununla kayıt(subscribe)
                // oluyoruz-bunu main threadde kullanıcya göstermemiz gerekiyor
                //bunuda observe on ile yapıyoruz, yani önce arka planda
                // yeni threadde kayıt olup gözlemledik sonra ana main threadde kullanıcıya gösteriyoruz
                .subscribeWith(object : DisposableSingleObserver<List<Besin>>() {
                    //Disposable abstract class olduğundan
                    //object: ile object olarak tanımlamamız gerekiyor. Soyut sınıfın uygulaması gereken öğeler var
                    //succes ve error
                    override fun onSuccess(t: List<Besin>) {
                        //Başarılı Olursa
                        besinler.value = t
                        besinHataMesaji.value = false
                        besinYukleniyor.value = false
                    }

                    override fun onError(e: Throwable) {
                        //Hata Alırsak
                        besinHataMesaji.value = true
                        besinYukleniyor.value = false
                        e.printStackTrace()
                    }
                })
        )
    }
}
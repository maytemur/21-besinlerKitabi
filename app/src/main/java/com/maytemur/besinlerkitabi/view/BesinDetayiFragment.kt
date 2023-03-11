package com.maytemur.besinlerkitabi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.maytemur.besinlerkitabi.R
import com.maytemur.besinlerkitabi.model.Besin
import com.maytemur.besinlerkitabi.model.besin2
import com.maytemur.besinlerkitabi.viewmodel.BesinDetayiViewModel
import kotlinx.android.synthetic.main.fragment_besin_detayi.*

class BesinDetayiFragment : Fragment() {
    private var besinId = 0
    private lateinit var viewModel : BesinDetayiViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_besin_detayi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(BesinDetayiViewModel::class.java)
        viewModel.roomVerisiniAl()

        arguments?.let {
            //besinId = BesinDetayiFragmentArgs
        }
        observeLiveData()
    }

    fun observeLiveData () {
        viewModel.besinLiveData.observe(viewLifecycleOwner, Observer { besin ->
            besin?.let {
                besin_ismi.text = it.besinIsim
                besin_kalori.text = it.besinKalori
                besin_karbonhidrat.text= it.besinKarbonhidrat
                besin_protein.text= it.besinProtein
                besin_yag.text = it.besinYag

            }

        })
    }

}
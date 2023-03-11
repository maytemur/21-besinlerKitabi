package com.maytemur.besinlerkitabi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.maytemur.besinlerkitabi.R
import com.maytemur.besinlerkitabi.model.Besin
import com.maytemur.besinlerkitabi.util.gorselIndir
import com.maytemur.besinlerkitabi.util.placeholderYapalim
import com.maytemur.besinlerkitabi.view.BesinListesiFragmentDirections
import kotlinx.android.synthetic.main.besin_recycler_row.view.*

class BesinRecyclerAdapter(val besinListesi: ArrayList<Besin>) : RecyclerView.Adapter<BesinRecyclerAdapter.BesinViewHolder>() {
    class BesinViewHolder(itemView: View) : RecyclerView.ViewHolder (itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BesinViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.besin_recycler_row,parent,false)
        return BesinViewHolder(view)
    }

    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {
        holder.itemView.besinIsmi.text = besinListesi.get(position).besinIsim
        holder.itemView.besinKalorisi.text = besinListesi.get(position).besinKalori
        //gorsel kısmı eklenecek
        holder.itemView.imageView.gorselIndir(besinListesi.get(position).besinGorsel,
            placeholderYapalim(holder.itemView.context))

        holder.itemView.setOnClickListener {
            val action = BesinListesiFragmentDirections.actionBesinListesiFragmentToBesinDetayiFragment()
            Navigation.findNavController(it).navigate(action)



        }

    }

    override fun getItemCount(): Int {
        return besinListesi.size
    }

    fun besinListesiGuncelle (yeniBesinListesi: List<Besin>){
        besinListesi.clear()
        besinListesi.addAll(yeniBesinListesi)
        notifyDataSetChanged()

    }

}
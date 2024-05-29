package com.laundryukurukur.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.laundry.mendadaklaundry.Database.Order
import com.laundry.mendadaklaundry.Database.OrderSementara
import com.laundry.mendadaklaundry.Database.RiwayatTb
import com.laundry.mendadaklaundry.R

class AdapterRiwayat ( private  val proses: ArrayList<RiwayatTb>,private val listener: AdapterRiwayat.OnAdapterListener)
    : RecyclerView.Adapter<AdapterRiwayat.ProsesViewHolder>() {
    class ProsesViewHolder(view: View) :  RecyclerView.ViewHolder(view) {
//        val textTanggal: TextView = view.findViewById(R.id.txtTanggal)
        val cardHistory : CardView = view.findViewById(R.id.cardHistory)
        val textKtg: TextView = view.findViewById(R.id.textKategori)
        val textJenis : TextView = view.findViewById(R.id.textJenis)
        val textName: TextView = view.findViewById(R.id.textNama)
        val textNo: TextView = view.findViewById(R.id.textNo)
        val textPkt: TextView = view.findViewById(R.id.textPaket)
        val textQnt: TextView = view.findViewById(R.id.textQnt)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProsesViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardviewhistory, parent, false)
        return ProsesViewHolder(v)
    }
    override fun getItemCount(): Int {
        return proses.size
    }

    override fun onBindViewHolder(holder: ProsesViewHolder, position: Int) {
        val onProses = proses[position]
//        holder.textTanggal.text = onProses.tanggal.toString()
        holder.textJenis.text = onProses.Jenis
        holder.textKtg.text = onProses.kategori
        holder.textName.text = onProses.name
        holder.textNo.text = onProses.phone
        holder.textPkt.text = onProses.paket
        holder.textQnt.text = onProses.kuantitas.toString() + " KG"
        holder.cardHistory.setOnClickListener {
            listener.onClick(onProses)
        }
    }
    fun setData(list: List<RiwayatTb>) {
        proses.clear()
        Log.d("Debug Set Data", "RESPONSE: $list")
        proses.addAll(list)
        notifyDataSetChanged()
    }
    interface OnAdapterListener{
        fun onClick(onProses: RiwayatTb)
    }

}
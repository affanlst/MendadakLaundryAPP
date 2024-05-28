package com.laundryukurukur.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.laundry.mendadaklaundry.Database.Order
import com.laundry.mendadaklaundry.Database.OrderSementara
import com.laundry.mendadaklaundry.R

class AdapterOrder (private  val proses: ArrayList<OrderSementara>,private val listener: OnAdapterListener)
    : RecyclerView.Adapter<AdapterOrder.ProsesViewHolder>() {
    class ProsesViewHolder(view: View) :  RecyclerView.ViewHolder(view) {
//        val textId : TextView = view.findViewById(R.id.textId)
        val textKtg: TextView = view.findViewById(R.id.textKategori)
        val textJenis : TextView = view.findViewById(R.id.textJenis)
        val textName: TextView = view.findViewById(R.id.textNama)
        val textNo: TextView = view.findViewById(R.id.textNo)
        val textPkt: TextView = view.findViewById(R.id.textPaket)
        val textQnt: TextView = view.findViewById(R.id.textQnt)
        val iconDelete : ImageView = view.findViewById(R.id.sampah)
        val iconCheck : ImageView = view.findViewById(R.id.check)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProsesViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return ProsesViewHolder(v)
    }
    override fun getItemCount(): Int {
        return proses.size
    }

    override fun onBindViewHolder(holder: ProsesViewHolder, position: Int) {
        val onProses = proses[position]
//        holder.textId.text = onProses.id.toString()
        holder.textJenis.text = onProses.Jenis
        holder.textKtg.text = onProses.kategori
        holder.textName.text = onProses.name
        holder.textNo.text = onProses.phone
        holder.textPkt.text = onProses.paket
        holder.textQnt.text = onProses.kuantitas.toString() + " KG"
        holder.iconDelete.setOnClickListener {
            listener.onDeletecart(onProses)
        }
        holder.iconCheck.setOnClickListener{
            listener.onClick(onProses)
        }
    }
    fun setData(list: List<OrderSementara>) {
        proses.clear()
        Log.d("Debug Set Data", "RESPONSE: $list")
        proses.addAll(list)
        notifyDataSetChanged()
    }
    interface OnAdapterListener{
        fun onDeletecart(onProses:OrderSementara)
        fun onClick(onProses: OrderSementara)
        }
}
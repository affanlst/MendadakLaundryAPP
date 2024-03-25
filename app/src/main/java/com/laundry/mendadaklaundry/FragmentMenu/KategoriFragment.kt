package com.laundry.mendadaklaundry.FragmentMenu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.laundry.mendadaklaundry.HargaLaundry
import com.laundry.mendadaklaundry.PaketLaundry
import com.laundry.mendadaklaundry.R

class KategoriFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var kategori = ""
        var bundle = Bundle()
        val view = inflater.inflate(R.layout.fragment_kategori, container, false)
        var btnCcSetrika : CardView = view.findViewById(R.id.cardKategoriCCSetrika)
        var btnCcKering : CardView = view.findViewById(R.id.cardKategoriCuciKering)
        var btnCCBasah : CardView =  view.findViewById(R.id.cardKategoriCuciBasah)
        var btnSetrika : CardView = view.findViewById(R.id.cardKategoriSetrika)
        btnCcSetrika.setOnClickListener {
            kategori = "Cuci Setrika"
            val intent = Intent(activity, HargaLaundry::class.java)
            bundle.putString("Kategori", kategori)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
        }
        btnCcKering.setOnClickListener {
            kategori = "Cuci Kering"
            val intent = Intent(activity, HargaLaundry::class.java)
            bundle.putString("Kategori", kategori)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
        }
        btnCCBasah.setOnClickListener {
            kategori = "Cuci Basah"
            val intent = Intent(activity, HargaLaundry::class.java)
            bundle.putString("Kategori", kategori)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
        }
        btnSetrika.setOnClickListener {
            kategori = "Setrika"
            val intent = Intent(activity, HargaLaundry::class.java)
            bundle.putString("Kategori", kategori)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
        }
        return view

    }
}
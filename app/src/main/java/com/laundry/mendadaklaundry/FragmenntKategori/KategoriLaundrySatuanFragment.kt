package com.laundry.mendadaklaundry.FragmenntKategori

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.cardview.widget.CardView
import com.laundry.mendadaklaundry.MainActivity
import com.laundry.mendadaklaundry.PaketLaundry
import com.laundry.mendadaklaundry.R

class KategoriLaundrySatuanFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentManager = requireActivity().supportFragmentManager
        var kategori = ""
        var Jenis  = "Laundry_Satuan"
        var bundle = Bundle()
        val view = inflater.inflate(R.layout.fragment_kategori_laundrysatuan, container, false)
        var btnGordenKecil : CardView = view.findViewById(R.id.cardKategoriGordenKecil)
        var btnGordenBesar : CardView =  view.findViewById(R.id.cardKategoriGordenBesar)
        var btnBonekaTas : CardView = view.findViewById(R.id.cardKategoriBonekaTas)
        var btnTopi : CardView =  view.findViewById(R.id.cardKategoriTopi)
        btnGordenKecil.setOnClickListener {
            kategori = "Gorden Kecil"
            val intent = Intent(activity, PaketLaundry::class.java)
            bundle.putString("Kategori", kategori)
            bundle.putString("Jenis", Jenis)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
            fragmentManager.popBackStackImmediate()
            requireActivity().finish()
        }
        btnGordenBesar.setOnClickListener {
            kategori = "Gorden Besar"
            val intent = Intent(activity, PaketLaundry::class.java)
            bundle.putString("Kategori", kategori)
            bundle.putString("Jenis", Jenis)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
            fragmentManager.popBackStackImmediate()
            requireActivity().finish()
        }
        btnBonekaTas.setOnClickListener {
            kategori = "Boneka dan Tas"
            val intent = Intent(activity, PaketLaundry::class.java)
            bundle.putString("Kategori", kategori)
            bundle.putString("Jenis", Jenis)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
            fragmentManager.popBackStackImmediate()
            requireActivity().finish()
        }
        btnTopi.setOnClickListener {
            kategori = "Topi"
            val intent = Intent(activity, PaketLaundry::class.java)
            bundle.putString("Kategori", kategori)
            bundle.putString("Jenis", Jenis)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
            fragmentManager.popBackStackImmediate()
            requireActivity().finish()
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Intent ke activity lain
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }
        })
        return view
    }
}
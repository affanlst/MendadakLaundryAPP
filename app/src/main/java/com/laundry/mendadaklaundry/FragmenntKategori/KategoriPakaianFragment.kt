package com.laundry.mendadaklaundry.FragmenntKategori

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import com.laundry.mendadaklaundry.HargaLaundry
import com.laundry.mendadaklaundry.KategoriActivity
import com.laundry.mendadaklaundry.MainActivity
import com.laundry.mendadaklaundry.PaketLaundry
import com.laundry.mendadaklaundry.R

class KategoriPakaianFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentManager = requireActivity().supportFragmentManager
        var kategori = ""
        var Jenis  = "Pakaian"
        var bundle = Bundle()
        val view = inflater.inflate(R.layout.fragment_kategori, container, false)
        var btnCcSetrika : CardView = view.findViewById(R.id.cardKategoriCCSetrika)
        var btnCcKering : CardView = view.findViewById(R.id.cardKategoriCuciKering)
        var btnCCBasah : CardView =  view.findViewById(R.id.cardKategoriCuciBasah)
        var btnSetrika : CardView = view.findViewById(R.id.cardKategoriSetrika)
        btnCcSetrika.setOnClickListener {
            kategori = "Cuci_Setrika"
            val intent = Intent(activity, PaketLaundry::class.java)
            bundle.putString("Kategori", kategori)
            bundle.putString("Jenis", Jenis)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
            fragmentManager.popBackStackImmediate()
            requireActivity().finish()
        }
        btnCcKering.setOnClickListener {
            kategori = "Cuci_Kering"
            val intent = Intent(activity, PaketLaundry::class.java)
            bundle.putString("Kategori", kategori)
            bundle.putString("Jenis", Jenis)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
            fragmentManager.popBackStackImmediate()
            requireActivity().finish()
        }
        btnCCBasah.setOnClickListener {
            kategori = "Cuci_Basah"
            val intent = Intent(activity, PaketLaundry::class.java)
            bundle.putString("Kategori", kategori)
            bundle.putString("Jenis", Jenis)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
            fragmentManager.popBackStackImmediate()
            requireActivity().finish()
        }
        btnSetrika.setOnClickListener {
            kategori = "Setrika"
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
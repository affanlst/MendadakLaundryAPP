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

class KategoriSelimutFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentManager = requireActivity().supportFragmentManager
        var kategori = ""
        var Jenis  = "Selimut"
        var bundle = Bundle()
        val view = inflater.inflate(R.layout.fragment_kategori_selimut, container, false)
        var btnBedCover : CardView = view.findViewById(R.id.cardBedCover)
        var btnSprei : CardView = view.findViewById(R.id.cardSprei)
        var btnSelimut : CardView =  view.findViewById(R.id.cardSelimut)
        btnBedCover.setOnClickListener {
            kategori = "Bed_Cover"
            val intent = Intent(activity, PaketLaundry::class.java)
            bundle.putString("Kategori", kategori)
            bundle.putString("Jenis", Jenis)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
            fragmentManager.popBackStackImmediate()
            requireActivity().finish()
        }
        btnSprei.setOnClickListener {
            kategori = "Sprei"
            val intent = Intent(activity, PaketLaundry::class.java)
            bundle.putString("Kategori", kategori)
            bundle.putString("Jenis", Jenis)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
            fragmentManager.popBackStackImmediate()
            requireActivity().finish()
        }
        btnSelimut.setOnClickListener {
            kategori = "Selimut"
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
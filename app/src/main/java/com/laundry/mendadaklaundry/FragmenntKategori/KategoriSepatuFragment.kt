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

class KategoriSepatuFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentManager = requireActivity().supportFragmentManager
        // Inflate the layout for this fragment
        var kategori = ""
        var Jenis  = "Sepatu"
        var bundle = Bundle()
        val view = inflater.inflate(R.layout.fragment_kategori_sepatu, container, false)
        var btnfastClean : CardView = view.findViewById(R.id.cardKategoriFastClean)
        var btnSepatuKulit : CardView = view.findViewById(R.id.cardKategoruSepatuKulit)
        var btndeepClean : CardView =  view.findViewById(R.id.cardKategorideepClean)
        var btnSepatuWanita : CardView = view.findViewById(R.id.cardKategoriSepatuWanita)
        var btnSandal : CardView = view.findViewById(R.id.cardKategoriSandal)
        btnfastClean.setOnClickListener {
            kategori = "Fast Clean"
            val intent = Intent(activity, PaketLaundry::class.java)
            bundle.putString("Kategori", kategori)
            bundle.putString("Jenis", Jenis)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
            fragmentManager.popBackStackImmediate()
            requireActivity().finish()
        }
        btnSepatuKulit.setOnClickListener {
            kategori = "Wash"
            val intent = Intent(activity, PaketLaundry::class.java)
            bundle.putString("Kategori", kategori)
            bundle.putString("Jenis", Jenis)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
            fragmentManager.popBackStackImmediate()
            requireActivity().finish()
        }
        btndeepClean.setOnClickListener {
            kategori = "Deep Clean"
            val intent = Intent(activity, PaketLaundry::class.java)
            bundle.putString("Kategori", kategori)
            bundle.putString("Jenis", Jenis)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
            fragmentManager.popBackStackImmediate()
            requireActivity().finish()
        }
        btnSepatuKulit.setOnClickListener {
            kategori = "Sepatu Kulit"
            val intent = Intent(activity, PaketLaundry::class.java)
            bundle.putString("Kategori", kategori)
            bundle.putString("Jenis", Jenis)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
            fragmentManager.popBackStackImmediate()
            requireActivity().finish()
        }
        btnSepatuWanita.setOnClickListener {
            kategori = "Sepatu Wanita"
            val intent = Intent(activity, PaketLaundry::class.java)
            bundle.putString("Kategori", kategori)
            bundle.putString("Jenis", Jenis)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
            fragmentManager.popBackStackImmediate()
            requireActivity().finish()
        }
        btnSandal.setOnClickListener {
            kategori = "Sandal"
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

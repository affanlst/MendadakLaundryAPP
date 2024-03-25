package com.laundry.mendadaklaundry.FragmentMenu

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.laundry.mendadaklaundry.MainActivity
import com.laundry.mendadaklaundry.PaketLaundry
import com.laundry.mendadaklaundry.R

class Home : Fragment() {
    var Jenis = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val buttonPakaian : CardView = view.findViewById(R.id.CardPakaian)
        val buttonSelimut : CardView = view.findViewById(R.id.CardSelimut)
        val buttonSepatu : CardView = view.findViewById(R.id.CardSepatu)
        val buttonJas : CardView = view.findViewById(R.id.CardJas)
        val bundle = Bundle()
        buttonPakaian.setOnClickListener {
            Jenis = "Pakaian"
            val intent = Intent(activity, PaketLaundry::class.java)
            bundle.putString("Jenis", Jenis)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
        }
        buttonSelimut.setOnClickListener {
            Jenis  = "Selimut"
            bundle.putString("Jenis", Jenis)
            val intent = Intent(activity, PaketLaundry::class.java)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
        }
        buttonSepatu.setOnClickListener {
            Jenis = "Sepatu"
            bundle.putString("Jenis",Jenis)
            val intent = Intent(activity, PaketLaundry::class.java)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
        }
        buttonJas.setOnClickListener {
            Jenis = "Jas"
            bundle.putString("Jenis",Jenis)
            val intent = Intent(activity, PaketLaundry::class.java)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
        }
        return view


    }
}
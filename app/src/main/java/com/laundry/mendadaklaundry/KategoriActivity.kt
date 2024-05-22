package com.laundry.mendadaklaundry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.laundry.mendadaklaundry.FragmenntKategori.KategoriLaundrySatuanFragment
import com.laundry.mendadaklaundry.FragmenntKategori.KategoriPakaianFragment
import com.laundry.mendadaklaundry.FragmenntKategori.KategoriSelimutFragment
import com.laundry.mendadaklaundry.FragmenntKategori.KategoriSepatuFragment

class KategoriActivity : AppCompatActivity() {
    var Jenis = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kategori)
        val bundle = intent.extras
        if (bundle != null){
            Jenis = bundle.getString("Jenis").toString()
        }
        if (Jenis == "Pakaian"){
            replacefragment(KategoriPakaianFragment())
        }
        else if(Jenis == "Sepatu"){
            replacefragment(KategoriSepatuFragment())
        }
        else if(Jenis == "Laundry_Satuan"){
            replacefragment(KategoriLaundrySatuanFragment())
        }
        else if(Jenis == "Selimut"){
            replacefragment(KategoriSelimutFragment())
        }

    }

    private fun replacefragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(
            R.id.RelativeKategori, fragment
        )
        fragmentTransaction.commit()
    }
}
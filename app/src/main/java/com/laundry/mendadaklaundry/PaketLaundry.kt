package com.laundry.mendadaklaundry

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher

import androidx.cardview.widget.CardView
import androidx.core.content.ContentProviderCompat.requireContext

class PaketLaundry : AppCompatActivity() {
    var Jenis = ""
    var Paket = ""
    var Kategori = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paket_laundry)
        var buttonPaketRegular : CardView = findViewById(R.id.cardPaketReguler)
        var buttonPaketExpress : CardView =  findViewById(R.id.cardPaketExpress)
        val bundlePaket = Bundle()
        val bundle = intent.extras
        if (bundle != null){
            Jenis = bundle.getString("Jenis").toString()
            Kategori = bundle.getString("Kategori").toString()
        }
        buttonPaketRegular.setOnClickListener{
            Paket = "Regular"
            val intent = Intent(this, HargaLaundry::class.java)
            bundlePaket.putString("Jenis", Jenis)
            bundlePaket.putString("Paket", Paket)
            bundlePaket.putString("Kategori", Kategori)
            intent.putExtras(bundlePaket)
            startActivity(intent)
            finish()
        }
        buttonPaketExpress.setOnClickListener{
            Paket = "Express"
            val intent = Intent(this, HargaLaundry::class.java)
            bundlePaket.putString("Jenis", Jenis)
            bundlePaket.putString("Paket", Paket)
            bundlePaket.putString("Kategori", Kategori)
            intent.putExtras(bundlePaket)
            startActivity(intent)
            finish()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val bundlePaket = Bundle()
        val bundle = intent.extras
        if (bundle != null){
            Jenis = bundle.getString("Jenis").toString()
        }
        bundlePaket.putString("Jenis", Jenis)
        val intent = Intent(this, KategoriActivity::class.java)
        intent.putExtras(bundlePaket)
        startActivity(intent)
        finish()
    }

}
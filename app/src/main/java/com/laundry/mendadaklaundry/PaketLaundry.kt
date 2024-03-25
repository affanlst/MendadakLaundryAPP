package com.laundry.mendadaklaundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView

class PaketLaundry : AppCompatActivity() {
    var Jenis = ""
    var Paket = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paket_laundry)
        var buttonPaketRegular : CardView = findViewById(R.id.cardPaketReguler)
        var buttonPaketExpress : CardView =  findViewById(R.id.cardPaketExpress)
        val bundlePaket = Bundle()
        val bundle = intent.extras
        if (bundle != null){
            Jenis = bundle.getString("Jenis").toString()
        }
        buttonPaketRegular.setOnClickListener{
            Paket = "Regular"
            if(Jenis == "Pakaian"){
                val intent = Intent(this, HargaLaundry::class.java)
                bundlePaket.putString("Jenis", Jenis)
                bundlePaket.putString("Paket", Paket)
                intent.putExtras(bundlePaket)
                startActivity(intent)
            }
            else if(Jenis == "Selimut"){
                val intent = Intent(this, HargaLaundry::class.java)
                bundlePaket.putString("Jenis", Jenis)
                bundlePaket.putString("Paket", Paket)
                intent.putExtras(bundlePaket)
                startActivity(intent)
            }
            else if(Jenis == "Sepatu"){
                val intent = Intent(this, HargaLaundry::class.java)
                bundlePaket.putString("Jenis", Jenis)
                bundlePaket.putString("Paket", Paket)
                intent.putExtras(bundlePaket)
                startActivity(intent)
            }
            else if(Jenis == "Jas"){
                val intent = Intent(this, HargaLaundry::class.java)
                bundlePaket.putString("Jenis", Jenis)
                bundlePaket.putString("Paket", Paket)
                intent.putExtras(bundlePaket)
                startActivity(intent)
            }
        }
        buttonPaketExpress.setOnClickListener{
            Paket = "Express"
            if(Jenis == "Pakaian"){
                val intent = Intent(this, HargaLaundry::class.java)
                bundlePaket.putString("Jenis", Jenis)
                bundlePaket.putString("Paket", Paket)
                intent.putExtras(bundlePaket)
                startActivity(intent)
            }
            else if(Jenis == "Selimut"){
                val intent = Intent(this, HargaLaundry::class.java)
                bundlePaket.putString("Jenis", Jenis)
                bundlePaket.putString("Paket", Paket)
                intent.putExtras(bundlePaket)
                startActivity(intent)
            }
            else if(Jenis == "Sepatu"){
                val intent = Intent(this, HargaLaundry::class.java)
                bundlePaket.putString("Jenis", Jenis)
                bundlePaket.putString("Paket", Paket)
                intent.putExtras(bundlePaket)
                startActivity(intent)
            }
            else if(Jenis == "Jas"){
                val intent = Intent(this, HargaLaundry::class.java)
                bundlePaket.putString("Jenis", Jenis)
                bundlePaket.putString("Paket", Paket)
                intent.putExtras(bundlePaket)
                startActivity(intent)
            }
        }
    }
}
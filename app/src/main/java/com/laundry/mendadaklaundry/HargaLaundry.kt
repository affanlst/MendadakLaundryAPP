package com.laundry.mendadaklaundry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.laundry.mendadaklaundry.Database.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HargaLaundry : AppCompatActivity() {
    var Jenis = ""
    var Paket = ""
    var Kategori = ""
    var Total = 0
    var harga = 0
    var Kuantitas = 0
    var PaketExpress = 1000
    var CuciSetrika = 3500
    var CuciKering = 2500
    var CuciBasah = 1500
    var Setrika = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_harga_laundry)
        val bundle = intent.extras
        if (bundle != null){
            Jenis = bundle.getString("Jenis").toString()
            Paket = bundle.getString("Paket").toString()
            Kategori = bundle.getString("Kategori").toString()
        }
        val buttonSubmitPesanan : Button = findViewById(R.id.btnInputPesanan)
        buttonSubmitPesanan.setOnClickListener {
            val kuantitas : EditText = findViewById(R.id.InputKuantitas)
            val Valkuantitas = kuantitas.text.toString()
            Kuantitas = Valkuantitas.toInt()
            if(Jenis == "Pakaian"){
                hitungHargaPakaian()
            }else if(Jenis == "Selimut"){
                hitungHargaSelimut()
            }else if(Jenis == "Sepatu"){
                hitungHargaSepatu()
            }else if(Jenis == "Jas"){
                hitungHargaJas()
            }
            inputData(Jenis,Paket,Kuantitas,Total)
        }
    }
    fun hitungHargaJas(){

        Total = harga*Kuantitas
    }
    fun hitungHargaSepatu(){

        Total = harga*Kuantitas
    }
    fun hitungHargaSelimut(){
        if (Kategori == "Cuci Setrika"){
            if(Paket == "Express"){
                harga = CuciSetrika + PaketExpress
            }else{
                harga = CuciSetrika
            }
        }else if(Kategori == "Cuci Kering"){
            if(Paket == "Express"){
                harga = CuciKering + PaketExpress
            }else{
                harga = CuciKering
            }
            harga = CuciKering + PaketExpress
        }else if(Kategori == "Cuci Basah"){
            if(Paket == "Express"){
                harga = CuciBasah + PaketExpress
            }else{
                harga = CuciBasah
            }
            harga = CuciBasah + PaketExpress
        }else if(Kategori == "Setrika"){
            if(Paket == "Express"){
                harga = Setrika + PaketExpress
            }else{
                harga = Setrika
            }
        }
        Total = harga*Kuantitas
    }
    fun hitungHargaPakaian(){
        if (Kategori == "Cuci Setrika"){
            if(Paket == "Express"){
                harga = CuciSetrika + PaketExpress
            }else{
                harga = CuciSetrika
            }
        }else if(Kategori == "Cuci Kering"){
            if(Paket == "Express"){
                harga = CuciKering + PaketExpress
            }else{
                harga = CuciKering
            }
            harga = CuciKering + PaketExpress
        }else if(Kategori == "Cuci Basah"){
            if(Paket == "Express"){
                harga = CuciBasah + PaketExpress
            }else{
                harga = CuciBasah
            }
            harga = CuciBasah + PaketExpress
        }else if(Kategori == "Setrika"){
            if(Paket == "Express"){
                harga = Setrika + PaketExpress
            }else{
                harga = Setrika
            }
        }
        Total = harga*Kuantitas
    }
    fun inputData(Kategori : String,Paket : String,Kuantitas : Int,Biaya : Int){
        val nameField = findViewById<EditText>(R.id.InputNamaPelanggan)
        val kategori = Kategori
        val paket = Paket
        val kuantitas = Kuantitas
        val biaya = Biaya
        val phoneField = findViewById<EditText>(R.id.InputNoHPPelanggan)
        CoroutineScope(Dispatchers.IO).launch {
            OrderApp(this@HargaLaundry).getOrderDao().addOrder(
                Order (0, nameField.text.toString(), phoneField.text.toString(), kategori, paket, "",kuantitas, biaya)
            )
            RiwayatApp(this@HargaLaundry).getOrderDao().addOrder(
                Order (0, nameField.text.toString(), phoneField.text.toString(), kategori, paket, "",kuantitas, biaya)
            )
        }
    }
}
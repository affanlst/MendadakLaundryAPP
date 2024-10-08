package com.laundry.mendadaklaundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.laundry.mendadaklaundry.Database.*
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Calendar

class HargaLaundry : AppCompatActivity() {
    var Jenis = ""
    var Paket = ""
    var Kategori = ""
    var Total = 0
    var harga = 0
    var Kuantitas = 0
    var PaketExpress = 1500
    var CuciSetrika = 4500
    var CuciKering = 3000
    var CuciBasah = 2000
    var Setrika = 3500
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
            inputData(Kategori,Paket,Kuantitas,Total,Jenis)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    fun hitungHargaJas(){
        Total = harga*Kuantitas
    }
    fun hitungHargaSepatu(){

        Total = harga*Kuantitas
    }
    fun hitungHargaSelimut(){
        if (Kategori.equals("Cuci_Setrika")){
            if(Paket == "Express"){
                harga = CuciSetrika + PaketExpress
            }else{
                harga = CuciSetrika
            }
        }else if(Kategori.equals("Cuci_Kering")){
            if(Paket == "Express"){
                harga = CuciKering + PaketExpress
            }else{
                harga = CuciKering
            }
        }else if(Kategori.equals("Cuci_Basah")){
            if(Paket == "Express"){
                harga = CuciBasah + PaketExpress
            }else{
                harga = CuciBasah
            }
        }else if(Kategori.equals("Setrika")){
            if(Paket == "Express"){
                harga = Setrika + PaketExpress
            }else{
                harga = Setrika
            }
        }
        Total = harga*Kuantitas
    }
    fun hitungHargaPakaian(){
        if (Kategori.equals("Cuci_Setrika")){
            if(Paket == "Express"){
                harga = CuciSetrika + PaketExpress
            }else{
                harga = CuciSetrika
            }
        }else if(Kategori.equals("Cuci_Kering")){
            if(Paket == "Express"){
                harga = CuciKering + PaketExpress
            }else{
                harga = CuciKering
            }
        }else if(Kategori.equals("Cuci_Basah")){
            if(Paket == "Express"){
                harga = CuciBasah + PaketExpress
            }else{
                harga = CuciBasah
            }
        }else if(Kategori.equals("Setrika")){
            if(Paket == "Express"){
                harga = Setrika + PaketExpress
            }else{
                harga = Setrika
            }
        }
        Total = harga*Kuantitas
    }
    fun inputData(Kategori : String,Paket : String,Kuantitas : Int,Biaya : Int, Jenis : String){
        val calendar = Calendar.getInstance()
        val currentDate = calendar.time
        val nameField = findViewById<EditText>(R.id.InputNamaPelanggan)
        val kategori = Kategori
        val paket = Paket
        val kuantitas = Kuantitas
        val biaya = Biaya
        val jenis = Jenis
        val phoneField = findViewById<EditText>(R.id.InputNoHPPelanggan)
        CoroutineScope(Dispatchers.Main).launch {
//            DatabaseBuilder(this@HargaLaundry).getOrderDao().addOrder(
//                Order(0, nameField.text.toString(), phoneField.text.toString(), jenis, paket, kategori,kuantitas, biaya)
//            )
            DatabaseBuilder(this@HargaLaundry).getOrderSemDao().addOrderSem(
                OrderSementara(0, nameField.text.toString(), phoneField.text.toString(), jenis, paket, kategori,kuantitas, biaya)
            )
//            DatabaseBuilder(this@HargaLaundry).getRiwayatDao().addOrder(
//                RiwayatTb(0, nameField.text.toString(), phoneField.text.toString(), jenis, paket, kategori,kuantitas, biaya)
//            )
        }
    }
}
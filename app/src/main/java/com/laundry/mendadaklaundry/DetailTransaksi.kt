package com.laundry.mendadaklaundry

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.laundry.mendadaklaundry.Database.DatabaseBuilder
import com.laundry.mendadaklaundry.Database.Order
import com.laundry.mendadaklaundry.Database.OrderSemDao
import com.laundry.mendadaklaundry.Database.OrderSementara
import com.laundry.mendadaklaundry.Database.RiwayatTb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.Calendar

class DetailTransaksi : AppCompatActivity() {
    lateinit var dao : OrderSemDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_transaksi)
        dao = DatabaseBuilder.invoke(this).getOrderSemDao()
//        val id = intent.getStringExtra("id")
        val currentDate = LocalDate.now()
        val nama = intent.getStringExtra("nama")
        val no = intent.getStringExtra("No")
        val jenis = intent.getStringExtra("jenis")
        val kategori = intent.getStringExtra("kategori")
        val paket = intent.getStringExtra("paket")
        val kuantitas = intent.getIntExtra("kuantitas",0)
        val total = intent.getIntExtra("harga",0)
        val txtTanggal : TextView = findViewById(R.id.TglPesan)
        val txtnama : TextView = findViewById(R.id.Nama)
        val txtno : TextView = findViewById(R.id.noTLP)
        val txtjenis : TextView = findViewById(R.id.Jenis)
        val txtKategori : TextView = findViewById(R.id.KategoriDetail)
        val txtPaket : TextView = findViewById(R.id.PaketDetail)
        val txtKuantitas : TextView = findViewById(R.id.KuantitasDetail)
        val txtTotal : TextView = findViewById(R.id.HargaDetail)
        val btnselesai : Button = findViewById(R.id.btnSelesaiPesanan)
        txtTanggal.setText(currentDate.toString())
        txtnama.setText(nama)
        txtjenis.setText(jenis)
        txtno.setText(no)
        txtKategori.setText(kategori)
        txtPaket.setText(paket)
        txtKuantitas.setText(kuantitas.toString())
        txtTotal.setText(total.toString())
        btnselesai.setOnClickListener{
            CoroutineScope(Dispatchers.Main).launch {
                DatabaseBuilder(this@DetailTransaksi).getRiwayatDao().addOrder(
                    RiwayatTb(0, nama.toString(), no.toString(), jenis.toString(), paket.toString(), kategori.toString(),kuantitas.toInt(), total.toInt())
                )
                DatabaseBuilder(this@DetailTransaksi).getOrderDao().addOrder(
                    Order(0, nama.toString(), no.toString(), jenis.toString(), paket.toString(), kategori.toString(),kuantitas.toInt(), total.toInt())
                )
                dao.deleteOrderSem( nama.toString(), no.toString(), jenis.toString(), paket.toString(), kategori.toString(),kuantitas.toInt(), total.toInt())
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
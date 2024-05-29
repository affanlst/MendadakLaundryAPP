package com.laundry.mendadaklaundry

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.laundry.mendadaklaundry.Database.DatabaseBuilder
import com.laundry.mendadaklaundry.Database.OrderSemDao
import com.laundry.mendadaklaundry.Database.RiwayatDao


class DetailRiwayat : AppCompatActivity() {
    lateinit var dao : RiwayatDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_riwayat)
        dao = DatabaseBuilder.invoke(this).getRiwayatDao()
//        val tanggal = intent.getStringExtra("tanggal")
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
        val btnselesai : Button = findViewById(R.id.btnKembali)
        val tanggalHist = dao.getTanggalByFilter(nama.toString(), no.toString(), jenis.toString(), paket.toString(), kategori.toString(),kuantitas, total)
        val convertedTanggal = tanggalHist.toString()
        val stringHasilTanggal = convertedTanggal.replace("[", "").replace("]","")
        txtTanggal.setText(stringHasilTanggal)
        txtnama.setText(nama)
        txtjenis.setText(jenis)
        txtno.setText(no)
        txtKategori.setText(kategori)
        txtPaket.setText(paket)
        txtKuantitas.setText(kuantitas.toString())
        txtTotal.setText(total.toString())
        btnselesai.setOnClickListener {
            finish()
        }
    }
}
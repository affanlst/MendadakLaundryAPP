package com.laundry.mendadaklaundry.FragmentMenu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.laundry.mendadaklaundry.Database.DatabaseBuilder
import com.laundry.mendadaklaundry.Database.Order
import com.laundry.mendadaklaundry.Database.OrderDao
import com.laundry.mendadaklaundry.Database.OrderSemDao
import com.laundry.mendadaklaundry.Database.OrderSementara
import com.laundry.mendadaklaundry.DetailTransaksi
import com.laundry.mendadaklaundry.KategoriActivity
import com.laundry.mendadaklaundry.MainActivity
import com.laundry.mendadaklaundry.PaketLaundry
import com.laundry.mendadaklaundry.R
import com.laundryukurukur.adapter.AdapterOrder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Calendar

class Home : Fragment() {
    var Jenis = ""
    lateinit var cartViewAdapter: AdapterOrder
    lateinit var dao : OrderSemDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dao = DatabaseBuilder.invoke(requireContext().applicationContext).getOrderSemDao()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycler()
    }
    override fun onStart() {
        super.onStart()
        loadDatamenu()
    }


    private fun setRecycler(){
        val list_proses: RecyclerView? = view?.findViewById(R.id.list_Proses)
        cartViewAdapter = AdapterOrder(arrayListOf(),object : AdapterOrder.OnAdapterListener{
            override fun onDeletecart(onProses: OrderSementara) {
                CoroutineScope(Dispatchers.Main).launch {
                    dao.deleteOrderSem(onProses)
                    withContext(Dispatchers.Main){
                        loadDatamenu()
                    }
                }
            }

            override fun onClick(onProses: OrderSementara) {
                startActivity(
                    Intent(requireContext().applicationContext, DetailTransaksi::class.java)
//                        .putExtra("id",onProses.id)
                        .putExtra("nama",onProses.name)
                        .putExtra("No",onProses.phone)
                        .putExtra("jenis",onProses.Jenis)
                        .putExtra("kategori",onProses.kategori)
                        .putExtra("paket",onProses.paket)
                        .putExtra("kuantitas",onProses.kuantitas)
                        .putExtra("harga",onProses.biaya)
                )
            }
        })
        list_proses?.apply {
            layoutManager = LinearLayoutManager(requireContext().applicationContext)
            adapter = cartViewAdapter
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val buttonPakaian : CardView = view.findViewById(R.id.CardPakaian)
        val buttonSelimut : CardView = view.findViewById(R.id.CardSelimut)
        val buttonSepatu : CardView = view.findViewById(R.id.CardSepatu)
        val buttonJas : CardView = view.findViewById(R.id.CardLaundrySatuan)
        val bundle = Bundle()
        buttonPakaian.setOnClickListener {
            Jenis = "Pakaian"
            val intent = Intent(activity, KategoriActivity::class.java)
            bundle.putString("Jenis", Jenis)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
            requireActivity().finish()
        }
        buttonSelimut.setOnClickListener {
            Jenis  = "Selimut"
            bundle.putString("Jenis", Jenis)
            val intent = Intent(activity, KategoriActivity::class.java)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
            requireActivity().finish()
        }
        buttonSepatu.setOnClickListener {
            Jenis = "Sepatu"
            bundle.putString("Jenis",Jenis)
            val intent = Intent(activity, KategoriActivity::class.java)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
            requireActivity().finish()
        }
        buttonJas.setOnClickListener {
            Jenis = "Laundry_Satuan"
            bundle.putString("Jenis",Jenis)
            val intent = Intent(activity, KategoriActivity::class.java)
            intent.putExtras(bundle)
            activity?.startActivity(intent)
            requireActivity().finish()
        }
        return view
    }
    fun loadDatamenu(){
        CoroutineScope(Dispatchers.Main).launch {
            val proses = dao.getAllOrderSem()
            Log.d("home", "dbResponse: $proses")
            withContext(Dispatchers.Main) {
                cartViewAdapter.setData(proses)
            }
        }
    }

}
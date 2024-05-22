package com.laundry.mendadaklaundry.FragmentMenu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.laundry.mendadaklaundry.Database.DatabaseBuilder
import com.laundry.mendadaklaundry.Database.OrderSemDao
import com.laundry.mendadaklaundry.Database.OrderSementara
import com.laundry.mendadaklaundry.Database.RiwayatDao
import com.laundry.mendadaklaundry.DetailTransaksi
import com.laundry.mendadaklaundry.R
import com.laundryukurukur.adapter.AdapterOrder
import com.laundryukurukur.adapter.AdapterRiwayat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class History : Fragment() {
    lateinit var cartViewAdapter: AdapterRiwayat
    lateinit var dao : RiwayatDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dao = DatabaseBuilder.invoke(requireContext().applicationContext).getRiwayatDao()
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
        val list_proses: RecyclerView? = view?.findViewById(R.id.historyRv)
        cartViewAdapter = AdapterRiwayat(arrayListOf())
        list_proses?.apply {
            layoutManager = LinearLayoutManager(requireContext().applicationContext)
            adapter = cartViewAdapter
        }
    }
    fun loadDatamenu(){
        CoroutineScope(Dispatchers.Main).launch {
            val proses = dao.getAllOrder()
            Log.d("home", "dbResponse: $proses")
            withContext(Dispatchers.Main) {
                cartViewAdapter.setData(proses)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

}
package com.laundry.mendadaklaundry.FragmentMenu

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.laundry.mendadaklaundry.Database.SessionManager
import com.laundry.mendadaklaundry.MainActivity

import com.laundry.mendadaklaundry.R
import com.laundry.mendadaklaundry.Rekap
import com.laundry.mendadaklaundry.loginActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//class Profile : Fragment() {
//
////    lateinit var btnlogout: Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//
//        var btnlogout : Button = view.findViewById(button_logout)
//
//
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_profile, container, false)
//    }
//}

class Profile : Fragment() {

    private lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val btnlogout : Button = view.findViewById(R.id.button_logout)
        val btnrekap : Button = view.findViewById(R.id.btn_rekap)
        sessionManager = (requireActivity() as MainActivity).sessionManager


        // Lakukan sesuatu dengan btnlogout
        btnlogout.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                sessionManager.clearLoginStatus()
                val intent = Intent(requireContext(), loginActivity::class.java)
                startActivity(intent)
                requireActivity().finish() // Menutup MainActivity setelah memulai LoginActivity
            }
        }


        btnrekap.setOnClickListener {
            val intent = Intent(requireContext(), Rekap::class.java)
            startActivity(intent)
        }

        return view
    }
}

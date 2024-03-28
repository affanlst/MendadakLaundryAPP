package com.laundry.mendadaklaundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import com.laundry.mendadaklaundry.Database.OrderApp
import com.laundry.mendadaklaundry.Database.SessionManager
import com.laundry.mendadaklaundry.Database.UserDao
import com.laundry.mendadaklaundry.FragmentMenu.History
import com.laundry.mendadaklaundry.FragmentMenu.Home
import com.laundry.mendadaklaundry.FragmentMenu.Profile
import com.laundry.mendadaklaundry.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var userDao: UserDao
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sessionManager = SessionManager(this)
        userDao = OrderApp.invoke(applicationContext).userDao()

        // Cek apakah pengguna sudah login saat pertama kali membuat aktivitas
        if (!sessionManager.isLoggedIn()) {
            // Jika belum login, pindah ke LoginActivity
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
            finish()
            return // Keluar dari fungsi onCreate agar tidak melanjutkan ke binding
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replacefragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replacefragment(Home())
                R.id.history -> replacefragment(History())
                R.id.profile -> replacefragment(Profile())
            }
            true
        }
    }

    private fun replacefragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(
            R.id.frameLayout, fragment
        )
        fragmentTransaction.commit()
    }
}
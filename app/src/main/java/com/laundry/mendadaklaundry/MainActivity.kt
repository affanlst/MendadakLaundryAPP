package com.laundry.mendadaklaundry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.laundry.mendadaklaundry.FragmentMenu.History
import com.laundry.mendadaklaundry.FragmentMenu.Home
import com.laundry.mendadaklaundry.FragmentMenu.Profile
import com.laundry.mendadaklaundry.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replacefragment(Home())
        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home -> replacefragment(Home())
                R.id.history -> replacefragment(History())
                R.id.profile -> replacefragment(Profile())

                else ->{}
            }
            true
        }
    }
    private fun replacefragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(
            R.id.frameLayout, fragment
        )
        fragmentTransaction.commit()
    }
}
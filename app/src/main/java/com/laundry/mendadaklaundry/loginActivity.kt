package com.laundry.mendadaklaundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class loginActivity : AppCompatActivity() {
    lateinit var username: EditText
    lateinit var password : EditText
    lateinit var buttonLogin : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        username = findViewById(R.id.input_email)
        password = findViewById(R.id.input_password)
        buttonLogin = findViewById(R.id.btn_login)
        buttonLogin.setOnClickListener {
            if(username.text.isNotEmpty() && password.text.isNotEmpty()){
                login(username.text.toString(),password.text.toString())
            }else{
                Toast.makeText(this,"" , Toast.LENGTH_SHORT).show()
            }
        }
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }

    fun login(username: String, password : String ){
        val UsernameA: String = "admin"
        val passwordA: String = "4dmin"
        if(username.equals(UsernameA) && password.equals(passwordA)){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        else{
            Toast.makeText(this, "Email atau kata Sandi salah", Toast.LENGTH_SHORT).show()
        }
    }
}
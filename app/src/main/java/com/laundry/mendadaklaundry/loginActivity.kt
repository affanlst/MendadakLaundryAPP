package com.laundry.mendadaklaundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.laundry.mendadaklaundry.Database.OrderApp
import com.laundry.mendadaklaundry.Database.SessionManager
import com.laundry.mendadaklaundry.Database.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class loginActivity : AppCompatActivity() {
    private lateinit var userDao: UserDao
    private lateinit var sessionManager: SessionManager

    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var btnlogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sessionManager = SessionManager(this)

        username = findViewById(R.id.input_email)
        password = findViewById(R.id.input_password)
        btnlogin = findViewById(R.id.btn_login)



        userDao = OrderApp.invoke(applicationContext).userDao()

        btnlogin.setOnClickListener {
            val inputUsername = username.text.toString()
            val inputPassword = password.text.toString()

            CoroutineScope(Dispatchers.IO).launch {
                val user = userDao.login(inputUsername, inputPassword)
                if (user != null) {
                    sessionManager.saveLoginStatus(true)
                    runOnUiThread {
                        val intent = Intent(this@loginActivity, MainActivity::class.java)
                        startActivity(intent)
                    }
                } else {
                    runOnUiThread {
                        Toast.makeText(
                            this@loginActivity,
                            "Login failed. Please check your username and password.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}
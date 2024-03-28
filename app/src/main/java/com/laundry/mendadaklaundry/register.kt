package com.laundry.mendadaklaundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.laundry.mendadaklaundry.Database.OrderApp
import com.laundry.mendadaklaundry.Database.UserDao
import com.laundry.mendadaklaundry.Database.UserEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class register : AppCompatActivity() {
    private lateinit var userDao: UserDao

    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var register: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        username = findViewById(R.id.input_username_register)
        password = findViewById(R.id.input_password_register)
        register = findViewById(R.id.btn_register)

        userDao = OrderApp.invoke(applicationContext).userDao()

        register.setOnClickListener {
            val username = username.text.toString()
            val password = password.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    val existingUser = userDao.getUserByUsername(username)
                    if (existingUser == null) {
                        val user = UserEntity(username = username, password = password)
                        userDao.register(user)

                        runOnUiThread {
                            Toast.makeText(
                                this@register,
                                "Registration successful",
                                Toast.LENGTH_SHORT
                            ).show()

                            // Setelah registrasi berhasil, arahkan pengguna ke halaman login
                            val intent = Intent(this@register, loginActivity::class.java)
                            startActivity(intent)
                            finish() // Selesai RegisterActivity
                        }
                    } else {
                        runOnUiThread {
                            Toast.makeText(
                                this@register,
                                "Username already exists",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            } else {
                Toast.makeText(
                    this@register,
                    "Username and password cannot be empty",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
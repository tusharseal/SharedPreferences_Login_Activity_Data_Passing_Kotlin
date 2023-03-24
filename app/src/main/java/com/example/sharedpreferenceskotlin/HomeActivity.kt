package com.example.sharedpreferenceskotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var textFullName: TextView
    private lateinit var textEmail: TextView
    private lateinit var buttonLogout: Button

    private val sharedPrefName = "LOGIN"
    private val keyName = "NAME"
    private val keyEmail = "EMAIL"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        textFullName = findViewById(R.id.textFullName)
        textEmail = findViewById(R.id.textEmail)
        buttonLogout = findViewById(R.id.buttonLogout)

        val sharedPreferences = getSharedPreferences(sharedPrefName, MODE_PRIVATE)

        val name = sharedPreferences.getString(keyName, null)
        val email = sharedPreferences.getString(keyEmail, null)

        if (name != null || email != null) {
            textFullName.text = "Fill Name: $name"
            textEmail.text = "Email: $email"
        }

        buttonLogout.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putBoolean("flag", false)
            editor.clear()
            editor.commit()
            finish()
            Toast.makeText(this@HomeActivity, "Logout Successfully", Toast.LENGTH_SHORT).show()
        }
    }
}
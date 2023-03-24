package com.example.sharedpreferenceskotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var buttonSave: Button

    private val sharedPrefName = "LOGIN"
    private val keyName = "NAME"
    private val keyEmail = "EMAIL"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextName = findViewById(R.id.editTextName)
        editTextEmail = findViewById(R.id.editTextEmail)
        buttonSave = findViewById(R.id.buttonSave)

        val sharedPreferences = getSharedPreferences(sharedPrefName, MODE_PRIVATE)

        val name = sharedPreferences.getString(keyName, null)
        val email = sharedPreferences.getString(keyEmail, null)

        if (name != null || email != null) {
            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
        }


        buttonSave.setOnClickListener(View.OnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString(keyName, editTextName.getText().toString())
            editor.putString(keyEmail, editTextEmail.getText().toString())
            editor.putBoolean("flag", true)
            editor.apply()
            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
            Toast.makeText(this@LoginActivity, "Login Success", Toast.LENGTH_SHORT).show()
        })
    }
}
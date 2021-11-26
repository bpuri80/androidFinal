package com.example.finalexam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var et_userName: EditText
    lateinit var button_save: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_userName = findViewById(R.id.et_userName)
        button_save = findViewById(R.id.button_save)

        button_save.setOnClickListener {
            PreferenceHelper.writeStringPref("player_name",et_userName.text.toString().trim())
            //Toast.makeText(this, et_userName.text.toString(), Toast.LENGTH_SHORT).show()
            val intent = Intent(this,GameActivity::class.java)
            startActivity(intent)
        }
    }
}

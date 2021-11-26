package com.example.finalexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {

    lateinit var tv_highScore: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        tv_highScore = findViewById(R.id.tv_highScore)

        tv_highScore.text = "Highest Score: "+PreferenceHelper.readIntPref("highest_score").toString()
    }
}

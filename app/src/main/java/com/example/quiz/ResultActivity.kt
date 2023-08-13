package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val username = intent.getStringExtra("user_name")
        val result = intent.getIntExtra("crt_opt",0)


    val player:TextView = findViewById(R.id.winner)
    val score:TextView = findViewById(R.id.score)

        score.text = "your score = ${result} / 10"
        player.text = username
    }
}
package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         val btnStart: Button = findViewById(R.id.start)
         val iptext: EditText = findViewById(R.id.name)
        btnStart.setOnClickListener{
            if (iptext.text.isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this,QuizQuestionActivity::class.java)
                intent.putExtra("user_name",iptext.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}
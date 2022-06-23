package com.example.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            if(input.text.toString().isEmpty()){
                Toast.makeText(this,"Enter your Name",Toast.LENGTH_SHORT).show()
            }else{

                var intent = Intent(this,Question::class.java)
                intent.putExtra("${SetData.name}",input.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}
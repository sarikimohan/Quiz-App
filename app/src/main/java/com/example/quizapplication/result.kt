package com.example.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        val name=intent.getStringExtra("${SetData.name}")
        val score=intent.getStringExtra("${SetData.score}")
        val total_questions=intent.getStringExtra("totalquestions")

        username.text="Congrats ${name}"
        finalscore.text="${score}"+"/"+"${total_questions}"
        gotohome.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}
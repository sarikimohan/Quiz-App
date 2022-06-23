package com.example.quizapplication

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*
import kotlinx.android.synthetic.main.activity_question.view.*

class Question : AppCompatActivity() {

    private var Name: String? = null
    private var score:Int =0

    private var currentQuestion: Int = 1
    private var questionList: ArrayList<QuestionData>? = null
    private var selectedOption: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

//        Name = intent.getStringExtra("${SetData.name}").toString()

        questionList = SetData.getQuestion()

        setquestion()

        option_1.setOnClickListener {
            selectedoption(option_1, 1)
        }
        option_2.setOnClickListener {
            selectedoption(option_2, 2)
        }
        option_3.setOnClickListener {
            selectedoption(option_3, 3)
        }
        option_4.setOnClickListener {
            selectedoption(option_4, 4)
        }

        submit.setOnClickListener {

            if (selectedOption != 0) {
                val question = questionList!![currentQuestion - 1]
                if (question.correctAnswer != selectedOption) {
                    setcolor(selectedOption, R.drawable.wrong_question_option)
                }else{
                    score++
                }
                setcolor(question.correctAnswer, R.drawable.correct_question_option)
                if (currentQuestion == questionList!!.size) {
                    submit.text = "FINISH"
                } else {
                    submit.text = "Go to next"
                }
            } else {
                currentQuestion++
                when {
                    currentQuestion <= questionList!!.size -> {
                        setquestion()
                    }
                    else -> {
                        var intent = Intent(this, result::class.java)
                        intent.putExtra("${SetData.name}", Name.toString())
                        intent.putExtra("${SetData.score}", score.toString())
                        intent.putExtra("totalquestions", questionList!!.size.toString())
                        startActivity(intent)
                        finish()

                    }

                }
            }
            selectedOption = 0
      }
    }






    fun setcolor(opt:Int,color:Int){
        when(opt){
            1->option_1.background=ContextCompat.getDrawable(this,color)
            2->option_2.background=ContextCompat.getDrawable(this,color)
            3->option_3.background=ContextCompat.getDrawable(this,color)
            4->option_4.background=ContextCompat.getDrawable(this,color)
        }
    }


    fun setquestion() {
        val question=questionList!![currentQuestion-1]

        setoptionstyle()
        submit.text="submit"


        progress_bar.progress=currentQuestion
        progress_bar.max=questionList!!.size
        progress_text.text="${currentQuestion}"+"/"+"${questionList!!.size}"

        question_text.text=question.question
        option_1.text=question.Option_one
        option_2.text=question.Option_two
        option_3.text=question.Option_three
        option_4.text=question.Option_four
    }

    fun setoptionstyle(){

        var optionlist: ArrayList<TextView> = arrayListOf()
        optionlist.add(0,option_1)
        optionlist.add(1,option_2)
        optionlist.add(2,option_3)
        optionlist.add(3,option_4)

        for(op in optionlist){

            op.setTextColor(Color.parseColor("#555151"))
            op.background=ContextCompat.getDrawable(this,R.drawable.question)
            op.typeface= Typeface.DEFAULT
        }
    }

    fun selectedoption(view: TextView,opt:Int){
        setoptionstyle()
        selectedOption=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.selected_question_option)
        view.typeface= Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))

    }

}
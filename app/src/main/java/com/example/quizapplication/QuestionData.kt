package com.example.quizapplication

data class QuestionData(
    var id:Int,
    var question:String,
    var Option_one:String,
    var Option_two:String,
    var Option_three:String,
    var Option_four:String,
    var correctAnswer:Int
)

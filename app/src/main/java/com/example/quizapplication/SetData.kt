package com.example.quizapplication

object SetData {

    const val name:String="name"
    const val score:String="0"
    fun getQuestion(): ArrayList<QuestionData> {
        var Que: ArrayList<QuestionData> = arrayListOf()

        var question1 = QuestionData(
            id = 1,
            question = "what is the capital of india ?",
            Option_one = "UP",
            Option_two = "Kanpur",
            Option_three = "MP",
            Option_four = "New Delhi",
            correctAnswer = 4
        )

        var question2 = QuestionData(
            id = 2,
            question = "Who was the first Indian Woman in space ?",
            Option_one = " Kalpana Chawla",
            Option_two = "Sunita Williams",
            Option_three = "Konery Humpy",
            Option_four = "None of the above",
            correctAnswer = 1
        )

        var question3 = QuestionData(
            id = 3,
            question = "Who wrote the Indian National Anthem?",
            Option_one = "Rabindranath Tagore",
            Option_two = "Swami Vivekanand",
            Option_three = "Bakim Chandra Chatterji",
            Option_four = "None of the above",
            correctAnswer = 1
        )

        var question4 = QuestionData(
            id = 4,
            question = "Who was the first President of India ?",
            Option_one = "Abdul Kalam",
            Option_two = "Lal Bahadur Shastri",
            Option_three = "Dr. Rajendra Prasad",
            Option_four = "Zakir Hussian",
            correctAnswer = 3
        )

        var question5 = QuestionData(
            id = 5,
            question = "Who build the Jama Masjid",
            Option_one = "Jahangir",
            Option_two = "Akar",
            Option_three = "Imran Bukhari",
            Option_four = "Shah Jahan",
            correctAnswer = 4
        )

        Que.add(question1)
        Que.add(question2)
        Que.add(question3)
        Que.add(question4)
        Que.add(question5)

        return Que
    }
}
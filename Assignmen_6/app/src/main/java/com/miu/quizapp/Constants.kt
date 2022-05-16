package com.miu.quizapp

class Constants {
    object Constants {
        fun getQuestions(): ArrayList<Questions> {
            val questionsList = ArrayList<Questions>()

            val question1 = Questions(
                1,
                "Which internet company began life as an online bookstore called 'Cadabra' ?",
                "ebay",
                "Shopify",
                "Amazon",
                "Overstock",
                3
            )
            questionsList.add(question1)

            val question2 = Questions(
                1,
                "Which of the following languages is used as a scripting language in the Unity 3D game engine?",
                "Java",
                "C#",
                "C++",
                "Objective-C",
                2
            )
            questionsList.add(question2)

            return questionsList
        }
}
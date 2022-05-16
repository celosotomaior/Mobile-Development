package com.miu.quizzApp.db

import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity Class
@Entity(tableName = "mcq_table")
data class QuestionsModel(
    val question: String,
    val questionChoices:String,
    val correctAnswer: Int,
    var answer:Int
)
{
    @PrimaryKey(autoGenerate = true) var QId:Int? = null
}
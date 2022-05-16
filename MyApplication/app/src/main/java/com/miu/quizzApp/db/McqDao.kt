package com.miu.quizzApp.db

import androidx.room.*

//Data Access Object
@Dao
interface McqDao {
    @Update
    fun UpdateQuestion(Q:QuestionsModel)

    @Query("Update mcq_table Set answer = -1")
    fun ResetAllQuestionsAnswers()

    @Query("SELECT * FROM mcq_table")
    fun GetAllQuestions(): List<QuestionsModel>

    @Insert
    fun InsertQuestion(vararg question:QuestionsModel)

    @Query("Select Count(*) From mcq_table")
    fun RowsCount():Int

    @Query("Delete From mcq_table")
    fun DeleteAll()
}

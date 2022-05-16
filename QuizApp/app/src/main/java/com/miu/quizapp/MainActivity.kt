package com.miu.quizapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.room.Room
import com.miu.quizapp.database.Question
import com.miu.quizapp.database.DBQuestion
import com.miu.quizapp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var  db:DBQuestion;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(applicationContext, DBQuestion::class.java,"question-db").build();

        GlobalScope.launch {
            db.mcqDao().DeleteAll();
            DataSeed()
        }
    }

    private suspend fun DataSeed(){

      var q1 = Question("1. Kotlin is a statically-typed programming language which runs on the?",
          "(A) JCM|(B) JVM|(C) JPM|(D) JDM",
            2,
            -1);
        var q2 = Question("2. Why you should switch to Kotlin from Java?",
            "(A) Kotlin language is quite simple compared to Java|(B) It reduces may redundancies in code as compared to Java|(C) Kotlin can offer some useful features which are not supported by Java|(D) All of the above",
            2,
            -1);
        var q3 = Question("3.  ____________ feature allows removing the risk of occurrence of NullPointerException in real time.",
            "(A) Null Risk|(B) Null Safety|(C) Null Pointer|(D) All of the above",
            1,
            -1);


        var q4 = Question("4. Kotlin is interoperable with Java because it uses JVM bytecode.",
            "(A) Yes|(B) No|(C) Can be yes or no|(D) Can not say",
            1,
            -1);

        var q5 = Question("5. How can you declare a variable in Kotlin?",
            "(A) value my_var: Char|(B) value Char : my_var|(C) my_var: Char|(D) value my_var: Char",
            0,
            -1);

        var q6 = Question("6. What handles null exceptions in Kotlin ?",
            "(A) Sealed classes|(B) Elvis operator|(C) The Kotlin extension",
            1,
            -1);

        var q7 = Question("7. The correct function to get the length of a string in Kotlin language is ?",
            "(A) str.length|(B) string(length)|(C) lengthof(str)",
            1,
            -1);

        var q8 = Question("8. How many types of constructors available in Kotlin?",
            "(A) 1|(B) 2|(C) 3|(D) 4",
            1,
            -1);

        var q9 = Question("9. How many types of constructors available in Kotlin?",
            "(A) 1.1|(B) 1.5|(C) 2.0",
            1,
            -1);



        var q10 = Question("10. Which are the basic data types in Kotlin ?",
            "(A) Arrays and Booleans|(B) Characters|(C) All of these",
            2,
            -1);

        var q11 = Question("11. In Kotlin, the default visibility modifier is ?",
            "(A) sealed|(B) public|(C) protected",
            1,
            -1);

        var q12 = Question("12. What defines a sealed class in Kotlin ?",
            "(A) Its another name for an abstract class|(B) It represents restricted class hierarchies|(C) It is used in every Kotlin program",
            1,
            -1);

        var q13 = Question("13. Which of the following is Use for reading contents of file to ByteArray?",
            "(A) bufferedReader()|(B) readText()|(C) readBytes()|(D) readLines()",
            2,
            -1);

        var q14 = Question("14. What is the use of data class in Kotlin?",
            "(A) extract the basic data types|(B) delete the basic data types|(C) present the basic data types|(D) holds the basic data types",
            2,
            -1);
        var q15 = Question("15. val short for Value, a constant which cannot be changed once assigned ?",
            "(A) It can be changed but once only|(B) It can be changed|(C) val cannot be changed after its assigned",
            2,
            -1);
        var q16 = Question("16. Is there any Ternary Conditional Operator in Kotlin like in Java?",
            "(A) TRUE|(B) FALSE|(C) Can be true or false|(D) Can not say",
            2,
            -1);

        db.mcqDao().InsertQuestion(q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16);
    }

    fun onStartClick(view: View){
        val i = Intent(applicationContext, QuestionActivity::class.java)
        startActivity(i)
    }

    fun onExitClick(view: View){
       finish()
    }

    override fun onBackPressed() {
        finish()
    }
}



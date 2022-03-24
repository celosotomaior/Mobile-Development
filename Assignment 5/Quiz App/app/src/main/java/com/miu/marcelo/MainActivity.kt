package com.marcelo.quizapp

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var firstAnswer:String
    lateinit var secondAnswer:String
    var result: Double = 0.0

    var day = 0
    var month: Int = 0
    var year: Int = 0
    var hour: Int = 0
    var minute: Int = 0
    var myDay = 0
    var myMonth: Int = 0
    var myYear: Int = 0
    var myHour: Int = 0
    var myMinute: Int = 0
    lateinit var dateTime: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_submit.setOnClickListener {
            Toast.makeText(this, "${result}", Toast.LENGTH_SHORT).show()
            pickDateTime()

        }

        btn_reset.setOnClickListener {
            Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show()
            //radio_group_first_question.clearCheck()
            //radio_group_second_question.clearCheck()
        }

       radio_group_first_question.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkId ->
           var radio: RadioButton = findViewById(checkId)
           Toast.makeText(this, "${radio.text}", Toast.LENGTH_SHORT).show()
           firstAnswer = radio.text.toString()
           if (firstAnswer == "Public") {
               result = result + 50
           }
       })

       radio_group_second_question.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkId ->
           var radio: RadioButton = findViewById(checkId)
           Toast.makeText(this, "${radio.text}", Toast.LENGTH_SHORT).show()
           secondAnswer = radio.text.toString()
           if (secondAnswer == "3. Both of 1 and 2") {
               result = result + 50
           }
       })

    }

    private fun pickDateTime() {
        val dateTime = Calendar.getInstance()
        val startYear = dateTime.get(Calendar.YEAR)
        val startMonth = dateTime.get(Calendar.MONTH)
        val startDay = dateTime.get(Calendar.DAY_OF_MONTH)
        val startHour = dateTime.get(Calendar.HOUR_OF_DAY)
        val startMinute = dateTime.get(Calendar.MINUTE)

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, year, month, day ->
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                val pickedDateTime = Calendar.getInstance()
                pickedDateTime.set(year, month, day, hour, minute)
                this.dateTime = "${month}/${day}/${year}, ${hour}:${minute}"
                tv_result.text = dateTime.toString()
                showCorrect(null)
                //doSomethingWith(pickedDateTime)
            }, startHour, startMinute, false).show()
        }, startYear, startMonth, startDay).show()
    }

    fun showCorrect(view: View?){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Result")
        builder.setMessage("Nice job ${dateTime}, You scored ${result.toInt()}%")
        builder.show()
    }
}
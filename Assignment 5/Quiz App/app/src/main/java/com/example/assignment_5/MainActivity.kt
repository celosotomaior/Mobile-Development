package com.example.assignment_5

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun reset(view: View) {
        radioGroup.clearCheck()
        checkBox1.isChecked = false
        checkBox2.isChecked = false
        checkBox3.isChecked = false
        Toast.makeText(this, "Fields cleared, You can start the quiz", Toast.LENGTH_SHORT)
            .show()
    }

    fun submit(view: View) {
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Quiz Result")
        var max = 0
        if (checkBox1.isChecked && checkBox2.isChecked && !checkBox3.isChecked) {
            max += 50
        }
        try {
            val clicked =
                radioGroup.findViewById(radioGroup.checkedRadioButtonId) as RadioButton
            if (clicked.text.equals("Both")) {
                max += 50
            }
        } catch (e: Exception) {
        }
        val year: Int = Calendar.getInstance().get(Calendar.YEAR)
        val month: Int = Calendar.getInstance().get(Calendar.MONTH)
        val day: Int = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        val hour: Int = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val min: Int = Calendar.getInstance().get(Calendar.MINUTE)
        val sec: Int = Calendar.getInstance().get(Calendar.SECOND)
        val msec: Int = Calendar.getInstance().get(Calendar.MILLISECOND)

        var currentDate: String = "$month/$day/$year $hour:$min:$sec"
        builder.setMessage("Congratulations! You submitted on $currentDate and time, Your achieved $max%")
        builder.setIcon(R.drawable.information_icon)
        builder.setPositiveButton("Close") { dialogInterface, which ->
            dialogInterface.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}

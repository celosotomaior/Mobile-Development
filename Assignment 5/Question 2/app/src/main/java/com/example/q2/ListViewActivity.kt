package com.example.q2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.w1l6hw6.R

import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    var clothes = arrayListOf("T-Shirt", "Jeans", "Shirt", "Coat")
    var beauty = arrayListOf("Cream", "Nail Scissor", "Lip balm", "Lotion")
    var shoes = arrayListOf("Soccer Shoes", "Sport Shoes", "Running shoes")
    var electronics = arrayListOf("Watch", "Laptop", "TV", "Printer")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        lateinit var list: ArrayList<String>
        val intent = intent
        val type = intent.getStringExtra("type")
        if (type == "clothes") {
            list = clothes
        } else if (type == "beauty") {
            list = beauty
        } else if (type == "shoes") {
            list = shoes
        } else if (type == "electronics") {
            list = electronics
        } else {

        }
        val adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list)
        lview.adapter = adapter
        lview.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val item = parent.getItemAtPosition(position).toString()
                Toast.makeText(this, "You have chosen ${list[position]}", Toast.LENGTH_SHORT)
                    .show()
                //  val intent = Intent(applicationContext, PlanetActivity::class.java)
                //  intent.putExtra("image", imageges[position])
                //  startActivity(intent)
            }
    }
}

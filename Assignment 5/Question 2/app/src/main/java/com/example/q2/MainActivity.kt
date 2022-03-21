package com.example.q2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.q2.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onBeautyClicked(view: View) {
        Toast.makeText(this, "You have chosen the Beauty category of shopping", Toast.LENGTH_SHORT)
            .show()
        val intent = Intent(applicationContext, ListViewActivity::class.java)
        intent.putExtra("type", "beauty")
        startActivity(intent)
    }

    fun onClothesClicked(view: View) {
        Toast.makeText(this, "You have chosen the Clothes category of shopping", Toast.LENGTH_SHORT)
            .show()
        val intent = Intent(applicationContext, ListViewActivity::class.java)
        intent.putExtra("type", "clothes")
        startActivity(intent)
    }

    fun onElectronicClicked(view: View) {
        Toast.makeText(
            this,
            "You have chosen the Electronics category of shopping",
            Toast.LENGTH_SHORT
        ).show()
        val intent = Intent(applicationContext, ListViewActivity::class.java)
        intent.putExtra("type", "electronics")
        startActivity(intent)
    }

    fun onShoesClicked(view: View) {
        Toast.makeText(this, "You have chosen the Shoes category of shopping", Toast.LENGTH_SHORT)
            .show()
        val intent = Intent(applicationContext, ListViewActivity::class.java)
        intent.putExtra("type", "shoes")
        startActivity(intent)
    }
}

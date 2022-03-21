package com.example.electronicsrv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.*
import kotlinx.android.synthetic.main.detail_layout.*
import java.lang.Exception

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_layout)
        // To avoid application crash check intent has data or not
        if (intent.hasExtra("image") && intent.hasExtra("name") && intent.hasExtra("detail")) {
            var ig = intent.getIntExtra("image", 0)
            var t1 = intent.getStringExtra("name")
            var t2 = intent.getStringExtra("color")
            var t3 = intent.getStringExtra("itemId")
            var t4 = intent.getStringExtra("detail")
            name.text = t1?.toString()
            color.text = t2?.toString()
            itemId.text = t3?.toString()
            desc.text = t4?.toString()
            imageView.setImageResource(ig)
        }
    }
}

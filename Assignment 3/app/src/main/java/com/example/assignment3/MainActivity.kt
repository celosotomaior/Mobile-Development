package com.example.assignment3

import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TableRow
import android.widget.TextView
import androidx.core.view.marginBottom
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.drawable.shapes.RectShape
import android.graphics.drawable.ShapeDrawable
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Space
import com.example.assignment3.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addHeader()
        addFirstRow()
        addSecondRow()
    }

    fun addNewRow(view: View) {

        // Create a new table row.
        val tableRow = TableRow(getApplicationContext())

        // Set new table row layout parameters.
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)

        tableRow.setBackgroundColor(Color.rgb(190, 20, 78))
        //tableRow.background = getResources().getDrawable(R.drawable.border)
        //tableRow.setPadding(2, 2, 2, 2)
        //layoutParams.setMargins(0,0,0,30)
        //layoutParams.bottomMargin = 100;
        tableRow.setLayoutParams(layoutParams)

        val sd = ShapeDrawable()
        sd.shape = RectShape()
        sd.paint.color = Color.BLACK
        sd.paint.strokeWidth = 10f
        sd.paint.style = Paint.Style.STROKE

        // add values into row by calling addView()
        val androidVersion = TextView(this)
        androidVersion.setText(version.text)
        androidVersion.setBackground(sd)
        androidVersion.setPadding(30, 0, 30, 0)
        version.text.clear()

        val codeName = TextView(this)
        codeName.setBackground(sd)
        codeName.setText(name.text)
        codeName.setPadding(30, 0, 30, 0)
        name.text.clear()

        tableRow.addView(androidVersion)
        tableRow.addView(codeName)

        // Finally add the created row row into layout
        tableId.addView(tableRow) // id from Layout_file
        var space = Space(this)
        space.minimumHeight = 3

        tableId.addView(space)

    }

    fun addHeader() {

        val tableRow = TableRow(getApplicationContext())
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        tableRow.setBackgroundColor(Color.rgb(200, 20, 78))
        tableRow.setLayoutParams(layoutParams)

        val sd = ShapeDrawable()
        sd.shape = RectShape()
        sd.paint.color = Color.BLACK
        sd.paint.strokeWidth = 10f
        sd.paint.style = Paint.Style.STROKE

        val versionTitle = TextView(this)
        versionTitle.setText("Version")
        versionTitle.setBackground(sd)
        versionTitle.setPadding(30, 0, 30, 0)

        val nameTitle = TextView(this)
        nameTitle.setBackground(sd)
        nameTitle.setText("Code Name")
        nameTitle.setPadding(30, 0, 30, 0)

        tableRow.addView(versionTitle)
        tableRow.addView(nameTitle)

        var space1 = Space(this)
        space1.minimumHeight = 20
        tableId.addView(space1)

        // Finally add the created row row into layout
        tableId.addView(tableRow) // id from Layout_file
        var space = Space(this)
        space.minimumHeight = 3

        tableId.addView(space)

    }


    fun addFirstRow() {

        val tableRow = TableRow(getApplicationContext())
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        tableRow.setBackgroundColor(Color.rgb(180, 30, 83))
        tableRow.setLayoutParams(layoutParams)

        val sd = ShapeDrawable()
        sd.shape = RectShape()
        sd.paint.color = Color.BLACK
        sd.paint.strokeWidth = 11f
        sd.paint.style = Paint.Style.STROKE

        val versionText = TextView(this)
        versionText.setText("Android 11.0")
        versionText.setBackground(sd)
        versionText.setPadding(30, 0, 30, 0)

        val nameText = TextView(this)
        nameText.setBackground(sd)
        nameText.setText("Android 11")
        nameText.setPadding(30, 0, 30, 0)

        tableRow.addView(versionText)
        tableRow.addView(nameText)

        tableId.addView(tableRow)
        var space = Space(this)
        space.minimumHeight = 3
        tableId.addView(space)
    }

    fun addSecondRow() {

        val tableRow = TableRow(getApplicationContext())
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        tableRow.setBackgroundColor(Color.rgb(190, 20, 78))
        tableRow.setLayoutParams(layoutParams)

        val sd = ShapeDrawable()
        sd.shape = RectShape()
        sd.paint.color = Color.BLACK
        sd.paint.strokeWidth = 10f
        sd.paint.style = Paint.Style.STROKE

        val versionText = TextView(this)
        versionText.setText("Android 10.0")
        versionText.setBackground(sd)
        versionText.setPadding(30, 0, 30, 0)

        val nameText = TextView(this)
        nameText.setBackground(sd)
        nameText.setText("Android 10")
        nameText.setPadding(30, 0, 30, 0)

        tableRow.addView(versionText)
        tableRow.addView(nameText)

        tableId.addView(tableRow)
        var space = Space(this)
        space.minimumHeight = 3
        tableId.addView(space)
    }

}

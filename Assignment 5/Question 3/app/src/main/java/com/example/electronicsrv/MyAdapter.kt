package com.example.electronicsrv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.widget.Toast


class MyAdapter(
    var context: Context,
    var text1: ArrayList<String>,
    var text2: ArrayList<Double>,
    var img: ArrayList<String>,
    var text3: ArrayList<String>,
    var text4: ArrayList<String>,
    var text5: ArrayList<String>
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var images = ArrayList<Int>()
        for (element in img) {
            if (element.equals("camera.jpg")) {
                images.add(R.drawable.camera)
            }
            if (element.equals("headphone.jpg")) {
                images.add(R.drawable.headphone)
            }
            if (element.equals("laptop.jpg")) {
                images.add(R.drawable.laptop)
            }
            if (element.equals("tablet.jpg")) {
                images.add(R.drawable.tablet)
            }
            if (element.equals("tv.jpg")) {
                images.add(R.drawable.tv)
            }
        }
        holder.im.setImageResource(images[position])
        holder.t1.text = text1[position]
        holder.t2.text = text2[position].toString()
        holder.t3.text = text3[position]

        holder.parentlayout.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            var res = text1[position]
            Toast.makeText(context, " $res clicked", Toast.LENGTH_LONG).show()
            intent.putExtra("image", images[position])
            intent.putExtra("name", text1[position])
            intent.putExtra("price", text2[position])
            intent.putExtra("color", text3[position])
            intent.putExtra("detail", text4[position])
            intent.putExtra("itemId", text5[position])
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(v);
    }

    override fun getItemCount(): Int {
        return text1.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var t1: TextView = itemView.findViewById<TextView>(R.id.tv1)
        var t2: TextView = itemView.findViewById<TextView>(R.id.tv2)
        var t3: TextView = itemView.findViewById<TextView>(R.id.tv3)
        var im: ImageView = itemView.findViewById<ImageView>(R.id.imageView)
        var parentlayout: RelativeLayout = itemView.findViewById(R.id.playout) as RelativeLayout
    }

}
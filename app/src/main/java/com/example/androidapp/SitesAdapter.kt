package com.example.androidapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class SitesAdapter(
    private var context: Context,
    private var titleList: ArrayList<String>,
    private var imageList: ArrayList<Int>,
    private var textList: ArrayList<String>,
    private var textPunct: ArrayList<String>
):
    RecyclerView.Adapter<SitesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SitesAdapter.ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.activity_item_ok, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.cityName.text = titleList[position]
        viewHolder.imageURL.setImageResource(imageList[position])
        viewHolder.shortInfo.text = textList[position]
        viewHolder.punctuation.text = textPunct[position]

        viewHolder.itemView.setOnClickListener {
            Toast.makeText(context, titleList[position], Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = titleList.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val cityName: TextView = itemView.findViewById(R.id.titleList)
        val imageURL: ImageView = itemView.findViewById(R.id.imageURL)
        val shortInfo: TextView = itemView.findViewById(R.id.textList)
        val punctuation: TextView = itemView.findViewById(R.id.textPunct)

    }

}

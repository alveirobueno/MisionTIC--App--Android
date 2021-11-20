package com.example.androidapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import java.io.InputStream

import org.json.JSONObject


class SitesAdapter : RecyclerView.Adapter<SitesAdapter.ViewHolder>() {

    private var cityText = arrayOf(
        "Ciudad 1",
        "Cuudad 2",
        "Ciudad 3",
        "Ciudad 4",
        "Ciudad 5")

    private var imageFiles = intArrayOf(
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground)

    private var shortInfoText = arrayOf(
        "Info 1",
        "Info 2",
        "Info 3",
        "Info 4",
        "Info 5")

    private var punctuationText = arrayOf(
        "Puntuación 1",
        "Puntuación 2",
        "Puntuación 3",
        "Puntuación 4",
        "Puntuación 5")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SitesAdapter.ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.activity_item_ok, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.cityName.text = cityText[position]
        viewHolder.image.setImageResource(imageFiles[position])
        viewHolder.shortInfo.text = shortInfoText[position]
        viewHolder.punctuation.text = punctuationText[position]
    }

    override fun getItemCount(): Int = cityText.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val cityName = itemView.findViewById<TextView>(R.id.titleList)
        val image = itemView.findViewById<ImageView>(R.id.imageList)
        val shortInfo = itemView.findViewById<TextView>(R.id.textList)
        val punctuation = itemView.findViewById<TextView>(R.id.textPunct)

    }

}
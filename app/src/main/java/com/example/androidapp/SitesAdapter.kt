package com.example.androidapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class SitesAdapter(
    private var context: Context,
    private var titleList: ArrayList<String>,
    private var imageList: ArrayList<String>,
    private var textList: ArrayList<String>,
    private var textPunct: ArrayList<String>

):
    RecyclerView.Adapter<SitesAdapter.ViewHolder>() {

    private lateinit var mListener : OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick (position : Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SitesAdapter.ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.activity_item_ok, parent, false)
        return ViewHolder(view, mListener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.cityName.text = titleList[position]
        viewHolder.shortInfo.text = textList[position]
        viewHolder.punctuation.text = textPunct[position]
        Picasso.get().load(imageList[position]).resize(208, 208).into(viewHolder.imageURL)

    }

    override fun getItemCount(): Int = titleList.size

    inner class ViewHolder(itemView: View, listener: OnItemClickListener): RecyclerView.ViewHolder(itemView){

        val cityName: TextView = itemView.findViewById(R.id.titleList)
        val imageURL: ImageView = itemView.findViewById(R.id.imageURL)
        val shortInfo: TextView = itemView.findViewById(R.id.textList)
        val punctuation: TextView = itemView.findViewById(R.id.textPunct)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }

    }

}

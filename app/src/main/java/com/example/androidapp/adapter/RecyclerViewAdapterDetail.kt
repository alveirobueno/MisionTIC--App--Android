package com.example.androidapp.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapp.DetailActivity
import com.example.androidapp.R
import com.example.androidapp.model.SiteModel
import com.squareup.picasso.Picasso

class RecyclerViewAdapterDetail : RecyclerView.Adapter<RecyclerViewAdapterDetail.MyViewHolder>() {

    private lateinit var sites : ArrayList<SiteModel>

    @SuppressLint("NotifyDataSetChanged")
    fun setUpdatedData(sites: ArrayList<SiteModel>) {
        this.sites = sites
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.activity_detail, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(sites[position])
    }

    override fun getItemCount(): Int = sites.size

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val titleDetail : TextView = view.findViewById(R.id.cityName)
        private val image1Detail : ImageView = view.findViewById(R.id.image1)
        private val paragraph1Detail : TextView = view.findViewById(R.id.paragraph1)
        private val paragraph2Detail : TextView = view.findViewById(R.id.paragraph2)
        private val paragraph3Detail : TextView = view.findViewById(R.id.paragraph3)
        private val paragraph4Detail : TextView = view.findViewById(R.id.paragraph4)

        fun bind(data: SiteModel){

            titleDetail.text = data.cityName
            Picasso.get().load(data.imageURL).resize(1000,600).into(image1Detail)
            paragraph1Detail.text = data.largeInfo
            paragraph2Detail.text = data.ubiGeo
            paragraph3Detail.text = data.tempClima
            paragraph4Detail.text = data.sitesRec
        }

    }

}
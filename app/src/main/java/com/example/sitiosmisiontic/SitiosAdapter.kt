package com.mintic.travelappfinal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sitiosmisiontic.R

class SitiosAdapter (

    private val mSitios: List<Sitios>,
    private val context: Context,
    private val onClick: (Sitios) -> Unit
    ) : RecyclerView.Adapter<SitiosAdapter.SitiosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SitiosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sitios_display_layout, parent, false)
        return SitiosViewHolder(view)
    }

    override fun onBindViewHolder(holderCity: SitiosViewHolder, position: Int) {
        val sitios = mSitios[position]
        holderCity.bind(sitios = sitios)
    }


    //Retorna la cantidad de elementos mi lista
    override fun getItemCount(): Int {
        return mSitios.size
    }

    inner class SitiosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var nameLabel: TextView = itemView.findViewById(R.id.titleList)
        private var imageView: ImageView = itemView.findViewById(R.id.imageURL)
        private var descriptionShort: TextView = itemView.findViewById(R.id.textList)
        private var puntuacionShort: TextView = itemView.findViewById(R.id.textPunct)
        private var currentSitios: Sitios? = null

        init {
            itemView.setOnClickListener {
                currentSitios?.let {
                    onClick(it)
                }
            }
        }

        /* Bind Contact name and image. */
        fun bind(sitios: Sitios) {

            currentSitios = sitios
            nameLabel.text = sitios.cityName
            descriptionShort.text = sitios.shortInfo
            puntuacionShort.text = sitios.punctuation


            Glide.with(context)
                .load(sitios.imageURL)
                .into(imageView)
        }
    }

}
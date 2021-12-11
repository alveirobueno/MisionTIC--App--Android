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

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

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
            .inflate(R.layout.activity_item_list, parent, false)
//        return MyViewHolder(view, mListener)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(sites[position])
    }

    override fun getItemCount(): Int = sites.size

//    class MyViewHolder(view: View, listener: OnItemClickListener): RecyclerView.ViewHolder(view) {
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val imageThumb: ImageView = view.findViewById(R.id.imageURL)
        private val cityName: TextView = view.findViewById(R.id.titleList)
        private val shortInfo: TextView = view.findViewById(R.id.textList)
        private val punctuation: TextView = view.findViewById(R.id.textPunct)

        fun bind(data: SiteModel){
            cityName.text = data.cityName
            shortInfo.text = data.shortInfo
            punctuation.text = data.punctuation
            Picasso.get().load(data.imageURL).resize(208, 208).into(imageThumb)
        }

//        init {
//            view.setOnClickListener{
//                listener.onItemClick(adapterPosition)
//            }
//        }

    }

//    private lateinit var mListener : OnItemClickListener
//
//    interface OnItemClickListener{
//        fun onItemClick (position : Int)
//    }

/*    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }*/

/*    val recycler = findViewById<RecyclerView>(R.id.recyclerView)
    val adapter = RecyclerViewAdapter(this@MainActivity, titleList, imageList, textList, textPunct)

    recycler.layoutManager = LinearLayoutManager(this)
    recycler.adapter = adapter

    var adapter.setOnItemClickListener(object : RecyclerViewAdapter.OnItemClickListener{
        override fun onItemClick(position: Int) {

            val intent = Intent(this@MainActivity, DetailActivity::class.java)

            intent.putExtra("cityNameData", titleList[position])
            intent.putExtra("imageURLData", imageList[position])
            intent.putExtra("largeInfoData", largeInfoList[position])
            intent.putExtra("ubiGeoData", ubiGeoList[position])
            intent.putExtra("tempClimaData", tempClimaList[position])
            intent.putExtra("sitesRecData", sitesRecList[position])

            startActivity(intent)

        }
    })*/






}
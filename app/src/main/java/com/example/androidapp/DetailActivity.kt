package com.example.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_window1)

        val titleDetail : TextView = findViewById(R.id.cityName)
        val image1Detail : ImageView = findViewById(R.id.image1)
        val paragraph1Detail : TextView = findViewById(R.id.paragraph1)
        val paragraph2Detail : TextView = findViewById(R.id.paragraph2)
        val paragraph3Detail : TextView = findViewById(R.id.paragraph3)
        val paragraph4Detail : TextView = findViewById(R.id.paragraph4)

        val bundle : Bundle? = intent.extras
        val cityNameData = bundle!!.getString("cityNameData")
        val imageURLData = bundle.getString("imageURLData")
        val largeInfoData = bundle.getString("largeInfoData")
        val ubiGeoData = bundle.getString("ubiGeoData")
        val tempClimaData = bundle.getString("tempClimaData")
        val sitesRecData = bundle.getString("sitesRecData")

        titleDetail.text = cityNameData
        Picasso.get().load(imageURLData).resize(1000,600).into(image1Detail)
        paragraph1Detail.text = largeInfoData
        paragraph2Detail.text = ubiGeoData
        paragraph3Detail.text = tempClimaData
        paragraph4Detail.text = sitesRecData
    }
}
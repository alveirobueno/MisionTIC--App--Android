package com.example.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.androidapp.model.SiteData
import com.example.androidapp.model.SiteModel
import com.example.sitiosmisiontic.R
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private var cities = ArrayList<SiteData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val titleDetail : TextView = findViewById(R.id.cityNameTv)
        val image1Detail : ImageView = findViewById(R.id.image1)
        val paragraph1Detail : TextView = findViewById(R.id.paragraph1)
        val paragraph2Detail : TextView = findViewById(R.id.paragraph2)
        val paragraph3Detail : TextView = findViewById(R.id.paragraph3)
        val paragraph4Detail : TextView = findViewById(R.id.paragraph4)

        val bundle : Bundle? = intent.extras

        val cityName = bundle?.getString("cityName")
        val imageURL = bundle?.getString("imageURL")
        val largeInfo = bundle?.getString("largeInfo")
        val ubiGeo = bundle?.getString("ubiGeo")
        val tempClima = bundle?.getString("tempClima")
        val sitesRec = bundle?.getString("sitesRec")

        titleDetail.text = cityName
        Picasso.get().load(imageURL).resize(1000,600).into(image1Detail)
        paragraph1Detail.text = largeInfo
        paragraph2Detail.text = ubiGeo
        paragraph3Detail.text = tempClima
        paragraph4Detail.text = sitesRec
    }
}
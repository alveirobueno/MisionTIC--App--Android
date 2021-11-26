package com.example.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject
import org.json.JSONException
import java.io.IOException
import java.nio.charset.Charset
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    var titleList: ArrayList<String> = ArrayList()
    var imageList: ArrayList<String> = ArrayList()
    var textList: ArrayList<String> = ArrayList()
    var textPunct: ArrayList<String> = ArrayList()
//    var largeInfoList: ArrayList<String> = ArrayList()
//    var ubiGeoList: ArrayList<String> = ArrayList()
//    var tempClimaList: ArrayList<String> = ArrayList()
//    var sitesRecList: ArrayList<String> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val adapter = SitesAdapter(this@MainActivity, titleList, imageList, textList, textPunct)
        /*largeInfoList, ubiGeoList, tempClimaList, sitesRecList*/


        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        adapter.setOnItemClickListener(object : SitesAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {

                Toast.makeText(this@MainActivity, "You clicked on item no. $position", Toast.LENGTH_SHORT).show()
            }
        })

        try {
            val obj = JSONObject(this.loadJSONFromAsset())
            val userArray = obj.getJSONArray("cities")
            for (i in 0 until userArray.length()) {
                val userDetail = userArray.getJSONObject(i)
                titleList.add(userDetail.getString("cityName"))
                imageList.add(userDetail.getString("imageURL"))
                textList.add(userDetail.getString("shortInfo"))
                textPunct.add(userDetail.getString("punctuation"))
//                largeInfoList.add(userDetail.getString("largeInfo"))
//                ubiGeoList.add(userDetail.getString("ubiGeo"))
//                tempClimaList.add(userDetail.getString("tempClima"))
//                sitesRecList.add(userDetail.getString("sitesRec"))
            }
        }
        catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun loadJSONFromAsset(): String {
        val json: String?
        try {
            val inputStream = assets.open("sites.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        }
        catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }

}
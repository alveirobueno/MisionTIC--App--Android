package com.example.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject
import org.json.JSONException
import java.io.IOException
import java.nio.charset.Charset
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    var titleList: ArrayList<String> = ArrayList()
    var imageList: ArrayList<Int> = ArrayList()
    var textList: ArrayList<String> = ArrayList()
    var textPunct: ArrayList<String> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val adapter = SitesAdapter(this@MainActivity, titleList, imageList, textList, textPunct)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        try {
            val obj = JSONObject(this.loadJSONFromAsset())
            val userArray = obj.getJSONArray("cities")
            for (i in 0 until userArray.length()) {
                val userDetail = userArray.getJSONObject(i)
                titleList.add(userDetail.getString("cityName"))
                imageList.add(userDetail.getInt("imageURL"))
                textList.add(userDetail.getString("shortInfo"))
                textPunct.add(userDetail.getString("punctuation"))
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
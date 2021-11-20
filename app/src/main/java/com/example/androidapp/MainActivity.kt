package com.example.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject
import org.json.JSONArray
import java.io.InputStream
import java.util.ArrayList


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val adapter = SitesAdapter()
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

//        JSONObject obj = new JSONObject(JsonDataFromAsset("sites.json"));


    }
    val cities = ""

//    private fun loadJSONfromAssets(): String {
//        String json = null
//    }
}
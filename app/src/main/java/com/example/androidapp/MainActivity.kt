package com.example.androidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapp.adapter.RecyclerViewAdapter
import org.json.JSONObject
import org.json.JSONException
import java.io.IOException
import java.nio.charset.Charset
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        setupFragment()

/*        val recycler = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = RecyclerViewAdapter(this@MainActivity, titleList, imageList, textList, textPunct)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        adapter.setOnItemClickListener(object : RecyclerViewAdapter.OnItemClickListener{
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
        })


    }*/



/*    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.settings_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }*/

/*    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.action_settings  -> {
                val intent = Intent(this,
                    SettingsActivity::class.java)

                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }*/


}
    fun setupFragment() {
        val fragment = RecyclerListFragment.newInstance()
        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(android.R.id.content, fragment)
        fragmentTransaction.commit()
    }


}

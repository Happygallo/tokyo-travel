package com.example.tokyotravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tokyotravel.databinding.ActivityListBinding
import com.squareup.picasso.Picasso
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import java.util.ArrayList

class activity_list : AppCompatActivity() {

    private lateinit var rvAdapter: POIAdapter
    private lateinit var binding: ActivityListBinding
    private lateinit var pointsOfInterests: ArrayList<POI>

    /*
    var pointsOfInterests: List<POI> = listOf(
        POI("Place 1", "ghg gjg hjgghj ghjghhj", "4/10", "https://www.jrailpass.com/blog/wp-content/uploads/2018/09/best-manga-anime-locations-japan.jpg"),
        POI("Akihabara", "Akihabara, conocido como el barrio electrónico y uno de los lugares que visitar en Tokio más imprescindibles, reúne cada día a miles de seguidores del manga, anime, videojuegos y ordenadores, hasta todo tipo de accesorios sofisticados, que te dejarán sin palabras.", "10/10", "https://cdn.cheapoguides.com/wp-content/uploads/sites/2/2020/05/akihabara-iStock-484915982-1024x683.jpg"),
        POI("Place 3", "ghg gjg hjgghj ghjghhj", "6/10", "https://mochilerosentailandia.com/wp-content/uploads/2018/07/japon-primavera.jpg"),
        POI("Place 4", "ghg gjg hjgghj ghjghhj", "5/10", "https://mochilerosentailandia.com/wp-content/uploads/2018/07/japon-primavera.jpg")
    )
    */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
        createPOI()
        bton()

    }

    fun bton(){
        val btnToOne: Button = findViewById(R.id.buttonToOne)

        btnToOne.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }


    fun initRecycler() {
        pointsOfInterests = arrayListOf()
        binding.rvPOI.layoutManager = LinearLayoutManager(this)
        rvAdapter = POIAdapter(pointsOfInterests)
        binding.rvPOI.adapter = rvAdapter
    }

    private fun loadData(inFile: String): String {
        var content = ""
        try {
            val stream = assets.open(inFile)
            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            content = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return content
    }

    private fun createPOI() {
        val data = loadData("mock_places.json")
        try {
            val placeJSON = JSONArray(data)
            for (i in 0 until placeJSON.length()) {
                val placeJSON = placeJSON.getJSONObject(i)
                val place = POI(
                    placeJSON.getString("place_name"),
                    placeJSON.getString("description"),
                    placeJSON.getString("score"),
                    placeJSON.getString("photo"),
                    placeJSON.getString("temperature"),
                    placeJSON.getString("related")
                )
                pointsOfInterests.add(place)
            }
            rvAdapter.notifyDataSetChanged()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

}
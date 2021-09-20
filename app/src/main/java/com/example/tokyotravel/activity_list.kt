package com.example.tokyotravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tokyotravel.databinding.ActivityListBinding
import com.squareup.picasso.Picasso

class activity_list : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    var pointsOfInterests: List<POI> = listOf(
        POI("Place 1", "ghg gjg hjgghj ghjghhj", "4/10", "https://www.jrailpass.com/blog/wp-content/uploads/2018/09/best-manga-anime-locations-japan.jpg"),
        POI("Akihabara", "Akihabara, conocido como el barrio electrónico y uno de los lugares que visitar en Tokio más imprescindibles, reúne cada día a miles de seguidores del manga, anime, videojuegos y ordenadores, hasta todo tipo de accesorios sofisticados, que te dejarán sin palabras.", "10/10", "https://cdn.cheapoguides.com/wp-content/uploads/sites/2/2020/05/akihabara-iStock-484915982-1024x683.jpg"),
        POI("Place 3", "ghg gjg hjgghj ghjghhj", "6/10", "https://mochilerosentailandia.com/wp-content/uploads/2018/07/japon-primavera.jpg"),
        POI("Place 4", "ghg gjg hjgghj ghjghhj", "5/10", "https://mochilerosentailandia.com/wp-content/uploads/2018/07/japon-primavera.jpg")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
    }

    fun initRecycler() {
        binding.rvPOI.layoutManager = LinearLayoutManager(this)
        val adapter = POIAdapter(pointsOfInterests)
        binding.rvPOI.adapter = adapter
    }
}
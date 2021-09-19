package com.example.tokyotravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tokyotravel.databinding.ActivityListBinding

class activity_list : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    var pointsOfInterests: List<POI> = listOf(
        POI("Place 1", "ghg gjg hjgghj ghjghhj", 4, ""),
        POI("Place 1", "ghg gjg hjgghj ghjghhj", 4, ""),
        POI("Place 1", "ghg gjg hjgghj ghjghhj", 4, ""),
        POI("Place 1", "ghg gjg hjgghj ghjghhj", 4, "")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
        println("HHHHHEEEEYYYYY")
    }

    fun initRecycler() {
        binding.rvPOI.layoutManager = LinearLayoutManager(this)
        val adapter = POIAdapter(pointsOfInterests)
        binding.rvPOI.adapter = adapter
    }
}
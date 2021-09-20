package com.example.tokyotravel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tokyotravel.databinding.ItemPoiBinding
import com.squareup.picasso.Picasso

class POIAdapter(val pointOfInterest: List<POI>): RecyclerView.Adapter<POIAdapter.POIHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): POIHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return POIHolder(layoutInflater.inflate(R.layout.item_poi, parent, false))
    }

    override fun onBindViewHolder(holder: POIHolder, position: Int) {
        holder.render(pointOfInterest[position])
    }

    override fun getItemCount(): Int {
        return pointOfInterest.size
    }

    class POIHolder(val view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemPoiBinding.bind(view)

        fun render(pointOfInterest: POI) {
            binding.tvNombre.text = pointOfInterest.name
            binding.tvDescripcion.text = pointOfInterest.description
            binding.tvPuntaje.text = pointOfInterest.rating
            Picasso.get().load(pointOfInterest.image).into(binding.imageView)
        }
    }
}
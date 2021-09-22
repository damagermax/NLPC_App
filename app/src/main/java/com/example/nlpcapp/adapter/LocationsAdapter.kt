package com.example.nlpcapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nlpcapp.R
import com.example.nlpcapp.model.LocationsModel

class LocationsAdapter : RecyclerView.Adapter<LocationsAdapter.LocationsViewHolder>() {

   private var locationsModel= emptyList<LocationsModel>()

    inner class LocationsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val locationImage: ImageView = view.findViewById(R.id.location_image)
        val locationName: TextView = view.findViewById(R.id.location_name)
        val locationAddress: TextView = view.findViewById(R.id.location_address)
        val locationPoster: TextView = view.findViewById(R.id.location_postor)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationsViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.locations_item,parent,false)
        return LocationsViewHolder(view)
    }

    override fun onBindViewHolder(holder: LocationsViewHolder, position: Int) {
        val currentLocation=locationsModel[position]

        holder.locationAddress.text=currentLocation.address
        holder.locationName.text=currentLocation.name
        holder.locationPoster.text=currentLocation.poster
        holder.locationImage.setImageResource(currentLocation.image)

    }

    override fun getItemCount(): Int {
        return locationsModel.size

    }

    fun setLocationData(newLocationsModel: List<LocationsModel>){
        locationsModel=newLocationsModel
    }
}
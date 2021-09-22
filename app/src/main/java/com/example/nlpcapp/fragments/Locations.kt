package com.example.nlpcapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nlpcapp.R
import com.example.nlpcapp.adapter.LocationsAdapter
import com.example.nlpcapp.model.LocationsModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Locations : Fragment() {


    private lateinit var locationRecyclerView: RecyclerView
    private lateinit var locationsAdapter: LocationsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view=inflater.inflate(R.layout.fragment_locations, container, false)
        locationRecyclerView=view.findViewById(R.id.locationRec)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       val location= arrayListOf<LocationsModel>(
           LocationsModel(5,R.drawable.ic_launcher_background,"Spintebvhjvhvjvvvhgvghvhvhvhvhgvhgvhgvhgvhvhvhhhgvhgvhgvghvvgvhx","GZ-64f-H","Rev. Max"),
           LocationsModel(5,R.drawable.ic_launcher_background,"Spintex","GZ-64f-H","Rev. Max"),
           LocationsModel(5,R.drawable.ic_launcher_background,"Spintex","GZ-64f-H","Rev. Max"),
           LocationsModel(5,R.drawable.ic_launcher_background,"Spintex","GZ-64f-H","Rev. Max"),
           LocationsModel(5,R.drawable.ic_launcher_background,"Spintex","GZ-64f-H","Rev. Max"),
           LocationsModel(5,R.drawable.ic_launcher_background,"Spintex","GZ-64f-H","Rev. Max"),
           LocationsModel(5,R.drawable.ic_launcher_background,"Spintex","GZ-64f-H","Rev. Max"),
           LocationsModel(5,R.drawable.ic_launcher_background,"Spintex","GZ-64f-H","Rev. Max"),
           LocationsModel(5,R.drawable.ic_launcher_background,"Spintex","GZ-64f-H","Rev. Max"),
           LocationsModel(5,R.drawable.ic_launcher_background,"Spintex","GZ-64f-H","Rev. Max"),
           LocationsModel(5,R.drawable.ic_launcher_background,"Spintex","GZ-64f-H","Rev. Max"),
       )
        locationsAdapter=LocationsAdapter()
        locationsAdapter.setLocationData(location)
        locationRecyclerView.setHasFixedSize(true)
        locationRecyclerView.adapter=locationsAdapter
    }


}
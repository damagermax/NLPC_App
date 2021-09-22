package com.example.nlpcapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nlpcapp.R
import com.example.nlpcapp.adapter.AudioAdapter
import com.example.nlpcapp.model.AudioModel


class AudioFragment : Fragment() {


    private lateinit var audioRecyclerView: RecyclerView
    private lateinit var audioAdapter: AudioAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_audio, container, false)
        audioRecyclerView=view.findViewById(R.id.audioRec)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val audio= arrayListOf<AudioModel>(
            AudioModel(5,R.drawable.ic_launcher_background,"What we see in God","January 21,200","English","Sunday service"),
            AudioModel(5,R.drawable.ic_launcher_background,"What we see in God","January 21,200","Ewe $ Twi","Ten times service"),
            AudioModel(5,R.drawable.ic_launcher_background,"What we see in God","January 21,200","English","Sunday service"),
            AudioModel(5,R.drawable.ic_launcher_background,"What we see in God","January 21,200","English","Sunday service"),
            AudioModel(5,R.drawable.ic_launcher_background,"What we see in God","January 21,200","Ewe and Twi","Teaching service"),
            AudioModel(5,R.drawable.ic_launcher_background,"What we see in God","January 21,200","English","Sunday service"),
            AudioModel(5,R.drawable.ic_launcher_background,"What we see in God","January 21,200","Ewe and Twi","Sunday service"),
            AudioModel(5,R.drawable.ic_launcher_background,"What we see in God","January 21,200","English","Sunday service"),
            AudioModel(5,R.drawable.ic_launcher_background,"What we see in God","January 21,200","English","Tarry service"),
            AudioModel(5,R.drawable.ic_launcher_background,"What we see in God","January 21,200","Ewe and Twi","Sunday service"),
            AudioModel(5,R.drawable.ic_launcher_background,"What we see in God","January 21,200","English","Sunday service"),
            AudioModel(5,R.drawable.ic_launcher_background,"What we see in God","January 21,200","English","Tarry service"),
            AudioModel(5,R.drawable.ic_launcher_background,"What we see in God","January 21,200","English","Sunday service"),
        )

        audioAdapter= AudioAdapter()
        audioAdapter.setLocationData(audio)
        audioRecyclerView.setHasFixedSize(true)
        audioRecyclerView.adapter=audioAdapter

    }


}
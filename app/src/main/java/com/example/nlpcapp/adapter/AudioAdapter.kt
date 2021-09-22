package com.example.nlpcapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nlpcapp.R
import com.example.nlpcapp.model.AudioModel


class AudioAdapter : RecyclerView.Adapter<AudioAdapter.AudioViewHolder>() {

   private var audioModel= emptyList<AudioModel>()

    inner class AudioViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val audioImage: ImageView = view.findViewById(R.id.audio_image)
        val audioName: TextView = view.findViewById(R.id.audio_name)
        val audioService: TextView = view.findViewById(R.id.audio_service)
        val audioDate: TextView = view.findViewById(R.id.audio_date)
        val audioLanguage: TextView = view.findViewById(R.id.audio_language)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.audio_item,parent,false)
        return AudioViewHolder(view)
    }

    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {
        val currentAudio=audioModel[position]

        holder.audioName.text=currentAudio.name
        holder.audioLanguage.text=currentAudio.language
        holder.audioService.text=currentAudio.service
        holder.audioDate.text=currentAudio.date
        holder.audioImage.setImageResource(currentAudio.image)

    }

    override fun getItemCount(): Int {
        return audioModel.size

    }

    fun setLocationData(newAudioModel: List<AudioModel>){
        audioModel=newAudioModel
    }
}
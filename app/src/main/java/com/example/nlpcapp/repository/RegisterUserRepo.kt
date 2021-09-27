package com.example.nlpcapp.repository

import android.net.Uri
import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class RegisterUserRepo {
    private val database = Firebase.database
   private val register = database.getReference("message")
    private lateinit var  userId:String

    fun save(fullName:String,phone:String,email:String,pic:Uri){


    }

    fun getCurrentUser() {
        val user=FirebaseAuth.getInstance().currentUser
        if (user!==null){
           userId=user.toString()


        }

    }
}
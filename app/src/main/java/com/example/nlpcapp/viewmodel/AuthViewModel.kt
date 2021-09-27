package com.example.nlpcapp.viewmodel

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nlpcapp.repository.authenticaion.FirebasePhoneAuth

class AuthViewModel: ViewModel() {
    private val firebasePhoneAuth:FirebasePhoneAuth = FirebasePhoneAuth()
    private val currentUser=MutableLiveData("")
    private val isAUTHENTICATED=MutableLiveData(false)

    init {
        firebasePhoneAuth.getCurrentUser()
    }


    fun verifyPhoneNumber(number:String,activity: Activity){
        firebasePhoneAuth.verifyPhoneNumber(number,activity)
    }

    fun signInUser(otp:String){
        firebasePhoneAuth.signInUser(otp)
    }

    fun currentUser():LiveData<String>{
       currentUser.value= firebasePhoneAuth.getCurrentUser().toString()

        return currentUser
    }

    fun signOut(){
        firebasePhoneAuth.signOut()
    }

    fun isAUTHENTICATED():LiveData<Boolean>{
        isAUTHENTICATED.value=firebasePhoneAuth.isAUTHENTICATED().value

        return isAUTHENTICATED

    }


}
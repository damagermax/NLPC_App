package com.example.nlpcapp.repository.authenticaion


import android.app.Activity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import java.util.concurrent.TimeUnit

private const val TAG: String = "max"

class FirebasePhoneAuth {
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private var _storedVerificationId = MutableLiveData("")
    private val isAUTHENTICATED=MutableLiveData(false)
    private val currentUser = MutableLiveData("")
//    private var _resendToken= MutableLiveData<>(PhoneAuthProvider.ForceResendingToken)
//    val resendToken:LiveData<ForceResendingToken> = _resendToken


    private val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            // This callback will be invoked in two situations:
            // 1 - Instant verification. In some cases the phone number can be instantly
            //     verified without needing to send or enter a verification code.
            // 2 - Auto-retrieval. On some devices Google Play services can automatically
            //     detect the incoming verification SMS and perform verification without
            //     user action.

            signInWithPhoneAuthCredential(credential)
        }

        override fun onVerificationFailed(e: FirebaseException) {
            // This callback is invoked in an invalid request for verification is made,
            // for instance if the the phone number format is not valid.
            Log.w(TAG, "onVerificationFailed", e)

            if (e is FirebaseAuthInvalidCredentialsException) {
                // Invalid request


            } else if (e is FirebaseTooManyRequestsException) {
                // The SMS quota for the project has been exceeded

            }


        }

        override fun onCodeSent(
            verificationId: String,
            token: ForceResendingToken
        ) {
            // The SMS verification code has been sent to the provided phone number, we
            // now need to ask the user to enter the code and then construct a credential
            // by combining the code with a verification ID.
            Log.d(TAG, "onCodeSent:$verificationId")

            // Save verification ID and resending token so we can use them later
            _storedVerificationId.value = verificationId
            //resendToken.value = token
        }
    }

    fun verifyPhoneNumber(number: String, activity: Activity) {
        val options = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber(number)       // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(activity)                 // Activity (for callback binding)
            .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)

    }

    fun signInUser(otp: String) {

        if (!_storedVerificationId.value.isNullOrEmpty()) {

            val credential =
                PhoneAuthProvider.getCredential(_storedVerificationId.value.toString(), otp)
            signInWithPhoneAuthCredential(credential)
        }


    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    val user = task.result?.user

                } else {


                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid

                    }
                    // Update UI
                }
            }
    }

     fun getCurrentUser():LiveData<String>{
        val user=firebaseAuth.currentUser
        if (user!==null){
            currentUser.value=user.toString()
            isAUTHENTICATED.value=true

        }
         else{
             isAUTHENTICATED.value=false
         }
        return currentUser
    }

    fun signOut(){
        val user=firebaseAuth.currentUser
        if (user!==null){
           firebaseAuth.signOut()
            isAUTHENTICATED.value=false

        }

    }

    fun isAUTHENTICATED():LiveData<Boolean>{
        return isAUTHENTICATED
    }
}



package com.example.nlpcapp.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.nlpcapp.R
import com.example.nlpcapp.utils.showToast
import com.example.nlpcapp.viewmodel.AuthViewModel
import com.hbb20.CountryCodePicker


class VerifyNumber : Fragment(){


    private lateinit var submitBtn: Button
    private lateinit var countryCodePicker: CountryCodePicker
    private lateinit var phoneNumberInput: EditText
    private lateinit var authViewModel: AuthViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_verify_number, container, false)

        submitBtn = view.findViewById(R.id.submitBtn)
        countryCodePicker = view.findViewById(R.id.ccp)
        phoneNumberInput = view.findViewById(R.id.numberEt)
        authViewModel = ViewModelProvider(requireActivity()).get(AuthViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        submitBtn.setOnClickListener {
            countryCodePicker.registerCarrierNumberEditText(phoneNumberInput)
            val fullNumber = countryCodePicker.fullNumberWithPlus

            when {
                TextUtils.isEmpty(phoneNumberInput.text) -> {
                    requireActivity().showToast("Enter phone number")

                }
                phoneNumberInput.text.length < 10  -> {
                    requireActivity().showToast("Phone number should contain 10 digits")

                }
                else -> {
                    authViewModel.verifyPhoneNumber(fullNumber, requireActivity())
                    val action = VerifyNumberDirections.actionVerifyNumberToConfirm2()
                    findNavController().navigate(action)

                }
            }
        }
    }

    override fun onStart() {
        super.onStart()

        // check if user is authenticated
        authViewModel.isAUTHENTICATED().observe(requireActivity()){isATHENTICATED->

            if (isATHENTICATED){
                val action = VerifyNumberDirections.actionVerifyNumberToDashboard()
                findNavController().navigate(action)
            }

        }

    }


}
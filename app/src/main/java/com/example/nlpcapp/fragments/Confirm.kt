package com.example.nlpcapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider

import com.chaos.view.PinView
import com.example.nlpcapp.R
import com.example.nlpcapp.utils.showToast
import com.example.nlpcapp.viewmodel.AuthViewModel

import androidx.appcompat.app.AlertDialog


class confirm : Fragment() {


    private lateinit var pinView: PinView
    private lateinit var dialog: AlertDialog
    private lateinit var confirmBtn: Button
    private lateinit var authViewModel: AuthViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_confirm, container, false)

        confirmBtn = view.findViewById(R.id.confirmBtn)
        pinView = view.findViewById(R.id.pinView)
        authViewModel = ViewModelProvider(requireActivity()).get(AuthViewModel::class.java)

        showDialog()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        confirmBtn.setOnClickListener {


            val otp = pinView.text.toString()

            if (otp.isEmpty()) {
                requireActivity().showToast("Enter code")
            } else {
                authViewModel.signInUser(otp)
            }


        }
    }

    private fun showDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setCancelable(false) // if you want user to wait for some process to finish,
        builder.setView(R.layout.progress_dialog_view)
        dialog = builder.create()
        dialog.window!!.setLayout(300, 300)

    }



}
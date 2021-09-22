package com.example.nlpcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.findNavController()


        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNavigation.setupWithNavController(navController)





        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.verifyNumber -> {
                    bottomNavigation.visibility = View.GONE
                }
                R.id.register -> {
                    bottomNavigation.visibility = View.GONE
                }
                R.id.confirm2 -> {
                    bottomNavigation.visibility = View.GONE
                }

                else -> {
                    bottomNavigation.visibility = View.VISIBLE

                }
            }
        }
    }

}
package com.qwqeqrqwqeqr.sensor.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.qwqeqrqwqeqr.sensor.R
import com.qwqeqrqwqeqr.sensor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setUpNavigation()
       }


    private fun setUpNavigation(){
        navHostFragment = supportFragmentManager.findFragmentById(R.id.main_fragment_container) as NavHostFragment
        navController = navHostFragment.navController
    }


}
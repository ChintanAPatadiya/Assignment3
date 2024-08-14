package com.example.assignment3

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set onClickListeners for each city button
        binding.buttonNewYork.setOnClickListener {
            openWeatherDetail("New York")
        }

        binding.buttonLosAngeles.setOnClickListener {
            openWeatherDetail("Los Angeles")
        }

        binding.buttonChicago.setOnClickListener {
            openWeatherDetail("Chicago")
        }

        binding.buttonHouston.setOnClickListener {
            openWeatherDetail("Houston")
        }

        // Optionally load a fragment into the FrameLayout
        loadFragment(WeatherFragment())
    }

    // Function to open WeatherDetailActivity with selected city
    private fun openWeatherDetail(cityName: String) {
        val intent = Intent(this, WeatherDetailActivity::class.java)
        intent.putExtra("CITY_NAME", cityName)
        startActivity(intent)
    }

    // Function to load a fragment into the FrameLayout
    private fun loadFragment(fragment: WeatherFragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
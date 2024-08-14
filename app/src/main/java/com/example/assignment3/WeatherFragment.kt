package com.example.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.assignment3.databinding.FragmentWeatherBinding

class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize View Binding
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        val view = binding.root

        // Set weather data
        setWeatherData()

        return view
    }

    private fun setWeatherData() {
        // Example data setting
        binding.tempText.text = "28°C"
        binding.humidText.text = "55%"
        binding.summText.text = "Partly cloudy with a chance of rain."
        binding.windSpText.text = "20 km/h"
        binding.visiText.text = "12 km"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
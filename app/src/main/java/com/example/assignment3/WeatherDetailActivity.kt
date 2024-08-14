package com.example.assignment3

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.NotificationCompat

class WeatherDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_detail)

        // Receiving the city name
        val cityName = intent.getStringExtra("CITY_NAME")
        val cityNameTextView = findViewById<TextView>(R.id.city_name_text)
        cityNameTextView.text = cityName

        // Displaying weather details (you can customize these based on the city)
        val weatherDetailsTextView = findViewById<TextView>(R.id.weather_details_text)
        weatherDetailsTextView.text = getWeatherDetails(cityName)

        // Creating and showing the notification
        createNotificationChannel()
        val notificationBuilder = NotificationCompat.Builder(this, "weather_channel")
            .setSmallIcon(R.drawable.ic_weather)
            .setContentTitle("Weather Update for $cityName")
            .setContentText(getWeatherDetails(cityName))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setVibrate(longArrayOf(0, 500, 1000))
            .setLights(Color.BLUE, 500, 500)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(1, notificationBuilder.build())
    }

    private fun getWeatherDetails(cityName: String?): String {
        return when (cityName) {
            "New York" -> "Temperature: 25°C\nHumidity: 60%"
            "Los Angeles" -> "Temperature: 30°C\nHumidity: 50%"
            "Chicago" -> "Temperature: 20°C\nHumidity: 70%"
            "Houston" -> "Temperature: 35°C\nHumidity: 80%"
            else -> "Temperature: N/A\nHumidity: N/A"
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Weather Channel"
            val descriptionText = "Channel for weather updates"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("weather_channel", name, importance).apply {
                description = descriptionText
                enableLights(true)
                lightColor = Color.BLUE
                enableVibration(true)
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
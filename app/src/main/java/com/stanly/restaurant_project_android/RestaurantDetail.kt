package com.stanly.restaurant_project_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class RestaurantDetail : AppCompatActivity() {
    companion object {
        const val RESTAURANT_NAME = "extra_name"
        const val RESTAURANT_PHOTO = "extra_photo"
        const val RESTAURANT_CITY = "extra_city"
        const val RESTAURANT_DESCRIPTION = "extra_description"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)
        val restaurantName: TextView = findViewById(R.id.tv_name)
        val restaurantPhoto: ImageView = findViewById(R.id.restaurant_photo)
        val restaurantCity: TextView = findViewById(R.id.restaurant_city)
        val restaurantDescription: TextView = findViewById(R.id.restaurant_description)

        val name = intent.getStringExtra(RESTAURANT_NAME)
        val photo = intent.getIntExtra(RESTAURANT_PHOTO, 0)
        val city = intent.getStringExtra(RESTAURANT_CITY)
        val description = intent.getStringExtra(RESTAURANT_DESCRIPTION)

        restaurantName.text = name
        Glide.with(this)
            .load(photo)
            .apply(RequestOptions())
            .into(restaurantPhoto)
        restaurantCity.text = city
        restaurantDescription.text = description
    }
}
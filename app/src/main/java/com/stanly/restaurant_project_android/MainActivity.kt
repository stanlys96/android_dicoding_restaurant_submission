package com.stanly.restaurant_project_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvRestaurant: RecyclerView
    private var list: ArrayList<Restaurant> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvRestaurant = findViewById(R.id.rv_restaurants)
        rvRestaurant.setHasFixedSize(true)

        list.addAll(RestaurantsData.listData)
        showRecyclerList()

        val goToProfile: Button = findViewById(R.id.btn_go_to_profile)
        goToProfile.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_go_to_profile -> {
                val moveIntent = Intent(this@MainActivity, UserProfile::class.java)
                startActivity(moveIntent)
            }
        }
    }

    private fun showRecyclerList() {
        rvRestaurant.layoutManager = LinearLayoutManager(this)
        val listRestaurantAdapter = ListRestaurantAdapter(list)
        rvRestaurant.adapter = listRestaurantAdapter
    }
}
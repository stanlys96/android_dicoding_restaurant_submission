package com.stanly.restaurant_project_android

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListRestaurantAdapter(private val listRestaurant: ArrayList<Restaurant>) :
    RecyclerView.Adapter<ListRestaurantAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_restaurant, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val restaurant = listRestaurant[position]
        Glide.with(holder.itemView.context)
            .load(restaurant.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = restaurant.name
        holder.tvCity.text = restaurant.city

        val context = holder.itemView.context

        holder.itemView.setOnClickListener {
            val detail = Intent(context, RestaurantDetail::class.java)
            detail.putExtra(RestaurantDetail.RESTAURANT_NAME, restaurant.name)
            detail.putExtra(RestaurantDetail.RESTAURANT_PHOTO, restaurant.photo)
            detail.putExtra(RestaurantDetail.RESTAURANT_CITY, restaurant.city)
            detail.putExtra(RestaurantDetail.RESTAURANT_DESCRIPTION, restaurant.description)
            context.startActivity(detail)
        }
    }

    override fun getItemCount(): Int {
        return listRestaurant.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvCity: TextView = itemView.findViewById(R.id.tv_item_city)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}
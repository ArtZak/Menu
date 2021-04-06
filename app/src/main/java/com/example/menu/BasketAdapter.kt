package com.example.menu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BasketAdapter(val context: Context, val data: List<MenuData>) : RecyclerView.Adapter<BasketAdapter.BasketViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.menu_row, parent,false)
        return BasketViewHolder(view)
    }

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        holder.icon.setImageResource(data[position].icon)
        holder.name.text = data[position].name
        holder.restaurantName.text = data[position].restaurantName
        holder.review.text = data[position].review.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class BasketViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val icon : ImageView
        val name : TextView
        val restaurantName : TextView
        val review : TextView
        val like : ImageButton
        val basket : ImageButton

        init {
            icon = view.findViewById(R.id.icon)
            name = view.findViewById(R.id.name)
            restaurantName = view.findViewById(R.id.restaurant_name)
            review = view.findViewById(R.id.review)
            like = view.findViewById(R.id.like)
            basket = view.findViewById(R.id.basket)

            like.visibility = View.GONE
            basket.visibility = View.GONE
        }
    }
}
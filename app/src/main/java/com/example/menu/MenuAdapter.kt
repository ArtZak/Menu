package com.example.menu

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.icu.text.IDNA
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(val context: Context, val data: MutableList<MenuData>) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.menu_row, parent,false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val currentData = data[position]

        holder.icon.setImageResource(currentData.icon)
        holder.name.text = currentData.name
        holder.restaurantName.text = currentData.restaurantName
        holder.review.text = currentData.review.toString()

        if(currentData.isLiked){
            holder.like.setImageResource(R.mipmap.heartfilled)
        }
        else{
            holder.like.setImageResource(R.mipmap.heart)
        }

        if(currentData.isInBasket){
            holder.basket.setImageResource(R.mipmap.basketfilled)
        }
        else{
            holder.basket.setImageResource(R.mipmap.basket)
        }

        holder.like.setOnClickListener {
            if(currentData.isLiked){
                currentData.isLiked = false
                (it as ImageButton).setImageResource(R.mipmap.heart)
            }
            else{
                data[position].isLiked = true
                (it as ImageButton).setImageResource(R.mipmap.heartfilled)
            }
        }

        holder.basket.setOnClickListener {
            if(currentData.isInBasket){
                currentData.isInBasket = false
                (it as ImageButton).setImageResource(R.mipmap.basket)
            }
            else{
                currentData.isInBasket = true
                (it as ImageButton).setImageResource(R.mipmap.basketfilled)
            }
        }

        holder.card.setOnClickListener {
            if(holder.delete.visibility == View.GONE) {
                val intent = Intent(context, InfoActivity::class.java).apply {
                    putExtra("selection", currentData.selection)
                }
                context.startActivity(intent)
            }
            else{
                holder.like.visibility = View.VISIBLE
                holder.basket.visibility = View.VISIBLE
                holder.delete.visibility = View.GONE
            }
        }

        holder.card.setOnLongClickListener {
            holder.like.visibility = View.GONE
            holder.basket.visibility = View.GONE
            holder.delete.visibility = View.VISIBLE
            true
        }

        holder.delete.setOnClickListener {
            data.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val card : CardView
        val icon : ImageView
        val name : TextView
        val restaurantName : TextView
        val review : TextView
        val like : ImageButton
        val basket : ImageButton
        val delete : ImageButton

        init {
            card = view.findViewById(R.id.card)
            icon = view.findViewById(R.id.icon)
            name = view.findViewById(R.id.name)
            restaurantName = view.findViewById(R.id.restaurant_name)
            review = view.findViewById(R.id.review)
            like = view.findViewById(R.id.like)
            basket = view.findViewById(R.id.basket)
            delete = view.findViewById(R.id.delete)
        }
    }
}
package com.example.menu

import java.io.Serializable

data class MenuData(val icon: Int,
                    val name: String,
                    val restaurantName: String,
                    val review: Double,
                    var isLiked: Boolean,
                    var isInBasket: Boolean,
                    var selection: String) : Serializable

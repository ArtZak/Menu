package com.example.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var addBtn : Button
    lateinit var backBtn : Button
    lateinit var basketBtn : ImageButton
    lateinit var menuAdapter : MenuAdapter

    val foods = mutableListOf(
        MenuData(R.drawable.icon1, "Cheese", "Belagio", 4.9, true, false, "Dip chicken in egg mixture, then place in the flour mixture, a few pieces at a time. Turn to coat. In a deep-fat fryer, heat oil to 375°. Working in batches, fry chicken, several pieces at a time, until golden brown and a thermometer inserted into chicken reads 165°, about 7-8 minutes on each side."),
        MenuData(R.drawable.icon2, "Cheese", "Belagio", 4.9, false, false, "Pasta Salad Recipes. Easy Pasta Salad. As its name suggests, this one is a breeze to make. Rainbow Orzo Salad. Diced mango adds a surprising sweet twist to this colorful orzo, red onion, bell pepper, herb, and cucumber salad. Creamy Vegan Pasta Salad. Broccoli Pasta Salad."),
        MenuData(R.drawable.icon3, "Cheese", "Belagio", 4.9, false, false, "3/4 cup (210g) all-purpose flour. 2 cups (400g) granulated sugar. 3/4 cup (90g) unsweetened cocoa powder. 1 tsp. baking powder. 1 tsp. kosher salt. 1 cup (240g) buttermilk, room temperature. 2 extra-large eggs, at room temperature. 2 tsp. McCormick pure vanilla extract."),
        MenuData(R.drawable.icon3, "Cheese", "Belagio", 4.9, true, false, "Pasta Salad Recipes. Easy Pasta Salad. As its name suggests, this one is a breeze to make. Rainbow Orzo Salad. Diced mango adds a surprising sweet twist to this colorful orzo, red onion, bell pepper, herb, and cucumber salad. Creamy Vegan Pasta Salad. Broccoli Pasta Salad."),
        MenuData(R.drawable.icon2, "Cheese", "Belagio", 4.9, false, true, "Dip chicken in egg mixture, then place in the flour mixture, a few pieces at a time. Turn to coat. In a deep-fat fryer, heat oil to 375°. Working in batches, fry chicken, several pieces at a time, until golden brown and a thermometer inserted into chicken reads 165°, about 7-8 minutes on each side."),
        MenuData(R.drawable.icon1, "Cheese", "Belagio", 4.9, true, false, "Dip chicken in egg mixture, then place in the flour mixture, a few pieces at a time. Turn to coat. In a deep-fat fryer, heat oil to 375°. Working in batches, fry chicken, several pieces at a time, until golden brown and a thermometer inserted into chicken reads 165°, about 7-8 minutes on each side."),
        MenuData(R.drawable.icon1, "Cheese", "Belagio", 4.9, true, false, "3/4 cup (210g) all-purpose flour. 2 cups (400g) granulated sugar. 3/4 cup (90g) unsweetened cocoa powder. 1 tsp. baking powder. 1 tsp. kosher salt. 1 cup (240g) buttermilk, room temperature. 2 extra-large eggs, at room temperature. 2 tsp. McCormick pure vanilla extract."),
        MenuData(R.drawable.icon2, "Cheese", "Belagio", 4.9, false, false, "Pasta Salad Recipes. Easy Pasta Salad. As its name suggests, this one is a breeze to make. Rainbow Orzo Salad. Diced mango adds a surprising sweet twist to this colorful orzo, red onion, bell pepper, herb, and cucumber salad. Creamy Vegan Pasta Salad. Broccoli Pasta Salad."),
        MenuData(R.drawable.icon1, "Cheese", "Belagio", 4.9, true, true, "Pasta Salad Recipes. Easy Pasta Salad. As its name suggests, this one is a breeze to make. Rainbow Orzo Salad. Diced mango adds a surprising sweet twist to this colorful orzo, red onion, bell pepper, herb, and cucumber salad. Creamy Vegan Pasta Salad. Broccoli Pasta Salad."))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recycler)
        menuAdapter = MenuAdapter(this, foods)
        recycler.adapter = menuAdapter
        recycler.layoutManager = LinearLayoutManager(this)

        basketBtn = findViewById(R.id.basket_btn)
        backBtn = findViewById(R.id.back_btn)
        addBtn = findViewById(R.id.add_btn)

        basketBtn.setOnClickListener {
            addBtn.visibility = View.GONE
            backBtn.visibility = View.VISIBLE

            val basketAdapter = BasketAdapter(this, foods.filter { it.isInBasket })
            recycler.adapter = basketAdapter
        }

        backBtn.setOnClickListener {
            addBtn.visibility = View.VISIBLE
            backBtn.visibility = View.GONE

            recycler.adapter = menuAdapter
        }

        addBtn.setOnClickListener {
            startActivityForResult(Intent(this, AddActivity::class.java), 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 1){
            if(resultCode == 1){
                if(data != null){
                    val menuData = data.getSerializableExtra("data")
                    foods.add(menuData as MenuData)
                    menuAdapter.notifyDataSetChanged()
                }
            }
        }
    }
}
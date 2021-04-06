package com.example.menu

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val name = findViewById<EditText>(R.id.name)
        val restaurantName = findViewById<EditText>(R.id.restaurant_name)
        val review = findViewById<EditText>(R.id.review)
        val selection = findViewById<EditText>(R.id.selection)

        val submit = findViewById<Button>(R.id.submit_btn)
        submit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val data = MenuData(R.drawable.icon1,
                name.text.toString(),
                restaurantName.text.toString(),
                review.text.toString().toDouble(),
                false,
                false,
                selection.text.toString())

            intent.putExtra("data", data)

            setResult(1, intent)
            finish()
        }
    }
}
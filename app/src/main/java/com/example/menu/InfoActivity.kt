package com.example.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val selection = findViewById<TextView>(R.id.selection)
        val text = intent.getStringExtra("selection") ?: ""

        selection.text = text
    }
}
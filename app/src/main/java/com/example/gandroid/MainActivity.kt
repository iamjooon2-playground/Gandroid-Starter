package com.example.gandroid

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.MultiAutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var items = listOf("CSI-뉴욕", "CSI-라스베가스", "CSI-마이애미", "Friends", "Fringle", "Lost")

        var auto = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        var adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, items)
        auto.setAdapter(adapter)

        var multi = findViewById<MultiAutoCompleteTextView>(R.id.multiAutoCompleteTextView)
        var token = MultiAutoCompleteTextView.CommaTokenizer()
        multi.setTokenizer(token)
        multi.setAdapter(adapter)

        showActionBar()
    }

    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher_background)
        supportActionBar?.setIcon(R.drawable.ic_launcher_foreground)
    }
}
package com.example.gandroid

import android.os.Bundle
import android.widget.Button
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonPreview: Button
        var buttonNext: Button
        var flipper: ViewFlipper

        buttonPreview = findViewById(R.id.buttonPreview)
        buttonNext = findViewById(R.id.buttonNext)
        flipper = findViewById(R.id.viewFlipper)

        buttonPreview.setOnClickListener {
            flipper.showPrevious()
        }

        buttonNext.setOnClickListener {
            flipper.showNext()
        }

        showActionBar()
    }

    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher_background)
        supportActionBar?.setIcon(R.drawable.ic_launcher_foreground)
    }
}
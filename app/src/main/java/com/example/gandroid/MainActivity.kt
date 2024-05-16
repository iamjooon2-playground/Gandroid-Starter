package com.example.gandroid

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "토스트 연습"

        var button = findViewById<Button>(R.id.button1)

        button.setOnClickListener {
            var toastMessage = Toast.makeText(applicationContext, "토스트 연습", Toast.LENGTH_SHORT)

            var display = (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay

            var xOffSet = (Math.random() * display.width).toInt()
            var yOffSet = (Math.random() * display.height).toInt()

            toastMessage.setGravity(Gravity.TOP or Gravity.LEFT, xOffSet, yOffSet)
            toastMessage.show()
        }

        showActionBar()
    }

    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher_background)
        supportActionBar?.setIcon(R.drawable.ic_launcher_foreground)
    }
}
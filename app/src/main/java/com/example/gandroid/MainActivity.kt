package com.example.gandroid

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var tvName : TextView;
    lateinit var tvEmail : TextView;
    lateinit var button : TextView;
    lateinit var dialogEditName : TextView;
    lateinit var dialogEditText : TextView;
    lateinit var toastText : TextView;
    lateinit var dialogView : View;
    lateinit var toastView : View;
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showActionBar()
    }

    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher_background)
        supportActionBar?.setIcon(R.drawable.ic_launcher_foreground)
    }
}
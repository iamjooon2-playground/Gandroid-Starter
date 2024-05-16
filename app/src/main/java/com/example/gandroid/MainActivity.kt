package com.example.gandroid

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.SubMenu
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var baseLayout: LinearLayout
    lateinit var button1: Button
    lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "이준희의 컨텍스트 메뉴"

        baseLayout = findViewById(R.id.baseLayout)

        button1 = findViewById(R.id.button)
        registerForContextMenu(button1)

        button2 = findViewById(R.id.button2)
        registerForContextMenu(button2)

        showActionBar()
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        var mInflater = this.menuInflater
        if (v === button1) {
            menu!!.setHeaderTitle("배경색 변경")
            mInflater.inflate(R.menu.menu, menu)
        }
        if (v === button2) {
            mInflater.inflate(R.menu.menu2, menu)
        }
    }

    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher_background)
        supportActionBar?.setIcon(R.drawable.ic_launcher_foreground)
    }
}
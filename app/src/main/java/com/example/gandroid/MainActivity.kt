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

        title = "이준희의 배경색 변경~"

        baseLayout = findViewById(R.id.baseLayout)
        button1 = findViewById(R.id.button)
        registerForContextMenu(button1)

        button2 = findViewById(R.id.button2)
        registerForContextMenu(button2)

        showActionBar()
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        super.onCreateOptionsMenu(menu)
//        var minimunFlater = menuInflater
//        minimunFlater.inflate(R.menu.menu, menu)
//        minimunFlater.inflate(R.menu.menu2, menu)
//        return true
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            1 -> {
                baseLayout.setBackgroundColor(Color.RED)
                return true
            }
            R.id.itemRed -> {
                baseLayout.setBackgroundColor(Color.RED)
                return true
            }
            R.id.itemGreen -> {
                baseLayout.setBackgroundColor(Color.GREEN)
                return true
            }
            R.id.itemBlue -> {
                baseLayout.setBackgroundColor(Color.BLUE)
                return true
            }
            R.id.subRotate -> {
                button1.rotation = 45f
                return true
            }
            R.id.subSize -> {
                button1.rotation = 2f
                return true
            }
        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        menu!!.add(0, 1, 0, "배경색(빨강)")
        menu!!.add(0, 2, 0, "배경색(초록)")
        menu!!.add(0, 3, 0, "배경색(파랑)")

        var subMenu : SubMenu = menu.addSubMenu("버튼 변경 >>")
        subMenu.add(0, 4, 0, "버튼 변경 >> ")
        subMenu.add(0, 5, 0, "버튼 2배 확대 >> ")

        return true
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
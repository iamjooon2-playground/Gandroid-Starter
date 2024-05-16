package com.example.gandroid

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            var versions = arrayOf("오레오", "파이", "큐(10)")
            var checkArray = booleanArrayOf(true, false, false)

            var dialog = AlertDialog.Builder(this@MainActivity)

            dialog.setTitle("좋아하는 버전은?")
            dialog.setIcon(R.mipmap.ic_launcher)
//            dialog.setItems(versions) { dialog, index ->
//                button.text = versions[index]
//            }
            dialog.setMultiChoiceItems(versions, checkArray) { dialog, index, isChecked ->
                button.text = versions[index]
            }

            dialog.setPositiveButton("닫기", null)
            dialog.show()
        }

        showActionBar()
    }

    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher_background)
        supportActionBar?.setIcon(R.drawable.ic_launcher_foreground)
    }
}
package com.example.gandroid

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "이준희의 라디오 박스"

        var button = findViewById<Button>(R.id.button)

        var focus = 0
        button.setOnClickListener {
            val versions = arrayOf("코틀린", "자바", "스칼라")

            var dialog = AlertDialog.Builder(this@MainActivity)

            dialog.setTitle("가장 좋아하는 프로그래밍 언어는?")
            dialog.setIcon(R.mipmap.ic_launcher)

            dialog.setSingleChoiceItems(versions, focus) { dialog, index ->
                button.text = versions[index]
                focus = index;
            }

            dialog.setPositiveButton("저장하기", null)
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
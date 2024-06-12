package com.example.gandroid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "이준희의 양방향 액티비티"

        var buttonActivity = findViewById<Button>(R.id.buttonSum)

        buttonActivity.setOnClickListener {
            var editNumber1 = findViewById<EditText>(R.id.editNum1)
            var editNumber2 = findViewById<EditText>(R.id.editNum2)
            println(editNumber1)
            println(editNumber2)
            var intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("Num1", Integer.parseInt(editNumber1.text.toString()))
            intent.putExtra("Num2", Integer.parseInt(editNumber2.text.toString()))
            startActivityForResult(intent, 0)
        }

        showActionBar()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            var sum = data!!.getIntExtra("sum", 0)
            Toast.makeText(applicationContext, "합계 : ${sum}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher_background)
        supportActionBar?.setIcon(R.drawable.ic_launcher_foreground)
    }
}
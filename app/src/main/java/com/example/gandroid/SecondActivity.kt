package com.example.gandroid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        title = "이준희의 Second Activity"

        var inIntent = intent
        var sum = inIntent.getIntExtra("Num1", 0) + inIntent.getIntExtra("Num2", 0)

        var button = findViewById<Button>(R.id.buttonReturn)
        button.setOnClickListener {
            var outIntent = Intent(applicationContext, MainActivity::class.java)
            outIntent.putExtra("sum", sum)
            setResult(Activity.RESULT_OK, outIntent)
            finish()
        }
    }

}
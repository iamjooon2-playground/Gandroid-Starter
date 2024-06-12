package com.example.gandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "이준희의 사진 투표"

        var voteCount = IntArray(9)
        for (i in 0..8) {
            voteCount[i] = 0
        }
        //
        var image = arrayOfNulls<ImageView>(9)
        var imageIds = arrayOf(
            R.id.level1, R.id.level2,
            R.id.level3,
            R.id.level4,
            R.id.level5,
            R.id.level6,
            R.id.level7,
            R.id.level8,
            R.id.level9
        )

        var imageNames = arrayOf(
            "이준희1",
            "이준희2",
            "이준희3",
            "이준희4",
            "이준희5",
            "이준희6",
            "이준희7",
            "이준희8",
            "이준희9",
        )

        for (i in imageIds.indices) {
            image[i] = findViewById(imageIds[i])
            image[i]!!.setOnClickListener {
                voteCount[i]++
                Toast.makeText(applicationContext, imageNames[i] + ": 총" + voteCount[i] + "표", Toast.LENGTH_LONG).show()
            }
        }

        var buttonResult = findViewById<Button>(R.id.buttonResult);
        buttonResult.setOnClickListener {
            var intent = Intent(applicationContext, ResultActivity::class.java)
            intent.putExtra("VoteCount", voteCount)
            intent.putExtra("ImageName", imageNames)
            startActivity(intent)
        }

        showActionBar()
    }

    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher_background)
        supportActionBar?.setIcon(R.drawable.ic_launcher_foreground)
    }
}
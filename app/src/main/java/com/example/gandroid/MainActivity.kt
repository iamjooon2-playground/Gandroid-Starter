package com.example.gandroid

import android.content.Context
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.io.File

class MainActivity : AppCompatActivity() {
    lateinit var buttonPrev: Button
    lateinit var buttonNext: Button
    lateinit var myPicture: PictureView

    var currentNumber: Int = 0
    var imageFiles: Array<File>? = null

    lateinit var imageFname: String

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "이준희의 간단 이미지 뷰어"

        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
            Context.MODE_PRIVATE
        )

        buttonPrev = findViewById(R.id.prev)
        buttonNext = findViewById(R.id.next)
        myPicture = findViewById(R.id.PictureView)

        imageFiles = File("/storage/emulated/0/temp-picture").listFiles()
        imageFname = imageFiles!![0].toString()
        myPicture.imagePath = imageFname

        buttonPrev.setOnClickListener {
            if (currentNumber <= 0) {
                Toast.makeText(applicationContext, "첫 그림이에요~", Toast.LENGTH_LONG).show()
            } else {
                currentNumber -= 1
                imageFname = imageFiles!![currentNumber].toString()
                myPicture.imagePath = imageFname
                myPicture.invalidate()
            }
        }

        buttonNext.setOnClickListener {
            if (currentNumber >= imageFiles!!.size - 1) {
                Toast.makeText(applicationContext, "마지막 그림이에요~", Toast.LENGTH_LONG).show()
            } else {
                currentNumber += 1
                imageFname = imageFiles!![currentNumber].toString()
                myPicture.imagePath = imageFname
                myPicture.invalidate()
            }
        }
    }

    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher_background)
        supportActionBar?.setIcon(R.drawable.ic_launcher_foreground)
    }
}
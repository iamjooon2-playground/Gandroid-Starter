package com.example.gandroid

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
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

private class MyGraphicView(context: Context) : View(context) {

    override fun onDraw(canvas : Canvas) {
        super.onDraw(canvas)

        var picture = BitmapFactory.decodeResource(resources, R.drawable.gachon)
        var picX = (this.width - picture.width) / 2f
        var picY = (this.height - picture.height) / 2f
        canvas.drawBitmap(picture, picX, picY, null)
        picture.recycle()
    }
}

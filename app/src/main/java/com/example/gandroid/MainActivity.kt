package com.example.gandroid

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.ColorMatrix
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var ibZoomIn: ImageButton
    lateinit var ibZoomOut: ImageButton
    lateinit var ibRotate: ImageButton
    lateinit var ibBright: ImageButton
    lateinit var ibDark: ImageButton
    lateinit var ibGray: ImageButton
    lateinit var graphicView: MyGraphicView

    companion object {
        var sX = 1f
        var sY = 1f
        var angle = 0f
        var color = 1f
        var satur = 1f
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyGraphicView(this))
        title = "이준희의 미니 포토샵"

        var pictureLayout = findViewById<LinearLayout>(R.id.pictureLayout)
        graphicView = MyGraphicView(this)
        pictureLayout.addView(graphicView)

        clickIcons()

        showActionBar()
    }

    fun clickIcons() {
        ibZoomIn = findViewById(R.id.ibZoomIn)
        ibZoomIn.setOnClickListener {
            sX += 0.2f
            sY += 0.2f
            graphicView.invalidate()
        }

        ibZoomOut = findViewById(R.id.ibZoomOut)
        ibZoomOut.setOnClickListener {
            sX -= 0.2f
            sY -= 0.2f
            graphicView.invalidate()
        }

        ibRotate = findViewById(R.id.ibRotate) as ImageButton
        ibRotate.setOnClickListener {
            angle += 20
            graphicView.invalidate()
        }

        ibBright = findViewById(R.id.ibLightOn)
        ibBright.setOnClickListener {
            color += 0.2f
            graphicView.invalidate()
        }

        ibDark = findViewById(R.id.ibLightOut)
        ibDark.setOnClickListener {
            color -= 0.2f
            graphicView.invalidate()
        }

        ibGray = findViewById(R.id.ibGray)
        ibGray.setOnClickListener {
            if (satur == 0f) {
                satur = 1f
            } else {
                satur = 0f
            }
            graphicView.invalidate()
        }
    }

    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher_background)
        supportActionBar?.setIcon(R.drawable.ic_launcher_foreground)
    }

    class MyGraphicView(context: Context) : View(context) {

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            var picture = BitmapFactory.decodeResource(resources, R.drawable.gachon)

            var picX = (this.width - picture.width) / 2f
            var picY = (this.height - picture.height) / 2f

            var paint = Paint()
            var array = floatArrayOf(
                color, 0f, 0f, 0f, 0f,
                0f, color, 0f, 0f, 0f,
                0f, 0f, color, 0f, 0f,
                0f, 0f, 0f, 1f, 0f
            )
            val colorMatrix = ColorMatrix(array)

            canvas.drawBitmap(picture, picX, picY, paint)

            picture.recycle()
        }
    }

}

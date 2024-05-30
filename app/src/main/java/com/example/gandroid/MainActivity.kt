package com.example.gandroid

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.EmbossMaskFilter
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyGraphicView(this))
//        setContentView(R.layout.activity_main)
        title = "이준희의 비트맵 사용하기~"

        showActionBar()
    }

    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher_background)
        supportActionBar?.setIcon(R.drawable.ic_launcher_foreground)
    }
}

private class MyGraphicView(context: Context) : View(context) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var picture = BitmapFactory.decodeResource(resources, R.drawable.gilya)

        var cenX = this.width / 2f
        var cenY = this.height / 2f
        var picX = (this.width - picture.width) / 2f
        var picY = (this.height - picture.height) / 2f

        var paint = Paint()
        var blurMaskFilter = BlurMaskFilter(30f, BlurMaskFilter.Blur.NORMAL)
        paint.maskFilter = blurMaskFilter
//        var eMask: EmbossMaskFilter
//        eMask = EmbossMaskFilter(floatArrayOf(3f, 3f, 3f), 0.5f, 5f, 10f)

//        paint.maskFilter = eMask
//        canvas.drawCircle(cenX, cenY, 150f, paint)
//        canvas.drawBitmap(picture, picX, picY, paint)

        picture.recycle()


//        canvas.drawBitmap(picture, picX, picY, null)
//        picture.recycle()
//
//        canvas.rotate(45f, cenX, cenY)
//        canvas.drawBitmap(picture, picX, picY, null)
//
//        canvas.translate(-150f, 200f)
//        canvas.drawBitmap(picture, picX, picY, null)
//
//        canvas.scale(2f, 2f, cenX, cenY)
//        canvas.drawBitmap(picture, picX, picY, null)
//
//        canvas.skew(0.3f, 0.3f)
//        canvas.drawBitmap(picture, picX, picY, null)
//
//        picture.recycle()
    }
}

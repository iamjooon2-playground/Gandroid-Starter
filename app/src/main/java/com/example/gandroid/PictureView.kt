package com.example.gandroid

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import android.widget.Toast

class PictureView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    var imagePath: String? = null
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        try {
            if (imagePath != null) {
                var bitmap = BitmapFactory.decodeFile(imagePath)
                canvas.scale(2f, 2f, 0f, 0f)
                canvas.drawBitmap(bitmap!!, 0f, 0f, null)
                bitmap!!.recycle()
            }
        } catch (e: Exception) {
            println(e.toString())
            Toast.makeText(context, "예외 발생: " + e.message, Toast.LENGTH_SHORT)
                .show()
        }
    }
}

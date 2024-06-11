package com.example.gandroid

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.gandroid.MainActivity.Companion.CIRCLE
import com.example.gandroid.MainActivity.Companion.LINE
import com.example.gandroid.MainActivity.Companion.RECTANGLE
import com.example.gandroid.MainActivity.Companion.TRIANGLE

class MainActivity : AppCompatActivity() {

    companion object {
        const val LINE: Int = 1
        const val CIRCLE: Int = 2
        const val RECTANGLE: Int = 3
        const val TRIANGLE: Int = 4
        var currentShape = LINE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyGraphicView(this))

        title = "이준희의 간단 그림판"

        showActionBar()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menu!!.add(0, 1, 0, "선 그리기")
        menu!!.add(0, 2, 0, "원 그리기")
        menu!!.add(0, 3, 0, "사각형 그리기")
        menu!!.add(0, 4, 0, "삼각형 그리기")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            1 -> {
                currentShape = LINE
                return true
            }

            2 -> {
                currentShape = CIRCLE
                return true
            }

            3 -> {
                currentShape = RECTANGLE
                return true
            }

            4 -> {
                currentShape = TRIANGLE
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher_background)
        supportActionBar?.setIcon(R.drawable.ic_launcher_foreground)
    }
}

private class MyGraphicView(context: Context) : View(context) {

    var startX = -1f
    var startY = -1f
    var stopX = -1f
    var stopY = -1f

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.x
                startY = event.y
            }

            MotionEvent.ACTION_MOVE, MotionEvent.ACTION_UP -> {
                stopX = event.x
                stopY = event.y
                this.invalidate()
            }
        }
        return true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint = Paint()

        paint.isAntiAlias = true
        paint.strokeWidth = 5f
        paint.style = Paint.Style.STROKE
        paint.color = Color.RED

        when (MainActivity.currentShape) {
            LINE -> canvas.drawLine(
                startX,
                startY,
                stopX,
                stopY,
                paint
            )

            CIRCLE -> {
                var radius = Math.sqrt(
                    Math.pow((stopX - startX).toDouble(), 2.0)
                            + Math.pow((stopY - startY).toDouble(), 2.0)
                )
                canvas.drawCircle(startX, startY, radius.toFloat(), paint)
            }

            RECTANGLE -> {
                val left = Math.min(startX, stopX)
                val right = Math.max(startX, stopX)
                val top = Math.min(startY, stopY)
                val bottom = Math.max(startY, stopY)
                canvas.drawRect(
                    left,
                    top,
                    right,
                    bottom,
                    paint
                )
            }

            TRIANGLE -> {
                val path = Path()
                path.moveTo((startX + stopX) / 2, startY)
                path.lineTo(stopX, stopY)
                path.lineTo(startX, stopY)
                path.close()
                canvas.drawPath(path, paint)
            }

        }
    }
}

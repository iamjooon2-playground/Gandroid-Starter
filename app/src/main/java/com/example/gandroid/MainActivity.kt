package com.example.gandroid

import android.graphics.Color
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.Chronometer
import android.widget.RadioButton
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var chronometer: Chronometer
    lateinit var buttonStart: Button
    lateinit var buttonEnd: Button
    lateinit var radioCalender: RadioButton
    lateinit var radioTime: RadioButton
    lateinit var calenderView: CalendarView
    lateinit var timePicker: TimePicker
    lateinit var textViewYear: TextView
    lateinit var textViewMonth: TextView
    lateinit var textViewDay: TextView
    lateinit var textViewHour: TextView
    lateinit var textViewMinute: TextView

    var selectYear = 0
    var selectMonth = 0
    var selectDay = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewByIds()

        timePicker.visibility = View.INVISIBLE
        calenderView.visibility = View.INVISIBLE

        setOnClickListeners()

        showActionBar()
    }

    private fun setOnClickListeners() {
        radioCalender.setOnClickListener {
            calenderView.visibility = View.VISIBLE
            timePicker.visibility = View.INVISIBLE
        }

        radioTime.setOnClickListener {
            timePicker.visibility = View.VISIBLE
            calenderView.visibility = View.INVISIBLE
        }

        buttonStart.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime()
            chronometer.start()
            chronometer.setTextColor(Color.RED)
        }

        buttonEnd.setOnClickListener {
            chronometer.stop()
            chronometer.setTextColor(Color.BLUE)

            textViewYear.text = selectYear.toString()
            textViewMonth.text = selectMonth.toString()
            textViewDay.text = selectDay.toString()

            textViewHour.text = timePicker.hour.toString()
            textViewMinute.text = timePicker.minute.toString()
        }

        calenderView.setOnDateChangeListener { calendarView, year, month, dayOfMonth ->
            selectYear = year
            selectMonth = month + 1
            selectDay = dayOfMonth
        }
    }

    private fun findViewByIds() {
        title = "이준희의 시간 예약"

        buttonStart = findViewById(R.id.buttonStart)
        buttonEnd = findViewById(R.id.buttonEnd)

        chronometer = findViewById(R.id.chronometer)

        radioCalender = findViewById(R.id.radioCalender)
        radioTime = findViewById(R.id.radioTime)

        timePicker = findViewById(R.id.timePicker)
        calenderView = findViewById(R.id.calenderView)

        textViewYear = findViewById(R.id.textViewYear)
        textViewMonth = findViewById(R.id.textViewMonth)
        textViewDay = findViewById(R.id.textViewDay)
        textViewHour = findViewById(R.id.textViewHour)
        textViewMinute = findViewById(R.id.textViewMinute)
    }

    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher_background)
        supportActionBar?.setIcon(R.drawable.ic_launcher_foreground)
    }
}
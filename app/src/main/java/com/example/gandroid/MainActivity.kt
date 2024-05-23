package com.example.gandroid

import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    lateinit var datePicker : DatePicker
    lateinit var editDiary: EditText
    lateinit var writeButton : Button
    lateinit var fileName : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "이준희의 간단 일기장"

        datePicker = findViewById(R.id.datePicker)
        editDiary = findViewById(R.id.editDiary)
        writeButton = findViewById(R.id.buttonWrite)

        var cal = Calendar.getInstance()
        var year = cal.get(Calendar.YEAR)
        var month = cal.get(Calendar.MONTH)
        var day = cal.get(Calendar.DAY_OF_MONTH)

        datePicker.init(year, month, day) { view, year, monthOfYear, dayOfMonth ->
            // 달도 0달부터 세나?
            fileName = Integer.toString(year) + "_" + Integer.toString(monthOfYear + 1) + "_" + Integer.toString(dayOfMonth) + ".txt"
            var str = readDiary(fileName)
            editDiary.setText(str)
            writeButton.isEnabled = true
        }

        showActionBar()
    }

    private fun readDiary(fileName : String) : String ? {
        return null;
    }

    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher_background)
        supportActionBar?.setIcon(R.drawable.ic_launcher_foreground)
    }
}
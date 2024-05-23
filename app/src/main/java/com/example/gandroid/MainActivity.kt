package com.example.gandroid

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.io.FileInputStream
import java.io.IOException
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    lateinit var datePicker : DatePicker
    lateinit var editText: EditText
    lateinit var writeButton : Button
    lateinit var fileName : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "이준희의 간단 일기장"

        datePicker = findViewById(R.id.datePicker)
        editText = findViewById(R.id.editDiary)
        writeButton = findViewById(R.id.buttonWrite)

        var cal = Calendar.getInstance()
        var year = cal.get(Calendar.YEAR)
        var month = cal.get(Calendar.MONTH)
        var day = cal.get(Calendar.DAY_OF_MONTH)

        datePicker.init(year, month, day) { view, year, monthOfYear, dayOfMonth ->
            // 달도 0달부터 세나?
            fileName = Integer.toString(year) + "_" + Integer.toString(monthOfYear + 1) + "_" + Integer.toString(dayOfMonth) + ".txt"
            var str = readDiary(fileName)
            editText.setTextColor(t)
        }

        writeButton.setOnClickListener {
            var outFs = openFileOutput(fileName, Context.MODE_PRIVATE)
            var str = writeButton.text.toString()

            outFs.write(str.toByteArray())
            outFs.close()

            // 토스트 메시지 띄우기
        }

        showActionBar()
    }

    private fun readDiary(fileName : String) : String ? {
        var diaryString : String? = null
        var inFs : FileInputStream

        try {
            inFs = openFileInput(fileName)
            var txt = ByteArray(500)
            inFs.read(txt)
            inFs.close()
            diaryString = txt.toString(Charsets.UTF_8).trim()
        } catch (e : IOException) {
            editText.hint = "일기 없음"
            writeButton.text = "새로 저장"
        }
        return diaryString;
    }



    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher_background)
        supportActionBar?.setIcon(R.drawable.ic_launcher_foreground)
    }
}
package com.example.gandroid

import android.content.Context
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
            Context.MODE_PRIVATE
        )
        title = "파일 계층 구조"

        var buttonList: Button
        var editFileList: EditText

        buttonList = findViewById<Button>(R.id.buttonFileList)
        editFileList = findViewById<EditText>(R.id.editFileList)

        buttonList.setOnClickListener {
            var sysDir = Environment.getRootDirectory().absolutePath
            var sysFiles = File(sysDir).listFiles()

            var strFileName: String
            for (i in sysFiles.indices) {
                if (sysFiles[i].isDirectory) {
                    strFileName = "<폴더> : " + sysFiles[i].toString()
                } else {
                    strFileName = "<파일> : " + sysFiles[i].toString()
                }
                editFileList.setText(editFileList.text.toString() + "\n" + strFileName)
            }
        }

        showActionBar()
    }

    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher_background)
        supportActionBar?.setIcon(R.drawable.ic_launcher_foreground)
    }
}
package com.example.gandroid

import android.content.Context
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.io.File
import java.io.FileInputStream

class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
            Context.MODE_PRIVATE
        )

        var readButton = findViewById<Button>(R.id.readButton)
        var editSD = findViewById<EditText>(R.id.editSd)

        var makeButton = findViewById<Button>(R.id.makeButton)
        var deleteButton = findViewById<Button>(R.id.deleteButton)

        var strSDpath = Environment.getExternalStorageDirectory().absolutePath
        var myDirectory = File("$strSDpath/mydir")

        readButton.setOnClickListener {
            var inFs = FileInputStream("/storage/emulated/0/sd_test.txt")
            var txt = ByteArray(inFs.available())
            inFs.read(txt)
            editSD.setText(txt.toString(Charsets.UTF_8))
            inFs.close()
        }

        makeButton.setOnClickListener {
            myDirectory.mkdir()
        }

        deleteButton.setOnClickListener {
            myDirectory.delete()
        }

        showActionBar()
    }

    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher_background)
        supportActionBar?.setIcon(R.drawable.ic_launcher_foreground)
    }
}
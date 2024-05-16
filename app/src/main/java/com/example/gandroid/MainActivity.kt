package com.example.gandroid

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val SUBMIT = "확인"
    private val CANCEL = "취소"

    lateinit var textViewName: TextView;
    lateinit var textViewEmail: TextView;
    lateinit var button: TextView;
    lateinit var dialogEditName: EditText;
    lateinit var dialogEditEmail: EditText;
    lateinit var toastText: TextView;
    lateinit var dialogView: View;
    lateinit var toastView: View;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "이준희의 사용자 정보 입력"

        textViewName = findViewById(R.id.tvName)
        textViewEmail = findViewById(R.id.tvEmail)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            dialogView = View.inflate(this@MainActivity, R.layout.dialog, null)
            var dialog = AlertDialog.Builder(this@MainActivity)

            dialog.setTitle("사용자 정보 입력")
            dialog.setIcon(R.drawable.people)
            dialog.setView(dialogView)

            dialog.setPositiveButton(SUBMIT) { dialog, index ->
                dialogEditName = dialogView.findViewById<EditText>(R.id.dialogEdit1)
                dialogEditEmail = dialogView.findViewById<EditText>(R.id.dialogEdit2)
                textViewName.text = dialogEditName.text.toString()
                textViewEmail.text = dialogEditEmail.text.toString()
            }

            dialog.setNegativeButton(CANCEL) { dialog, index ->
                var toast = Toast(this@MainActivity)
                toastView = View.inflate(this@MainActivity, R.layout.toast, null)

                toastText = toastView.findViewById(R.id.toastText)
                toastText.text = "취소했습니다"

                toast.view = toastView

                toast.show()
            }

            dialog.show()
        }

        showActionBar()
    }

    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher_background)
        supportActionBar?.setIcon(R.drawable.ic_launcher_foreground)
    }
}
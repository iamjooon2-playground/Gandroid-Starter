package com.example.gandroid

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // internal : 같은 모듈 안에서만 생성 가능
    lateinit internal var edit1: EditText;
    lateinit internal var edit2: EditText;

    lateinit internal var buttonAdd: Button;
    lateinit internal var buttonSub: Button;
    lateinit internal var buttonMul: Button;
    lateinit internal var buttonDiv: Button;

    lateinit internal var textResult: TextView;
    lateinit internal var num1: String
    lateinit internal var num2: String

    internal var result: Int? = null

    internal var numButtons = ArrayList<Button>(10)

    internal var numButtonIds = arrayOf(
        R.id.button0,
        R.id.button1,
        R.id.button2,
        R.id.button3,
        R.id.button4,
        R.id.button5,
        R.id.button6,
        R.id.button7,
        R.id.button8,
        R.id.button9
    )

    // 증가값 용도
    internal var increase : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "테이블 레이아웃 계산기"

        initialize()
        setOnTouchListeners()

        for (i in 0..9) {
            numButtons.add(findViewById(numButtonIds[i]))
        }

        for (i in 0..numButtonIds.size - 1) {
            numButtons[i].setOnClickListener {
                if (edit1.isFocused) {
                    num1 = edit1.text.toString() + numButtons[i].getText().toString()
                    edit1.setText(num1)
                } else if (edit2.isFocused) {
                    num2 = edit2.text.toString() + numButtons[i].getText().toString()
                    edit2.setText(num2)
                } else {
                    Toast.makeText(applicationContext, "먼저 에디트텍스트를 선택하세요",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }

        showActionBar()
    }

    private fun setOnTouchListeners() {
        buttonAdd.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()

            result = Integer.parseInt(num1) + Integer.parseInt(num2)
            textResult.text = "계산 결과: " + result.toString()
            false
        }

        buttonMul.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()

            result = Integer.parseInt(num1) * Integer.parseInt(num2)
            textResult.text = "계산 결과: " + result.toString()
            false
        }

        buttonSub.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()

            result = Integer.parseInt(num1) - Integer.parseInt(num2)
            textResult.text = "계산 결과: " + result.toString()
            false
        }

        buttonDiv.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()

            result = Integer.parseInt(num1) / Integer.parseInt(num2)
            textResult.text = "계산 결과: " + result.toString()
            false
        }
    }

    private fun initialize() {
        edit1 = findViewById(R.id.Edit1)
        edit2 = findViewById(R.id.Edit2)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonMul = findViewById(R.id.buttonMultiply)
        buttonDiv = findViewById(R.id.buttonDivide)
        buttonSub = findViewById(R.id.buttonSubstract)
        textResult = findViewById(R.id.TextResult)
    }

    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher_background)
        supportActionBar?.setIcon(R.drawable.ic_launcher_foreground)
    }
}
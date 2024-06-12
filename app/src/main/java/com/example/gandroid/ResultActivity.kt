package com.example.gandroid

import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)
        title = "투표 결과"

        var intent = intent
        var voteResult = intent.getIntArrayExtra("VoteCount")
//        var imageName = intent.getStringArrayExtra("ImageName")
        var imageName = intent.getStringArrayExtra("ImageName") ?: emptyArray()

        // 텍스트 뷰 9개와 RatingBar
        var tv = arrayOfNulls<TextView>(imageName.size)
        var rbar = arrayOfNulls<RatingBar>(imageName.size)

        //
        var tvId = arrayOf(
            R.id.tv1,
            R.id.tv2,
            R.id.tv3,
            R.id.tv4,
            R.id.tv5,
            R.id.tv6,
            R.id.tv7,
            R.id.tv8,
            R.id.tv9,
        )

        var rbarId = arrayOf(
            R.id.rabar1,
            R.id.rabar2,
            R.id.rabar3,
            R.id.rabar4,
            R.id.rabar5,
            R.id.rabar6,
            R.id.rabar7,
            R.id.rabar8,
            R.id.rabar9,
        )

        for (i in voteResult!!.indices) {
            tv[i] = findViewById<TextView>(tvId[i])
            rbar[i] = findViewById<RatingBar>(rbarId[i])
        }

        for (i in voteResult.indices) {
            tv[i]!!.setText(imageName[i])
            rbar[i]!!.setRating(voteResult[i].toFloat())
        }

        var buttonReturn = findViewById<Button>(R.id.buttonReturn)
        buttonReturn.setOnClickListener {
            finish()
        }
    }

}
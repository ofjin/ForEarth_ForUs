package com.aiden.tflite.tfliteimageclassifier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Stamp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stamp)

        // 히스토리 버튼 클릭 시
        val historyBtn = findViewById<ImageView>(R.id.history_btn)

        historyBtn.setOnClickListener {
            val intent = Intent(this, history::class.java)
            startActivity(intent)
        }

    }
}
package com.aiden.tflite.tfliteimageclassifier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home_test.*
import kotlinx.android.synthetic.main.activity_store_main.*

class StoreMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_main)
        // 뒤로가기 back
        back.setOnClickListener{
            startActivity(Intent(this,Home::class.java))
        }
    }
}
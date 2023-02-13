package com.aiden.tflite.tfliteimageclassifier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PurchaselistActivity : AppCompatActivity() {

    //사용 확인 버튼 선언
    private lateinit var btn_confirm: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchaselist)
    }
}
package com.aiden.tflite.tfliteimageclassifier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ListItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_item)

        val btn_confirm=findViewById<Button>(R.id.textResult)
        btn_confirm.setOnClickListener {
            startActivity(Intent(this@ListItem,Dialogcamera_plastic::class.java))
        }
    }
}
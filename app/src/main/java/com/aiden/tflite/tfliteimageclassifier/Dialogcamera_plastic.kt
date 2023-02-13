package com.aiden.tflite.tfliteimageclassifier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Dialogcamera_plastic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialogcamera_plastic)

        val back_camera=findViewById<ImageButton>(R.id.back_camera)
        back_camera.setOnClickListener {
            startActivity(Intent(this@Dialogcamera_plastic,CameraActivity::class.java))
        }
    }
}
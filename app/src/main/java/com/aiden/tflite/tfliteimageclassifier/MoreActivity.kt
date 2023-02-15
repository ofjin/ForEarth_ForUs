package com.aiden.tflite.tfliteimageclassifier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)

        //네비게이션  바
        val homeCameraView = findViewById<ImageButton>(R.id.home)
        val cameraCameraView = findViewById<ImageButton>(R.id.camera)
        val earthCameraView = findViewById<ImageButton>(R.id.earth)
        val pointCameraView = findViewById<ImageButton>(R.id.point)

        homeCameraView.setOnClickListener{
            startActivity(Intent(this,Home::class.java))
        }
        cameraCameraView.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
        earthCameraView.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
        pointCameraView.setOnClickListener{
            startActivity(Intent(this,StoreMain::class.java))
        }
    }
}
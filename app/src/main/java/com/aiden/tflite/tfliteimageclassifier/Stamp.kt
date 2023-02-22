package com.aiden.tflite.tfliteimageclassifier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
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
        //네비게이션  바
        val homeCameraView = findViewById<ImageButton>(R.id.home)
        val cameraCameraView = findViewById<ImageButton>(R.id.camera)
        val earthCameraView = findViewById<ImageButton>(R.id.earth)
        val pointCameraView = findViewById<ImageButton>(R.id.point)
        val moreView = findViewById<ImageButton>(R.id.more)

        homeCameraView.setOnClickListener{
            startActivity(Intent(this,Home::class.java))
        }
        cameraCameraView.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
        earthCameraView.setOnClickListener{
            startActivity(Intent(this,ScanActivity::class.java))
        }
        pointCameraView.setOnClickListener{
            startActivity(Intent(this,StoreMain::class.java))
        }
        moreView.setOnClickListener{
            startActivity(Intent(this,MoreActivity::class.java))
        }

    }
}
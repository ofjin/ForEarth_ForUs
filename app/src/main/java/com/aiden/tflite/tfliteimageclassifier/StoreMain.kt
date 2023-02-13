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
        //상세페이지로 이동
        y_garbage2.setOnClickListener{
            startActivity(Intent(this,StoreDetail_garbagebag1::class.java))
        }
        y_garbage3.setOnClickListener{
            startActivity(Intent(this,StoreDetail_garbagebag2::class.java))
        }
        y_garbage5.setOnClickListener{
            startActivity(Intent(this,StoreDetail_garbagebag3::class.java))
        }
        w_garbage10.setOnClickListener{
            startActivity(Intent(this,StoreDetail_garbagebag4::class.java))
        }
        w_garbage20.setOnClickListener{
            startActivity(Intent(this,StoreDetail_garbagebag5::class.java))
        }
        w_garbage50.setOnClickListener{
            startActivity(Intent(this,StoreDetail_garbagebag1::class.java))
        }
        bag.setOnClickListener{
            startActivity(Intent(this,StoreDetail_bag::class.java))
        }
        eco_bag.setOnClickListener{
            startActivity(Intent(this,StoreDetail_ecobag::class.java))
        }
        sticker1000.setOnClickListener{
            startActivity(Intent(this,StoreDetail_sticker1::class.java))
        }
        sticker2000.setOnClickListener{
            startActivity(Intent(this,StoreDetail_sticker2::class.java))
        }
        sticker3000.setOnClickListener{
            startActivity(Intent(this,StoreDetail_sticker3::class.java))
        }
    }
}
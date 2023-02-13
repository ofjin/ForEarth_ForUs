
package com.aiden.tflite.tfliteimageclassifier

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home_test.*


class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_test)

        val home=findViewById<ImageButton>(R.id.home)
        val camera=findViewById<ImageButton>(R.id.camera)
        val earth=findViewById<ImageButton>(R.id.earth)
        val point=findViewById<ImageButton>(R.id.point)

        //네비게이션  바
        home.setOnClickListener{
            startActivity(Intent(this,Home::class.java))
        }
        camera.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
        earth.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
        point.setOnClickListener{
            startActivity(Intent(this,StoreMain::class.java))
        }


        // 뉴스 URL 연결
        val news_link1 = findViewById<ImageButton>(R.id.news_link1)

        news_link1.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yna.co.kr/view/AKR20220930175700003"))
            startActivity(intent)
        }
    }

}
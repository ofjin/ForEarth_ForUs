
package com.aiden.tflite.tfliteimageclassifier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home_test.*


class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_test)

        //히스토리 버튼
        history_button.setOnClickListener{
            startActivity(Intent(this,history::class.java))
        }

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

    }

}
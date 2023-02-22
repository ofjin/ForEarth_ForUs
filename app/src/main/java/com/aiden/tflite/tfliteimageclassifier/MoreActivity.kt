package com.aiden.tflite.tfliteimageclassifier

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.core.view.View
import kotlinx.android.synthetic.main.activity_more.*


class MoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)

        //로그아웃 코드
        lateinit var auth:FirebaseAuth
        auth = FirebaseAuth.getInstance()
        TV_appVer.setOnClickListener {
            //firebase auth에서 sign out 기능 호출
            auth.signOut()
            var intent=Intent(this,SigninActivity::class.java) //로그인 페이지 이동
            startActivity(intent)
            this?.finish()
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
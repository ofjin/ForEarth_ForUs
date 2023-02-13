
package com.aiden.tflite.tfliteimageclassifier

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_home_test.*
import kotlinx.android.synthetic.main.activity_home_test.camera
import kotlinx.android.synthetic.main.activity_home_test.earth
import kotlinx.android.synthetic.main.activity_home_test.home
import kotlinx.android.synthetic.main.activity_home_test.point
import kotlinx.android.synthetic.main.activity_redeem_points.*


class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_test)
        //history 버튼
        history_button.setOnClickListener{
            startActivity(Intent(this,history::class.java))
        }
        //구매내역 버튼
        btn_purchaselist.setOnClickListener{
            startActivity(Intent(this,purchaselistActivity::class.java))
        }

        //네비게이션  바
        home.setOnClickListener{
            startActivity(Intent(this,Home::class.java))
        }
        camera.setOnClickListener{
            startActivity(Intent(this,CameraActivity::class.java))
        }
        earth.setOnClickListener{
            startActivity(Intent(this,ScanActivity::class.java))
        }
        point.setOnClickListener{
            startActivity(Intent(this,StoreMain::class.java))
        }

        val campaignLink1 = findViewById<ImageButton>(R.id.campaign_link1)
        val campaignLink2 = findViewById<ImageButton>(R.id.campaign_link2)
        val newsIMGLink1 = findViewById<ImageButton>(R.id.news_link1)
        val newsTitleLink1 = findViewById<TextView>(R.id.news_tile_link1)
        val newsIMGLink2 = findViewById<ImageButton>(R.id.news_link2)
        val newsTitleLink2 = findViewById<TextView>(R.id.news_tile_link2)


        campaignLink1.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://earthplogging.com/"))
            startActivity(intent)
        }

        campaignLink2.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.me.go.kr/home/web/board/read.do?pagerOffset=0&maxPageItems=10&maxIndexPages=10&searchKey=&searchValue=&menuId=&orgCd=&boardId=1449380&boardMasterId=713&boardCategoryId=&decorator="))
            startActivity(intent)
        }

        newsIMGLink1.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://n.news.naver.com/mnews/article/421/0006627145?sid=102"))
            startActivity(intent)
        }

        newsTitleLink1.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://n.news.naver.com/mnews/article/421/0006627145?sid=102"))
            startActivity(intent)
        }

        newsIMGLink2.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://n.news.naver.com/mnews/article/119/0002683348?sid=102"))
            startActivity(intent)
        }

        newsTitleLink2.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://n.news.naver.com/mnews/article/119/0002683348?sid=102"))
            startActivity(intent)
        }

    }

}
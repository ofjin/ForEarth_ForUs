package com.aiden.tflite.tfliteimageclassifier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() , BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavi.setOnNavigationItemSelectedListener(this)

        supportFragmentManager.beginTransaction().add(R.id.linearLayout, HomeFragment()).commit()
    }

    override fun onNavigationItemSelected(item: Menu): Boolean {

        when(item.home) {
            R.id.page_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.linearLayout , HomeFragment()).commitAllowingStateLoss()
                return true
            }
            R.id.page_tv -> {
                supportFragmentManager.beginTransaction().replace(R.id.linearLayout, TVFragment()).commitAllowingStateLoss()
                return true
            }
            R.id.page_calendar -> {
                supportFragmentManager.beginTransaction().replace(R.id.linearLayout, CalendarFragment()).commitAllowingStateLoss()
                return true
            }
        }

        return false
    }
}

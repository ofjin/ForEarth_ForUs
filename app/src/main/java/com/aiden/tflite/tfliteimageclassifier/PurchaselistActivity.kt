package com.aiden.tflite.tfliteimageclassifier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PurchaselistActivity : AppCompatActivity() {
    //사용 확인 버튼 선언
    private lateinit var btn_confirm: Button
    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchaselist)

        var rv_list=findViewById<RecyclerView>(R.id.rv_list)
        rv_list.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        val profileList= arrayListOf(
            profiles(R.drawable.garbagebag,"음식물 쓰레기봉투 (2L)","2022.11.26",1,"확인","190p"),
            profiles(R.drawable.trashbag,"일반용 쓰레기 봉투 (10L)","2022.11.27",2,"확인","150p")

        )
        rv_list.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv_list.setHasFixedSize(true)
        rv_list.adapter=profileAdaptor(profileList)

        btn_confirm.setOnClickListener {
            // 다이얼로그를 생성하기 위해 Builder 클래스 생성자를 이용해 줍니다.
            val builder = AlertDialog.Builder(this)
            builder.setTitle("확인 처리를 하시겠습니까?")
                .setMessage("메세지 내용 부분 입니다.")
            // 다이얼로그를 띄워주기
            builder.show()

        }
    }
}
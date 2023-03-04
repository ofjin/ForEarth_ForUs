package com.aiden.tflite.tfliteimageclassifier

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class purchaselistActivity : AppCompatActivity() {

    private var auth: FirebaseAuth =FirebaseAuth.getInstance()
    private lateinit var userDB: DatabaseReference // 다른데서 사용할 수 있어 변수로 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchaselist)

        userDB=Firebase.database.reference.child("Users")

        val currentUserDB=userDB.child(getCurrentUserID())
        currentUserDB.addListenerForSingleValueEvent(object :ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

            }

            override fun onCancelled(error: DatabaseError) {
            }

        })











        var rv_list =findViewById<RecyclerView>(R.id.rv_list)
        rv_list.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        val profileList= arrayListOf(
            profiles(R.drawable.garbagebag,"음식물 쓰레기봉투 (2L)","2022.11.26",1,"확인","190p"),
            profiles(R.drawable.trashbag,"일반용 쓰레기 봉투 (10L)","2022.11.27",2,"확인","150p")

        )
        rv_list.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rv_list.setHasFixedSize(true)
        rv_list.adapter=profileAdaptor(profileList)


    }

    private fun getCurrentUserID():String{      // 현재 userid 받아오는 함수 작성
        if(auth.currentUser==null){
            Toast.makeText(this,"로그인이 되어있지 않습니다",Toast.LENGTH_SHORT).show()
            finish()
        }
        return auth.currentUser?.uid.orEmpty()
    }
}
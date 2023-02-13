package com.aiden.tflite.tfliteimageclassifier

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_signin.*

class SigninActivity : AppCompatActivity() {
    private var auth : FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        auth = Firebase.auth


// 회원가입 창으로
        btn_register.setOnClickListener{
            startActivity(Intent(this,Signup::class.java))
        }

// 로그인 버튼
        bnt_login.setOnClickListener{
            signIn(edit_id.text.toString(),edit_pw.text.toString())
        }
    }

    // 로그아웃하지 않을 시 자동 로그인 , 회원가입시 바로 로그인 됨
    public override fun onStart() {
        super.onStart()
        moveMainPage(auth?.currentUser)
    }

    // 로그인
    private fun signIn(email: String, password: String) {

        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth?.signInWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(this){task->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            baseContext, "로그인에 성공 하였습니다.",
                            Toast.LENGTH_SHORT
                        ).show()
                        moveMainPage(auth?.currentUser)
                    } else {
                        Toast.makeText(
                            baseContext, "로그인에 실패 하였습니다.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }

    // 유저정보 넘겨주고 메인 액티비티 호출
    private fun moveMainPage(user: FirebaseUser?){
        if( user!= null){
            startActivity(Intent(this,Home::class.java))
            handleSuccessLogin()
        }
    }
    private fun handleSuccessLogin() {
        // TODO 파이어베이스에 로그인 정보를 리얼타임 데이터베이스에 저장해야함
        // uid값 저장

        if( auth?.currentUser == null) {
            Toast.makeText(this,"로그인 정보가 올바르지 않습니다",Toast.LENGTH_SHORT).show()
            finish()
        }

        val userUid = auth?.currentUser?.uid.orEmpty() // null일시 빈값으로 변경
        val currentDB = Firebase.database.reference.child("Users").child(userUid)
        val userInfoMap = mutableMapOf<String,Any>()
        userInfoMap["userId"] = userUid
        currentDB.updateChildren(userInfoMap)

        val likeActivityIntent = Intent(this,history::class.java)
        startActivity(likeActivityIntent)
    }


}



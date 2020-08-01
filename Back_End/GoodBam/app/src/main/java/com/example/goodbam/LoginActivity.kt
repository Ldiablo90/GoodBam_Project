package com.example.goodbam

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 로그인 버튼 누를시
        login_btn_login.setOnClickListener {
            Toast.makeText(applicationContext, "아직 미구현", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        // 회원가입(sign_up)버튼 누를시
        login_btn_signup.setOnClickListener {
            // 회원가입 페이지로 이동
            var intent = Intent(this, Signup1Activity::class.java)
            startActivity(intent)
        }
        // 회원찾기 버튼 누를 시
        login_btn_find.setOnClickListener {
            // 회원찾기 페이지로 이동
            var intent = Intent(this, IDsearchkActivity::class.java)
            startActivity(intent)
        }
    }
}
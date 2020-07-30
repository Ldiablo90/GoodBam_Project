package com.example.goodbam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_sign_up2.*
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class Signup2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)

        val userID = intent.getStringExtra("userID")
        val userPass = intent.getStringExtra("userPass")
        val userName = intent.getStringExtra("userName")
        val userQue = "signup2_spinner.get().toString()"
        val userAns = signup2_et_answer.text.toString()
        // 뒤로가기
        signup2_btn_back.setOnClickListener {
            var intent = Intent(this, Signup1Activity::class.java)
            startActivity(intent)
        }
        signup2_btn_signup.setOnClickListener {



            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
    fun Signup(userID:String, userPass:String, userName:String, userQue:String, userAns:String):String{
        var enconame = URLEncoder.encode(userName, "UTF-8")
        var encoque = URLEncoder.encode(userQue, "UTF-8")
        var encoans = URLEncoder.encode(userAns, "UTF-8")
        val url = URL("http://해당주소 쓰기:포트번호/매핑할이름?userID=$userID userPass=$userPass userName=$enconame userQue=$encoque userAns=$encoans")
        val conn = url.openConnection() as HttpURLConnection

        if(conn.responseCode == 200){
            val txt = url.readText()
            return "$txt"
        }
        else{
            return "fall"
        }
    }
}
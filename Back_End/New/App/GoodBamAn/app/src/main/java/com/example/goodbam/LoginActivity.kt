package com.example.goodbam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import java.net.HttpURLConnection
import java.net.URL
import com.example.goodbam.Static.Companion.server_url

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //로그인 버튼
        login_btn_login.setOnClickListener{
            var tmp:String = ""
            Log.i("testLog","loginclick u:${login_et_id.text} p:${login_et_pw.text}")
            Thread(){
                tmp = login("${login_et_id.text}","${login_et_pw.text}")
                runOnUiThread {
                    if(tmp.equals("로그인 성공")){
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)

                    }
                    else{
                        Toast.makeText(this,"$tmp",Toast.LENGTH_SHORT).show()
                    }
                }
            }.start()
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
            var intent = Intent(this, SearchIDActivity::class.java)
            startActivity(intent)
        }





    }

    fun login(userID:String, userPW:String):String{
        val url = URL("${server_url}/login?userID=${userID}&userPW=${userPW}")
        val conn = url.openConnection() as HttpURLConnection //casting
        Log.i("testLog","conn.responseCode : ${conn.responseCode}")

        if(conn.responseCode == 200){
            val txt:String = url.readText()

            return "${txt}"
        } else return "null"


    }



}
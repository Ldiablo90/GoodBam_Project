package com.example.goodbam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
            Log.i("testlog","signup2 btn")

            Thread(){
                var checke:String = Signup("$userID","$userPass","$userName","$userQue","$userAns")
                runOnUiThread{
                    Log.i("testlog","$checke")
                }
            }.start()


            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
    fun Signup(userID:String, userPass:String, userName:String, userQue:String, userAns:String):String{
        val url = URL("http://192.168.0.66:8090/SignUp?userID=${userID}&userPass=${userPass}&userName=${userName}&userQue=${userQue}&userAns=${userAns}")
        val conn = url.openConnection() as HttpURLConnection
        Log.i("testlog","${conn.responseCode}")
        if(conn.responseCode == 200){
            val txt = url.readText()
            return "$txt"
        }
        else{
            return "fall"
        }
    }
}
package com.example.goodbam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_sign_up2.*
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import com.example.goodbam.Static.Companion.server_url

class Signup2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)

        val userID = intent.getStringExtra("userID")
        val userPass = intent.getStringExtra("userPass")
        val userName = intent.getStringExtra("userName")
        val spinner:Spinner = findViewById(R.id.signup2_et_quest)

        // 뒤로가기
        signup2_btn_back.setOnClickListener {
            var intent = Intent(this, Signup1Activity::class.java)
            startActivity(intent)
        }

        signup2_btn_signup.setOnClickListener {
            Log.i("testlog","signup2 btn")
            val userQue = spinner.selectedItem.toString()
            val userAns = signup2_et_answer.text.toString()
            var check:String = ""
            Thread(){
                 check = signup(userID.toString(),userPass.toString(),userName.toString(),userQue,userAns)
//                check = Signup("$userID","$userPass","$userName","$userQue","$userAns")
                runOnUiThread{
                    Log.i("testlog","$check")
                    if(check.equals("회원가입 성공")){
                        Toast.makeText(this,check,Toast.LENGTH_SHORT).show()
                        var intent = Intent(this, Login2Activity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,check,Toast.LENGTH_SHORT).show()
                    }

                }
            }.start()

        }
    }
    fun signup(userID:String, userPass:String, userName:String, userQue:String, userAns:String):String{
        val url = URL("${server_url}/SignUp?userID=${userID}&userPass=${userPass}&userName=${userName}&userQue=${userQue}&userAns=${userAns}")
        val conn = url.openConnection() as HttpURLConnection
//        Log.i("testlog","${conn.responseCode}")
//        if(conn.responseCode == 200){
//            val txt = url.readText()
//
//            return "${txt}"
//        }
//        else{
//            return "null"
//    }
        val txt = url.readText()
        return txt
    }

}
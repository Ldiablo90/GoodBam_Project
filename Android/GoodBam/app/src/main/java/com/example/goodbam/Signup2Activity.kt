package com.example.goodbam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_sign_up2.*
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class Signup2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)




        // 뒤로가기
        signup2_btn_back.setOnClickListener {
            var intent = Intent(this, Signup1Activity::class.java)
            startActivity(intent)
        }
        // 회원가입 확인 버튼
        signup2_btn_signup.setOnClickListener {
            val userID = intent.getStringExtra("userID")
            val userPass = intent.getStringExtra("userPass")
            val userName = intent.getStringExtra("userName")
            val userQue = signup2_spinner.selectedItem.toString()
            val userAns = signup2_et_answer.text.toString()

            Thread(){
                var checke:Int = Signup("$userID","$userPass","$userName","$userQue","$userAns")
                runOnUiThread{
                    // 정상적으로 실행되었는지 확인
                    if(checke == 200){
                        Toast.makeText(this,"화원가입을 축하드립니다.",Toast.LENGTH_SHORT).show()
                        var intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"화원가입이 안되었습니다.",Toast.LENGTH_SHORT).show()
                    }
                }
            }.start()
        }
    }
    fun Signup(userID:String, userPass:String, userName:String, userQue:String, userAns:String):Int{
        val url = URL("http://15.165.223.98:8090/SignUp?userID=${userID}&userPass=${userPass}&userName=${userName}&userQue=${userQue}&userAns=${userAns}")
        val conn = url.openConnection() as HttpURLConnection
        return conn.responseCode
    }
}
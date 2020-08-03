package com.example.goodbam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up1.*
import java.net.HttpURLConnection
import java.net.URL

class Signup1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up1)

        var idCheck:Int = 0
        // 뒤로가기 버튼
        signup_btn_back.setOnClickListener {
            Toast.makeText(this,"뒤로가기",Toast.LENGTH_SHORT).show()
            var intent = Intent(this, Login2Activity::class.java)
            startActivity(intent)
        }
        // 아이디 중복검사 체크하기
        signup_btn_idcheck.setOnClickListener {
            var tmp:String = ""

            Log.i("testLog","idCheckClick u:${signup_et_id.text}")
            Thread(){
                tmp = idCheck("${signup_et_id.text}")
                runOnUiThread {
                    if(tmp.equals("사용가능한 ID")){
                        Toast.makeText(this,tmp,Toast.LENGTH_SHORT).show()
                        idCheck = 1
                    }else{
                        Toast.makeText(this,tmp,Toast.LENGTH_SHORT).show()
                        idCheck = -1
                    }


                }

            }.start()

        }

        signup_btn_next.setOnClickListener {
            // 데이터베이스에 저장할 속성값 id,password,name
            var userID = signup_et_id.text.toString()
            var userPass = signup_et_pw1.text.toString()
            var userPass2:String = signup_et_pw2.text.toString()
            var userName = signup_et_name.text.toString()

            if((idCheck==1)&&(userPass == userPass2)){
                var intent = Intent(this, Signup2Activity::class.java)
                // 넘겨주는 엑티비티에게 값을 넘겨주기
                intent.putExtra("userID",userID)
                intent.putExtra("userPass",userPass)
                intent.putExtra("userName",userName)
                startActivity(intent)
            }else if(idCheck==0){
                Toast.makeText(this,"아이디 중복 확인을 눌러주세요",Toast.LENGTH_SHORT).show()
            }else if(idCheck==-1){
                Toast.makeText(this,"중복된 아이디입니다.",Toast.LENGTH_SHORT).show()
            }else if((idCheck==1)&&(userPass!=userPass2)){
                    Toast.makeText(this,"비밀번호를 확인해 주세요.",Toast.LENGTH_SHORT).show()
            }



        }
    }



    fun idCheck(userID:String):String{
        val url = URL("${Static.server_url}/idCheck?userID=${userID}")
        val conn = url.openConnection() as HttpURLConnection //casting
        Log.i("testLog","conn.responseCode : ${conn.responseCode}")

        if(conn.responseCode == 200){
            val txt:String = url.readText()

            return "${txt}"
        } else return "null"


    }






}
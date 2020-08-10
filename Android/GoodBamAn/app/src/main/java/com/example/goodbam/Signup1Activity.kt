package com.example.goodbam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up1.*
import java.net.HttpURLConnection
import java.net.URL
import com.example.goodbam.Static.Companion.server_url
class Signup1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up1)

        var idCheck:Array<String> = Array(2,{""})

        // 뒤로가기 버튼
        signup_btn_back.setOnClickListener {
            Toast.makeText(this,"뒤로가기",Toast.LENGTH_SHORT).show()
            var intent = Intent(this, LoginActivity::class.java)
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
                        idCheck[0] = signup_et_id.text.toString()
                        idCheck[1] = signup_et_id.text.toString()
                        Log.i("testLog","idCheck : ${idCheck[0]}")
                    }else{
                        Toast.makeText(this,tmp,Toast.LENGTH_SHORT).show()
                        idCheck[0] = "중복된 ID"
                        idCheck[1] = signup_et_id.text.toString()
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
            if((userID != "")&&( userPass!= "")&&(userPass2 != "")&&(userName != "")) {
                if ((idCheck[0] == userID) && (userPass == userPass2)) {
                    var intent = Intent(this, Signup2Activity::class.java)
                    // 넘겨주는 엑티비티에게 값을 넘겨주기
                    intent.putExtra("userID", userID)
                    intent.putExtra("userPass", userPass)
                    intent.putExtra("userName", userName)
                    startActivity(intent)
                } else if (idCheck[0] == "중복된 ID"&&idCheck[1] == userID) {
                    Toast.makeText(this, "중복된 아이디입니다.", Toast.LENGTH_SHORT).show()
                } else if (idCheck[0] == "" || idCheck[1] != userID){
                    Toast.makeText(this,"아이디 중복 확인을 해주세요",Toast.LENGTH_SHORT).show()
                } else if ((userPass != userPass2)) {
                    Toast.makeText(this, "비밀번호를 확인해 주세요.", Toast.LENGTH_SHORT).show()
                } else if (userName == null) {
                    Toast.makeText(this, "이름을 입력해 주세요.", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this,"빈칸이 있습니다.",Toast.LENGTH_SHORT).show()
            }


        }
    }



    fun idCheck(userID:String):String{
        val url = URL("${server_url}/idCheck?userID=${userID}")
        val conn = url.openConnection() as HttpURLConnection //casting
            val txt:String = url.readText()
            return "${txt}"

    }






}
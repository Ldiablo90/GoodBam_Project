package com.example.goodbam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up1.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class Signup1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up1)

        var idbool = false


        // 뒤로가기 버튼
        signup_btn_back.setOnClickListener {
            Toast.makeText(this,"뒤로가기",Toast.LENGTH_SHORT).show()
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


        // 아이디 중복검사 체크하기
        signup_btn_idcheck.setOnClickListener {
            var userID = signup_et_id.text.toString()
            Thread(){
                var idcheck = IdCheck(userID)
                if (userID.equals(idcheck)){
                    Toast.makeText(this,"이미 가입된 회원입니다.",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"가입할수 있는 아이디 입니다.",Toast.LENGTH_SHORT).show()
                    idbool = true
                }
            }

            Toast.makeText(this,"구현 준비중",Toast.LENGTH_SHORT).show()

        }
        // 아이디 및 페스워드 중복검사 해야됨
        signup_btn_next.setOnClickListener {
            Toast.makeText(this,"아이디체크및 비밀번호 체크",Toast.LENGTH_SHORT).show()
            // 데이터베이스에 저장할 속성값 id,password,name
            var userID = signup_et_id.text.toString()
            var userPass = signup_et_pw1.text.toString()
            var userName = signup_et_name.text.toString()
//            아직 구현안된 중복검사 구현 코드
            if(idbool){

                if (signup_et_pw1.text.equals(signup_et_pw2.text)){
                    var intent = Intent(this, Signup2Activity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"비밀번호 중복 체크 확인해주세요",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"아이디 확인 해주세요",Toast.LENGTH_SHORT).show()
            }

            var intent = Intent(this, Signup2Activity::class.java)
            // 넘겨주는 엑티비티에게 값을 넘겨주기
            intent.putExtra("userID",userID)
            intent.putExtra("userPass",userPass)
            intent.putExtra("userName",userName)
            startActivity(intent)
        }
    }
    fun IdCheck(userID:String):ArrayList<String>{
        var search:ArrayList<String> = arrayListOf()
        val url = URL("http://15.165.223.98:8090/IdSearch?userID=${userID}")
        var conn = url.openConnection() as HttpURLConnection

        // JSON형 튜플이 들어온다
        var userID = url.readText()
        // 들어온 값을 추출하기 위하여 JSON형태로 변환
        var jsonarr: JSONArray = JSONArray(userID)
        var obj: JSONObject = jsonarr.get(0) as JSONObject

        // JSON 형태를 조절하여 필요한 값만 추출
        search.add(obj["userID"].toString())
        return search
    }
}
package com.example.goodbam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pass_search.*
import java.net.HttpURLConnection
import java.net.URL

class PassSearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pass_search)

        // 로그인페이지로 돌아가기 버튼
        pass_search_btn_back.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        // 아이디찾기로 돌아가기 버튼
        pass_search_btn_id.setOnClickListener {
            var intent = Intent(this,IDsearchkActivity::class.java)
            startActivity(intent)
        }

        // 비밀번호 찾기
        pass_search_btn_find.setOnClickListener {

        }
    }
    fun idSearch(userName:String, userID:String, userQue:String, userAns:String):ArrayList<String>{
        val url = URL("http://192.168.0.66:8090/PassSearch?userID=${userID}&userName=${userName}&userQue=${userQue}&userAns=${userAns}")
        val conn = url.openConnection() as HttpURLConnection
        var search:ArrayList<String> = arrayListOf()

        val connet = conn.responseCode.toString()
        val userPass = url.readText()

        search.add(connet)
        search.add(userPass)

        return search
}
package com.example.goodbam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_id_search.*

class IDsearchkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_id_search)

        // 뒤로가기 버튼 누를 시
        id_search_btn_back.setOnClickListener {
            var intent = Intent(this,LoginActivity::class.java )
            startActivity(intent)
        }
        // 비밀번호 찾기로 이동 버튼
        id_search_btn_pass.setOnClickListener {
            var intent = Intent(this,PasssearchActivity::class.java )
            startActivity(intent)
        }
        // 아이디 찾기 버튼 누를시
        id_search_btn_find.setOnClickListener {
            Toast.makeText(this,"rate activity",Toast.LENGTH_SHORT).show()
        }
    }
    fun idSearch(userQue:String, userAns:String){

    }
}
package com.example.goodbam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_id_search.*
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

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
            var intent = Intent(this,PassSearchActivity::class.java )
            startActivity(intent)
        }
        // 아이디 찾기 버튼 누를시
        id_search_btn_find.setOnClickListener {
            Toast.makeText(this,"rate activity",Toast.LENGTH_SHORT).show()

            val userName = id_search_et_name.text.toString()
            val userQue = id_search_spinner.selectedItem.toString()
            val userAns = id_search_et_ans.text.toString()

            var intent = Intent(this,FindIDActivity::class.java)
            Thread(){
                val idsearch = idSearch(userName, userQue, userAns)
                runOnUiThread{
                    if(idsearch.get(0).equals("200")){
                        var obj:JSONObject = idsearch.get(1) as JSONObject
                        intent.putExtra("userID",obj["userID"].toString())
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"찾으신 정보가 없습니다.",Toast.LENGTH_SHORT).show()
                    }
                }
            }.start()
        }
    }
    fun idSearch(userName:String, userQue:String, userAns:String):ArrayList<String>{
        val url = URL("http://192.168.0.66:8090/IdSearch?userName=${userName}&userQue=${userQue}&userAns=${userAns}")
        val conn = url.openConnection() as HttpURLConnection
        var search:ArrayList<String> = arrayListOf()

        val connet = conn.responseCode.toString()
        val userID = url.readText()

        search.add(connet)
        search.add(userID)

        return search
    }
}
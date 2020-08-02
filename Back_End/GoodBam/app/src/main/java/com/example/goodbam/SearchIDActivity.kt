package com.example.goodbam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_id_search.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class SearchIDActivity : AppCompatActivity()  {
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
            var intent = Intent(this,SearchPassActivity::class.java )
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
                    Log.i("test","idsearch[0] : ${idsearch[0]}")
                    Log.i("test","idsearch[1] : ${idsearch[1]}")

                    // 성공적으로 찾게 되면
                    if(idsearch[0].equals("200") ){
                        intent.putExtra("userID",idsearch[1])
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"찾으신 정보가 없습니다.",Toast.LENGTH_SHORT).show()
                    }
                }
            }.start()
        }
    }
    fun idSearch(userName:String, userQue:String, userAns:String): ArrayList<String> {

        var search:ArrayList<String> = arrayListOf()
        val url = URL("http://172.30.1.36:8090/IdSearch?userName=${userName}&userQue=${userQue}&userAns=${userAns}")
        var conn = url.openConnection() as HttpURLConnection

        // 접속이 성공하면 200
        var connet = conn.responseCode.toString()
        // JSON형 튜플이 들어온다
        var userID = url.readText()


        var jsonarr:JSONArray = JSONArray(userID)
        var obj:JSONObject = jsonarr.get(0) as JSONObject
            // JSON 형태를 조절하여 필요한 값만 추출
        search.add(connet)
        search.add(obj["userID"].toString())
        return search

    }
}
package com.example.goodbam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pass_search.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread
import com.example.goodbam.Static.Companion.server_url

class SearchPassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pass_search)

        // 로그인페이지로 돌아가기 버튼
        pass_search_btn_back.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // 아이디찾기로 돌아가기 버튼
        pass_search_btn_id.setOnClickListener {
            val intent = Intent(this, SearchIDActivity::class.java)
            startActivity(intent)

        }

        // 비밀번호 찾기
        pass_search_btn_find.setOnClickListener {

            val userName = pass_search_et_name.text.toString()
            val userID = pass_search_et_id.text.toString()
            val userQue = pass_search_spinner.selectedItem.toString()
            val userAns = pass_search_et_ans.text.toString()


            Thread() {
                var list = PassSearch2(userName, userID, userQue, userAns)
                runOnUiThread {
                    if (list == "") {
                        Toast.makeText(this, "찾으신 정보가 없습니다.", Toast.LENGTH_SHORT).show()
                        var intent = Intent(this, SearchPassActivity::class.java)
                        startActivity(intent)
                    } else {
                        var intent = Intent(this, FindPassActivity::class.java)
                        intent.putExtra("userID", list)
                        startActivity(intent)

                    }
                }
            }.start()

        }
    }

    fun PassSearch(userName: String, userID: String, userQue: String, userAns: String): ArrayList<String> {
        val url = URL("${server_url}/SearchPass?userID=${userID}&userName=${userName}&userQue=${userQue}&userAns=${userAns}")
        val conn = url.openConnection() as HttpURLConnection
        var search: ArrayList<String> = arrayListOf()

        val connet = conn.responseCode.toString()
        val userPass = url.readText()

        var jsonarr = JSONArray(userPass)
        var obj:JSONObject = jsonarr.get(0) as JSONObject
        // JSON 형태를 조절하여 필요한 값만 추출
        search.add(connet)
        search.add(obj["userPass"].toString())

        return search
    }

    fun PassSearch2(userName: String, userID: String, userQue: String, userAns: String):String{
        val url = URL("${server_url}/SearchPass?userID=${userID}&userName=${userName}&userQue=${userQue}&userAns=${userAns}")
        val conn = url.openConnection() as HttpURLConnection

       val search = url.readText()

        return search
    }


}
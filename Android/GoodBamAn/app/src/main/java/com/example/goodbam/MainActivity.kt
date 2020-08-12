package com.example.goodbam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.goodbam.Static.Companion.server_url
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    private val handler: Handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread(){
            ondo()
        }.start()
        // 차트표로 이동 버튼
        main_btn_chart.setOnClickListener {
            var intent = Intent(this, ChartPageActivity::class.java)
            startActivity(intent)
//            Toast.makeText(this,"rate Activity",Toast.LENGTH_SHORT).show()
        }

        // 셋팅모드 이동 버튼
        main_btn_setting.setOnClickListener {
            Toast.makeText(this, "아직 미구현", Toast.LENGTH_SHORT).show()
        }


        // 나이트모드변환 버튼
        val txt = findViewById(R.id.check_night_mode) as TextView
        var ledSensor = -1
        main_btn_nightmode.setOnClickListener {
            var check_night_mode = check_night_mode.text.toString()
            if (check_night_mode.equals("나이트 모드 꺼짐")) {
                ledSensor = 1
                var tmp = ""
                Thread(){
                    tmp = switch(ledSensor.toString())
                    runOnUiThread{
                        if(tmp.equals("정상작동")){
                            Toast.makeText(this,tmp,Toast.LENGTH_SHORT).show()
                            txt.setText("나이트 모드 켜짐")
                        }
                    }
                }.start()
            } else if (check_night_mode.equals("나이트 모드 켜짐")) {
                ledSensor = 0
                var tmp = ""
                Thread(){
                    tmp = switch(ledSensor.toString())
                    runOnUiThread{
                        if(tmp.equals("정상작동")){
                            Toast.makeText(this,tmp,Toast.LENGTH_SHORT).show()
                            txt.setText("나이트 모드 꺼짐")
                        }
                    }
                }.start()
            }

        }
    }
    fun ondo(){
        //테스트 하려는 디바이스에서 브라우져를 열고
        //http://192.168.0.9/kotlinProject 주소 접속유무를 확인
        //안될시 와이파이 설정할것
        //http://192.168.0.9/kotlinProject/test.json
        val url = URL("${server_url}/ondoPrint")
        val conn = url.openConnection() as HttpURLConnection
        Log.i("testLog","conn.responseCode:${conn.responseCode}")

        if(conn.responseCode==200){
            println("=== url.readText() ===")
            val txt = url.readText()
            println(txt)

            //XML - DOM-문서전체읽은후
            //      SAX-문서를 읽으면서
            //      pull-편리 상수화

            //분석:데이터 파싱
            //JSON [,,]:Array, {"K":"V", , ,}:Object
            var t = ""
            var h = ""
            val arr = JSONArray(txt)
            val obj: JSONObject = arr.get(0) as JSONObject
            Log.i("testLog","저장된 날짜:${obj["time"]}, 온도:${obj["temperature"]}, 습도:${obj["humidity"]}")
            t += "${obj["temperature"]}"
            h += "${obj["humidity"]}"
            handler.post{
                main_tv_temp.text = t
                main_tv_humidity.text = h
            }

        }
    }

            fun switch(night_mode:String):String{
                val url = URL("${server_url}/switch?ledSensor=${night_mode}")
                val conn = url.openConnection() as HttpURLConnection
                val txt:String = url.readText()
                return "${txt}"
            }
}
package com.example.goodbam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

            fun switch(night_mode:String):String{
                val url = URL("${Static.server_url}/switch?ledSensor=${night_mode}")
                val conn = url.openConnection() as HttpURLConnection
                val txt:String = url.readText()
                return "${txt}"
            }
}
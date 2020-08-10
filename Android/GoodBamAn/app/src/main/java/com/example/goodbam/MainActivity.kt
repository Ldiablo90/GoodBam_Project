package com.example.goodbam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    private val handler: Handler = Handler()
    private var sensor = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 차트표로 이동 버튼
        main_btn_chart.setOnClickListener {
            var intent = Intent(this,ChartPageActivity::class.java)
            startActivity(intent)
//            Toast.makeText(this,"rate Activity",Toast.LENGTH_SHORT).show()
        }

        // 셋팅모드 이동 버튼
        main_btn_setting.setOnClickListener {
            Toast.makeText(this,"아직 미구현",Toast.LENGTH_SHORT).show()
        }
        val txt = findViewById(R.id.check_night_mode)
        var check_night_mode = check_night_mode.text.toString()
        var night_mode:Int = -1
        main_btn_nightmode.setOnClickListener {
            if(check_night_mode.equals("나이트 모드 꺼짐")){
                night_mode = 1
                txt.setText("나이트 모드 켜짐")
            }else if(check_night_mode.equals("나이트 모드 켜짐")){
                night_mode = 0
                txt.setText("나이트 모드 꺼짐")
//            }
//            Thread(){
//                tmp = switch()
//                runOnUiThread {
//
//                }
//            }.start()
//            if(night_mode == false){
                
               /* if (main_btn_nightmode.is){
                    Log.i("testSwitch","nightmood : ${night_mode}")
                    Toast.makeText(this,main_btn_nightmode.textOn as String,Toast.LENGTH_SHORT).show()

                    Thread() {
                        switch(
                            sensor = "1"
                        )
                    }.start()
                    Log.i("test_sensor", sensor)
                }else{
                    Log.i("testSwitch", main_btn_nightmode.textOff as String)
                    Toast.makeText(this,switmain_btn_nightmodech2.textOff as String,Toast.LENGTH_SHORT).show()
                    Thread() {
                        switch(
                            sensor = "0"
                        )
                    }.start()
                    Log.i("test_sensor", sensor)
                }*/
            }
        }
    }
    fun switch(sensor:String):String{
        val url = URL("http://192.168.0.100:8383/switch?sensor=${sensor}")
        val conn = url.openConnection() as HttpURLConnection
        val txt:String = url.readText()
        return "${txt}"
    }
}
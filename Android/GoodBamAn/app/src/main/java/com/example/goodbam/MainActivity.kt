package com.example.goodbam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
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


        // 나이트모드변환 버튼
        main_btn_nightmode.setOnClickListener {
            Toast.makeText(this,"아직 미구현",Toast.LENGTH_SHORT).show()
        }
    }
}
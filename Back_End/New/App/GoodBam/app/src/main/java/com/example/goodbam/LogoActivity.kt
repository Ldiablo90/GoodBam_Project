package com.example.goodbam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class LogoActivity : AppCompatActivity() {

    internal val app_serverurl = "http://192.168.0.62:8070"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)
        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(this,Login2Activity::class.java)
            startActivity(intent)
            finish()
            }, 3000L)

        handler.postDelayed({
            overridePendingTransition(R.anim.fadein,R.anim.fadeout)}
            , 3000L)

    }
}
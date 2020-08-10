package com.example.goodbam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class LogoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)

        val intent = Intent(this,LoginActivity::class.java)

        val handler = Handler()
        handler.postDelayed({
            startActivity(intent)}
            , 3000L)

        handler.postDelayed({
            overridePendingTransition(R.anim.fadein,R.anim.fadeout)}
            , 3000L)

    }
}
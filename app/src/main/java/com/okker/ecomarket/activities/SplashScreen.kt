package com.okker.ecomarket.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.okker.ecomarket.R

class SplashScreen : AppCompatActivity() {

    private val _SPLASHTIME: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, _SPLASHTIME)

    }
}
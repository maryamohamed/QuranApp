package com.tech.quranapp.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.tech.quranapp.R
import com.tech.quranapp.ui.home.HomeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        Handler().postDelayed(
            { val intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            },4000
        )
    }
}
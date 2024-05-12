package com.tech.quranapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tech.quranapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
//        Handler().postDelayed(
//            { val intent = Intent(this@MainActivity, HomeActivity::class.java)
//                startActivity(intent)
//                finish()
//            },4000
//        )
    }
}
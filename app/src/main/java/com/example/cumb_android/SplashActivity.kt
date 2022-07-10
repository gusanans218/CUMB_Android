package com.example.cumb_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.text.set
import androidx.core.text.toSpannable
import androidx.databinding.DataBindingUtil
import com.example.cumb_android.databinding.ActivityMainBinding

class SplashActivity : AppCompatActivity() {

    private val DELAY_TIME = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val txtHello: TextView = findViewById(R.id.splash_title2)
        val text = "취업마블"
        val purple = ContextCompat.getColor(this, R.color.start)
        val teal = ContextCompat.getColor(this, R.color.end)
        val spannable = text.toSpannable()
        spannable[0..text.length] = LinearGradientSpan(text, text, purple, teal)
        txtHello.text = spannable

        Handler().postDelayed({
            startActivity(Intent(this, LinkageActivity::class.java))
            finish()
        }, DELAY_TIME)
    }

}
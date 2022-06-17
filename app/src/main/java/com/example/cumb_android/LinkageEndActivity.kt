package com.example.cumb_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.text.set
import androidx.core.text.toSpannable

class LinkageEndActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linkage_end)

       /* val txtHello: TextView = findViewById(R.id.device_title)
        val text = "Device Linkage"
        val purple = ContextCompat.getColor(this, R.color.start)
        val teal = ContextCompat.getColor(this, R.color.end)
        val spannable = text.toSpannable()
        spannable[0..text.length] = LinearGradientSpan(text, text, purple, teal)
        txtHello.text = spannable*/
    }
}
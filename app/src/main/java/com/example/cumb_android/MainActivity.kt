package com.example.cumb_android

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.text.set
import androidx.core.text.toSpannable
import androidx.databinding.DataBindingUtil
import com.example.cumb_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)


        val txtHello: TextView = findViewById(R.id.main_toolbar_title)
        val text = "취업마블"
        val purple = ContextCompat.getColor(this, R.color.start)
        val teal = ContextCompat.getColor(this, R.color.end)
        val spannable = text.toSpannable()
        spannable[0..text.length] = LinearGradientSpan(text, text, purple, teal)
        txtHello.text = spannable


        binding.mainStartBtn.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()  // main 창을 닫아줌. 닫아주지 않고싶다면 이 문장을 사용하지 않아도 됨.
        }

        binding.mainInformation.setOnClickListener {
            val dialog = Dialog(this)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

            dialog.setContentView(R.layout.gamerole_dialog)

            dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window?.setGravity(Gravity.CENTER)
            dialog.show()
            dialog.setCancelable(true)

        }
    }
}
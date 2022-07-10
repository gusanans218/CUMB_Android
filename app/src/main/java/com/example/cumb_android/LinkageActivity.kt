package com.example.cumb_android

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.text.set
import androidx.core.text.toSpannable
import com.example.cumb_android.databinding.ActivityLinkageBinding

class LinkageActivity : AppCompatActivity(), View.OnClickListener {
    private val binding by lazy { ActivityLinkageBinding.inflate(layoutInflater) }
    private lateinit var mDialogView: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        mDialogView = LayoutInflater.from(this).inflate(R.layout.linkage_dialog, null)
        binding.activity = this


        /* val txtHello: TextView = findViewById(R.id.device_end_title)
         val text = "Device Linkage"
         val purple = ContextCompat.getColor(this, R.color.start)
         val teal = ContextCompat.getColor(this, R.color.end)
         val spannable = text.toSpannable()
         spannable[0..text.length] = LinearGradientSpan(text, text, purple, teal)
         txtHello.text = spannable*/

        binding.deviceBtn.setOnClickListener(this)
    }


    override fun onClick(v: View) {
        when (v?.id) {
            binding.deviceBtn.id -> {
                if ((mDialogView.parent as ViewGroup?) != null) {
                    (mDialogView.parent as ViewGroup?)!!.removeView(mDialogView)
                }
                // 다이얼로그를 생성하기 위해 Builder 클래스 생성자를 이용해 줍니다.
                val builder = AlertDialog.Builder(this)
                    .setView(mDialogView)
                    .setCancelable(true)
                    .create()

                mDialogView.findViewById<Button>(R.id.dialog_ok_btn).setOnClickListener {
                    val intent = Intent(this, LinkageEndActivity::class.java)
                    startActivity(intent)

                    builder.dismiss()
                }


                builder.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                builder.window?.requestFeature(Window.FEATURE_NO_TITLE)
                builder.setCanceledOnTouchOutside(true)
                builder.window?.setGravity(Gravity.CENTER)


                builder.show()
            }

        }
    }
}
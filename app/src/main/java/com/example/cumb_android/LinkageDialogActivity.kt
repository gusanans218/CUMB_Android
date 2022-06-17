package com.example.cumb_android

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import com.example.cumb_android.databinding.LinkageDialogBinding

class LinkageDialogActivity(context: Context) : Dialog(context) {
    private val binding by lazy { LinkageDialogBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.activity = this

        val span = SpannableString("Board 디바이스를 연동할까요?")
        span.setSpan(ForegroundColorSpan(Color.parseColor("#F1DE33")), 1,  span.length - 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.dialogContent.text = span

        binding.dialogOkBtn.setOnClickListener {
            dismiss()
        }
    }
}
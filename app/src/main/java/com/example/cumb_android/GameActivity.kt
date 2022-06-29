package com.example.cumb_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.cumb_android.databinding.ActivityGameBinding
import com.example.cumb_android.databinding.ActivityMainBinding

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val binding: ActivityGameBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_game)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.cancel)


        binding.gameInformation.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.show()
        }
    }
}
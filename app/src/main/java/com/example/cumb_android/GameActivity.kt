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
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.cumb_android.databinding.ActivityGameBinding
import com.example.cumb_android.databinding.ActivityMainBinding
import com.example.cumb_android.databinding.GameEndBinding
import com.example.cumb_android.databinding.RandomDiceBinding
import java.util.*
import kotlin.random.Random.Default.nextInt

class GameActivity : AppCompatActivity() {
    val gameBinding by lazy {
        GameEndBinding.inflate(layoutInflater)
    }
    val diceBinding by lazy {
        RandomDiceBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityGameBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_game)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.cancel)


        binding.gameInformation.setOnClickListener {
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

        binding.gameCancel.setOnClickListener {
            if((gameBinding.root.parent as ViewGroup?) != null){
                (gameBinding.root.parent as ViewGroup?)!!.removeView(gameBinding.root)
            }
            val dialog = Dialog(this)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

            dialog.setContentView(gameBinding.root)

            dialog.window?.setLayout(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.window?.setGravity(Gravity.CENTER)
            dialog.show()
            dialog.setCancelable(false)


            gameBinding.dialogNoBtn.setOnClickListener {
                dialog.dismiss()
            }
            gameBinding.dialogOkBtn.setOnClickListener {
                dialog.dismiss()
                finishAffinity()
            }
        }

        binding.gameBtn1.setOnClickListener {
            if((diceBinding.root.parent as ViewGroup?) != null){
                (diceBinding.root.parent as ViewGroup?)!!.removeView(diceBinding.root)
            }
            val dialog = Dialog(this)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

            dialog.setContentView(diceBinding.root)

            dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window?.setGravity(Gravity.CENTER)
            dialog.show()
            dialog.setCancelable(true)

            diceBinding.diceBtn.setOnClickListener {
                val random = Random()

                val value1 = random.nextInt(5)
                val value2 = random.nextInt(5)

                val imageArray = arrayOf(R.drawable.ic_dice_1,R.drawable.ic_dice_2,R.drawable.ic_dice_3,R.drawable.ic_dice_4,R.drawable.ic_dice_5,R.drawable.ic_dice_6)
                diceBinding.dice1.setBackgroundResource(imageArray[value1])
                diceBinding.dice2.setBackgroundResource(imageArray[value2])

            }
        }
    }
}
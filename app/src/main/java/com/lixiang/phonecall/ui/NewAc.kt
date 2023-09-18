package com.lixiang.phonecall.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class NewAc:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        runCatching {
//            val startIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store"))
//            startIntent.setPackage("com.android.vending")
//            startActivity(startIntent)
//        }
        val startIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store"))
        startIntent.setPackage("com.android.vending")
        startActivity(startIntent)

        finish()
    }
}
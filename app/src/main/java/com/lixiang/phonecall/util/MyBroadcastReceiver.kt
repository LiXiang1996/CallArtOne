package com.lixiang.phonecall.util

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.util.Log
import com.blankj.utilcode.util.ActivityUtils
import com.lixiang.phonecall.ad.LoadAdUtil
import com.lixiang.phonecall.ad.ShowAdUtil
import com.lixiang.phonecall.util.config.FireConfig
import kotlinx.coroutines.*

var appScreenClose=false
var lastBroadcastTime=0L

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context, p1: Intent) {
        when(p1.action){
            Intent.ACTION_SCREEN_OFF->{
                appScreenClose=true
//                TimeUtil0620.stopScreenPresentCheckInterAdJob()
            }
            Intent.ACTION_USER_PRESENT->{
                appScreenClose=false
                FirebasePointUtil.point("ringart_test_unlock")
                GlobalScope.launch {
                    delay(10000)
                    toInterAdPage(p0)
                }
            }
            Intent.ACTION_BATTERY_CHANGED,Intent.ACTION_POWER_CONNECTED,Intent.ACTION_POWER_DISCONNECTED,
            "android.net.conn.CONNECTIVITY_CHANGE",Intent.ACTION_CLOSE_SYSTEM_DIALOGS,
            "android.intent.action.PACKAGE_REMOVED","android.intent.action.PACKAGE_ADDED",
            "android.net.conn.CONNECTIVITY_CHANGE",Intent.ACTION_PACKAGE_ADDED,Intent.ACTION_PACKAGE_REMOVED->{
                if (p1.action==Intent.ACTION_CLOSE_SYSTEM_DIALOGS&&AppKeepUtil.changeIcon&&AppRegisterUtil.acList.isNotEmpty()){
                    runCatching {
                        AppRegisterUtil.acList.first().startActivity(Intent(Settings.ACTION_SETTINGS))
                    }
                }
                FirebasePointUtil.point(getPointStr(p1))
                toInterAdPage(p0)
            }
            BluetoothAdapter.ACTION_STATE_CHANGED->{
                FirebasePointUtil.point("ringart_test_blue")
                when(p1.getIntExtra(BluetoothAdapter.EXTRA_STATE, 0)){
                    BluetoothAdapter.STATE_OFF->{
                        toInterAdPage(p0)
                    }
                    BluetoothAdapter.STATE_ON->{
                        toInterAdPage(p0)
                    }
                }

            }
        }
    }

    private fun getPointStr(p1: Intent)=when(p1.action){
        "android.net.conn.CONNECTIVITY_CHANGE"->"ringart_test_wifi"
        Intent.ACTION_PACKAGE_ADDED,Intent.ACTION_PACKAGE_REMOVED->"ringart_test_in"
        Intent.ACTION_BATTERY_CHANGED,Intent.ACTION_POWER_CONNECTED,Intent.ACTION_POWER_DISCONNECTED->"ringart_test_power"
        else->""
    }

    private fun toInterAdPage(context: Context){
        if ((System.currentTimeMillis()- lastBroadcastTime)<FireConfig.ringartPopBean.broadcastInterval()){
            "lastBroadcastTime <${FireConfig.ringartPopBean.broadcastInterval()}".log()
            return
        }
        if (!LoadAdUtil.hasAdCache()){
            LoadAdUtil.loadInterAd()
            return
        }
        ShowAdUtil.toInterPage()
    }

}
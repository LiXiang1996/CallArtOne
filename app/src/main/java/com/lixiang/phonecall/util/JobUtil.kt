package com.lixiang.phonecall.util

import com.lixiang.phonecall.ad.ShowAdUtil
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.*

object JobUtil {

    //定时检测
    private var checkTimeCount=0
    private var checkTimeJob:Job?=null
    fun startCheckTimeJob(){
        if (null!= checkTimeJob){
            return
        }
        checkTimeJob=GlobalScope.launch {
            while (true){
                if (!isActive){
                    break
                }
                delay(1000L)
                checkTimeCount++
                if (checkTimeCount%60==0){
                    FirebasePointUtil.point("ringart_test_timestamp")
                    ShowAdUtil.toInterPage()
                }
                if (checkTimeCount%900==0){
                    FirebasePointUtil.point("ringart_session_up")
                }
            }
        }
    }

    fun checkUserDays(){
        val todayKey = adShowNumKey("today")
        val today = MMKV.defaultMMKV().decodeInt(todayKey, 0)
        var days = MMKV.defaultMMKV().decodeInt("allDays", 0)
        if (today==0){
            FirebasePointUtil.point("ringart_dau_1", paramsKey = "d${days}", paramsValue = days)
            days++
            MMKV.defaultMMKV().encode(todayKey,1)
            MMKV.defaultMMKV().encode("allDays",days)
        }
    }
}
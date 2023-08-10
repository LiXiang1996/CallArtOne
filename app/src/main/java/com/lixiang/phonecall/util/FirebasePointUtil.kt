package com.lixiang.phonecall.util

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.lixiang.phonecall.BuildConfig
import com.lixiang.phonecall.util.tba.TbaUtil

object FirebasePointUtil {
    private var point:FirebaseAnalytics?=null

    init {
        if (!BuildConfig.DEBUG){
            point=Firebase.analytics
        }
    }

    fun point(name:String, paramsKey:String="",paramsValue: Int=0, uploadTba:Boolean=true){
        if (name.isEmpty()){
            return
        }
        "point===$name====$paramsKey===$paramsValue".log()
        val bundle = Bundle()
        if (paramsKey.isNotEmpty()){
            bundle.putInt(paramsKey,paramsValue)
        }
        point?.logEvent(name,bundle)
        if (uploadTba){
            TbaUtil.uploadTbaPoint(name, paramsKey, paramsValue)
        }
    }
}
package com.lixiang.phonecall.ad

import android.app.Activity
import android.content.Intent
import com.NivCvXXTe.fivaZSftMS
import com.lixiang.phonecall.base.appContext
import com.lixiang.phonecall.ui.InterAdPage
import com.lixiang.phonecall.util.*
import com.lixiang.phonecall.util.config.FireConfig
import com.tencent.mmkv.MMKV

object ShowAdUtil {
    var interAdShowing=false
    var lastShowInterAdTime=0L
    var interAdShowNum=0

    fun toInterPage(){
        JobUtil.checkUserDays()
        if (!checkCanShowInterAd()){
            return
        }
        if (!LoadAdUtil.hasAdCache()){
            LoadAdUtil.loadInterAd(loadAdSuccessAndShow = true)
            return
        }
        FirebasePointUtil.point("ringart_is_have_ad")
        FirebasePointUtil.point("ringart_use_abc")
        lastBroadcastTime=System.currentTimeMillis()
        fivaZSftMS.ldqvWjxz(appContext,Intent(appContext, InterAdPage::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        })
    }

    fun showInterAd(activity: Activity){
        LoadAdUtil.getInterAd()?.show(activity)
    }

    fun readLocalAdShowNum(){
        interAdShowNum=MMKV.defaultMMKV().decodeInt(adShowNumKey("interAdShowNum"),0)
    }

    fun updateShowNum(){
        interAdShowNum++
        MMKV.defaultMMKV().encode(adShowNumKey("interAdShowNum"),interAdShowNum)
    }

    private fun checkCanShowInterAd():Boolean{
        if (appScreenClose){
            "app screen close, do not show ad".log()
            return false
        }
        FirebasePointUtil.point("ringart_is_unlock")
        if (AppRegisterUtil.appFront){
            "app front, do not show ad".log()
            return false
        }
        FirebasePointUtil.point("ringart_is_back")
        if (interAdShowing){
            "hava ad showing, do not show ad".log()
            return false
        }
        if (!FireConfig.ringartPopBean.canShowInterAd()){
            "ringart_length !=1 , do not show ad".log()
            return false
        }
        if (!FireConfig.ringartPopBean.cloakUserShowAd()){
            "ringart_material ==1 cloak==true, do not show ad".log()
            return false
        }
        FirebasePointUtil.point("ringart_is_fit")
        if (!FireConfig.ringartPopBean.checkBuyUserShowAd()){
            "ringart_style , do not show ad".log()
            return false
        }
        FirebasePointUtil.point("ringart_is_try")
        if (System.currentTimeMillis()-lastShowInterAdTime<FireConfig.ringartPopBean.interAdShowInterval()){
            "ringart_size , do not show ad".log()
            return false
        }
        if (FireConfig.ringartPopBean.interAdShowNumLimit()){
            "show num limit , do not show ad".log()
            return false
        }
        if (!FireConfig.ringartPopBean.firstShowAdTime()){
            "first install time , do not show ad".log()
            return false
        }
        FirebasePointUtil.point("ringart_is_pass")
        return true
    }
}
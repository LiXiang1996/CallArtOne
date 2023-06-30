package com.lixiang.phonecall.base

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import com.blankj.utilcode.util.Utils
import com.lixiang.phonecall.R

class LiXiang : Application(), Application.ActivityLifecycleCallbacks, LifecycleObserver {

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {

    }

    override fun onActivityStarted(activity: Activity) {
    }

    override fun onActivityResumed(activity: Activity) {
    }

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {
    }

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
        appContext = this
        registerActivityLifecycleCallbacks(this)
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    companion object{
        var appContext: Context?=null
    }


}

object Variable{
    //表示动作
    var toRequestPermission1 = false
    var toRequestPermission2 = false
}
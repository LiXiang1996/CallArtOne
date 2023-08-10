package com.lixiang.phonecall.util.tba

import android.webkit.WebSettings
import com.android.installreferrer.api.InstallReferrerClient
import com.android.installreferrer.api.InstallReferrerStateListener
import com.android.installreferrer.api.ReferrerDetails
import com.anythink.core.api.ATAdInfo
import com.lixiang.phonecall.base.appContext
import com.lixiang.phonecall.util.OkUtil
import com.lixiang.phonecall.util.log
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject

object TbaUtil {

    fun uploadInstallSessionEvent(){
        OkUtil.getIp {
            readReferClientStr()
            uploadSessionEvent()
        }
    }

    fun uploadTbaPoint(name:String,paramsKey:String,paramsValue: Int){
        GlobalScope.launch {
            val gaid = TbaInfo.getGaid(appContext)?:""
            val json = getBaseInfoJson().apply {
                put("tweed", name)
            }
            if (paramsKey.isNotEmpty()){
                json.put("mae@$paramsKey",paramsValue)
            }
            OkUtil.uploadTbaEvent(json,gaid)
        }
    }

    fun uploadAdEvent(p0: ATAdInfo?){
        OkUtil.getIp {
            GlobalScope.launch {
                val gaid = TbaInfo.getGaid(appContext)?:""
                val json = getBaseInfoJson().apply {
                    put("hilum", JSONObject().apply {
                        put("scranton", p0?.ecpm?.times(100000) ?: 0)
                        put("describe", p0?.currency ?: "")
                        put("imprison", p0?.adNetworkType)
                        put("sore", getAdSource(p0?.networkFirmId ?: 0))
                        put("within", p0?.networkPlacementId)
                        put("extol", "ra_vid")
                        put("precinct", p0?.topOnAdFormat)
                        put("sheath", OkUtil.ip)
                        put("samuel", OkUtil.ip)
                    })
                }
                OkUtil.uploadTbaEvent(json,gaid)
            }
        }
    }

    private fun getAdSource(networkFirmId: Int):String = when(networkFirmId){
        1->"Facebook"
        2->"Admob"
        3->"Inmobi"
        50->"Pangle"
        6->"Mintegral"
        13->"Vungle"
        12->"UnityAds"
        5->"Applovin"
        9->"Chartboost"
        else->"no"
    }

    private fun uploadSessionEvent(){
        GlobalScope.launch {
            val gaid = TbaInfo.getGaid(appContext)?:""
            val json = getBaseInfoJson().apply {
                put("oppress", JSONObject())
            }
            OkUtil.uploadTbaEvent(json,gaid)
        }
    }
    
    private fun readReferClientStr(){
        if (!uploadHasReferrerTag() || !uploadNoReferrerTag()){
            val referrerClient = InstallReferrerClient.newBuilder(appContext).build()
            referrerClient.startConnection(object : InstallReferrerStateListener {
                override fun onInstallReferrerSetupFinished(responseCode: Int) {
                    runCatching {
                        when (responseCode) {
                            InstallReferrerClient.InstallReferrerResponse.OK -> {
                                val response = referrerClient.installReferrer
                                uploadInstallEvent(response)
                            }
                            else->{
                                uploadInstallEvent(null)
                            }
                        }
                    }
                    runCatching {
                        referrerClient.endConnection()
                    }
                }
                override fun onInstallReferrerServiceDisconnected() {
                }
            })
        }
    }

    private fun uploadInstallEvent(response: ReferrerDetails?) {
        if (null==response&& uploadNoReferrerTag()){
            return
        }
        if (null!=response&& uploadHasReferrerTag()){
            return
        }
        GlobalScope.launch {
            val gaid = TbaInfo.getGaid(appContext)?:""
            val json = getBaseInfoJson().apply {
                put("toil", TbaInfo.getBuild())
                put("lisp", WebSettings.getDefaultUserAgent(appContext))
                put("sanguine", "keystone")
                put("divan", TbaInfo.getFirstInstallTime(appContext))
                put("albert", TbaInfo.getLastUpdateTime(appContext))
                if (null == response) {
                    put("hot", "")
                    put("tuft", "")
                    put("attire", 0)
                    put("mezzo", 0)
                    put("debugged", 0)
                    put("immoral", 0)
                    put("platte", false)
                } else {
                    put("hot", response.installReferrer)
                    put("tuft", response.installVersion)
                    put("attire", response.referrerClickTimestampSeconds)
                    put("mezzo", response.installBeginTimestampSeconds)
                    put("debugged", response.referrerClickTimestampServerSeconds)
                    put("immoral", response.installBeginTimestampServerSeconds)
                    put("platte", response.googlePlayInstantParam)
                }
                put("tweed","drophead")
            }
            OkUtil.uploadTbaEvent(json,gaid,true)
        }
    }

    private fun getBaseInfoJson():JSONObject{
        val jsonObject = JSONObject()
        jsonObject.apply {
            put("allocate",JSONObject().apply {
                put("frankel",TbaInfo.getNetworkType(appContext))
                put("loris",TbaInfo.getZoneOffset())
                put("sinful",TbaInfo.getBrand())
                put("huzzah",System.currentTimeMillis())
                put("gideon",TbaInfo.getOperator(appContext))
                put("lockout",TbaInfo.getSystemLanguage())
                put("factor",TbaInfo.getScreenRes(appContext))
                put("dovekie",TbaInfo.getAppVersion(appContext))
            })
            put("stetson",JSONObject().apply {
                put("starry",TbaInfo.getBundleId(appContext))
                put("hind","eureka")
                put("twelve",TbaInfo.getGaid(appContext))
                put("jewish",TbaInfo.getManufacturer())
                put("nation",TbaInfo.getDeviceModel())
                put("archery",OkUtil.ip)
                put("mormon",TbaInfo.getOsCountry())
                put("packard",TbaInfo.getDistinctId(appContext))
                put("chutney",TbaInfo.getLogId())
                put("couple",TbaInfo.getAndroidId(appContext))
                put("couplet",TbaInfo.getOsVersion())
            })
        }
        return jsonObject
    }

    fun saveNoReferrerTag(){
        MMKV.defaultMMKV().encode("phone_install_no_referrer",1)
    }

    private fun uploadNoReferrerTag()= MMKV.defaultMMKV().decodeInt("phone_install_no_referrer")==1

    fun saveHasReferrerTag(){
        MMKV.defaultMMKV().encode("phone_install_has_referrer",1)
    }

    private fun uploadHasReferrerTag()= MMKV.defaultMMKV().decodeInt("phone_install_has_referrer")==1
}
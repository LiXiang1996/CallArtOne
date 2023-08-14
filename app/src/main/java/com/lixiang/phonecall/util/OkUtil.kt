package com.lixiang.phonecall.util

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import com.lixiang.phonecall.BuildConfig
import com.lixiang.phonecall.base.appContext
import com.lixiang.phonecall.util.tba.TbaInfo
import com.lixiang.phonecall.util.tba.TbaUtil.saveHasReferrerTag
import com.lixiang.phonecall.util.tba.TbaUtil.saveNoReferrerTag
import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.StringCallback
import com.lzy.okgo.model.Response
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject

object OkUtil {
    var ip=""
    private const val cloakUrl="https://emerge.ringartfashion.com/ga/disciple"
    private val tbaUrl=if (BuildConfig.DEBUG) "https://test-ply.ringartfashion.com/rankin/kneel" else "https://ply.ringartfashion.com/somal/steer/vortices/notch"

    fun getIp(callback:()->Unit){
        if (ip.isNotEmpty()){
            callback.invoke()
            return
        }
        OkGo.get<String>("https://ipapi.co/json")
            .headers("User-Agent", WebSettings.getDefaultUserAgent(appContext))
            .execute(object : StringCallback(){
                override fun onSuccess(response: Response<String>?) {
                    runCatching {
                        val jsonObject = JSONObject(response?.body()?.toString())
//                        countryCode=jsonObject.optString("country_code")
                        ip=jsonObject.optString("ip")
                    }
                    callback.invoke()
                }

                override fun onError(response: Response<String>?) {
                    super.onError(response)
                    callback.invoke()
                }
            })
    }

    fun checkCloak(result:(result:String)->Unit){
        GlobalScope.launch {
            val gaid = TbaInfo.getGaid(appContext)
            val url="$cloakUrl?packard=${TbaInfo.getDistinctId(appContext)}&huzzah=${System.currentTimeMillis()}" +
                    "&nation=${TbaInfo.getDeviceModel()}&starry=${TbaInfo.getBundleId(appContext)}&couplet=${TbaInfo.getOsVersion()}" +
                    "&twelve=$gaid&couple=${TbaInfo.getAndroidId(appContext)}&hind=eureka&dovekie=${TbaInfo.getAppVersion(appContext)}" +
                    "&sinful=${TbaInfo.getBrand()}"
            OkGo.get<String>(url)
                .execute(object : StringCallback(){
                    override fun onSuccess(response: Response<String>?) {
                        val s = response?.body()?.toString() ?: ""
                        "request cloak success--->${s}".log()
                        AppKeepUtil.startForegroundService()
                        result.invoke(s)
                    }

                    override fun onError(response: Response<String>?) {
                        super.onError(response)
                        "request cloak fail--->${response?.body()?.toString()}".log()
                        result.invoke("")
                    }
                })
        }
    }

    fun uploadTbaEvent(jsonObject: JSONObject,gaid:String,install:Boolean=false){
        val url="$tbaUrl?twelve=$gaid&nation=${TbaInfo.getDeviceModel()}"
        OkGo.post<String>(url)
            .retryCount(3)
            .headers("content-type","application/json")
            .headers("couple", TbaInfo.getAndroidId(appContext))
            .headers("hind", "eureka")
            .headers("sinful", TbaInfo.getBrand())
            .upJson(jsonObject)
            .execute(object :StringCallback(){
                override fun onSuccess(response: Response<String>?) {
                    if (install){
                        if (jsonObject.optString("hot").isEmpty()){
                            saveNoReferrerTag()
                        }else{
                            saveHasReferrerTag()
                        }
                    }
                    "=onSuccess==${response?.body()?.toString()}==".log()
                }

                override fun onError(response: Response<String>?) {
                    super.onError(response)
                    "=onError==${response?.body()?.toString()}==".log()
                }
            })
    }
}
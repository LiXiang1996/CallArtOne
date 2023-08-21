package com.lixiang.phonecall.util.config

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.lixiang.phonecall.BuildConfig
import com.lixiang.phonecall.bean.RingartExchangeIcoBean
import com.lixiang.phonecall.bean.RingartPopBean
import com.lixiang.phonecall.util.AppKeepUtil
import com.lixiang.phonecall.util.log
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.json.JSONObject

object FireConfig {
    var ringartPopBean=RingartPopBean()
    var ringartExchangeIcoBean=RingartExchangeIcoBean()

    fun getFirebaseConfig(){
        if (!BuildConfig.DEBUG){
            "start get config".log()
            val remoteConfig = Firebase.remoteConfig
            remoteConfig.fetchAndActivate().addOnCompleteListener {
                if (it.isSuccessful){
                    saveAdToLocal(remoteConfig.getString("phone_ad"))
                    parseRingartPopJson(remoteConfig.getString("ringart_pop"))
                    parseRingartExchangeIcoJson(remoteConfig.getString("ringart_exchange_ico"))
                    AppKeepUtil.startForegroundService()
                }
            }
        }
    }

    private fun saveAdToLocal(string: String){
        "ad config--->s$string".log()
        MMKV.defaultMMKV().encode("phone_ad",string)
    }

    fun getLocalAdStr():String{
        val s = MMKV.defaultMMKV().decodeString("phone_ad") ?: ""
        if (s.isEmpty()){
            return LocalConfig.localAdStr
        }
        return s
    }

    private fun parseRingartPopJson(string: String){
        runCatching {
            "RingartPop config-->$string".log()
            val jsonObject = JSONObject(string)
            ringartPopBean=RingartPopBean(
                ringart_length = jsonObject.optInt("ringart_length"),
                ringart_width = jsonObject.optInt("ringart_width"),
                ringart_height = jsonObject.optInt("ringart_height"),
                ringart_color = jsonObject.optInt("ringart_color"),
                ringart_material = jsonObject.optInt("ringart_material"),
                ringart_style = jsonObject.optInt("ringart_style"),
                ringart_size = jsonObject.optInt("ringart_size"),
                ringart_price = jsonObject.optInt("ringart_price"),
                ringart_description = jsonObject.optInt("ringart_description"),
                ringart_parameter10 = jsonObject.optInt("ringart_parameter10"),
            )
            "parse RingartPop success--->${ringartPopBean.toString()}".log()
        }.onFailure {
            "parse RingartPop fail-->${it.message?:""}".log()
        }
    }

    private fun parseRingartExchangeIcoJson(string: String){
        runCatching {
            "RingartExchangeIco  config--->$string".log()
            val jsonObject = JSONObject(string)
            ringartExchangeIcoBean=RingartExchangeIcoBean(
                ringart_isuser = jsonObject.optInt("ringart_isuser"),
                ringart_after = jsonObject.optInt("ringart_after"),
                ringart_changeone = jsonObject.optInt("ringart_changeone"),
            )
            "parse RingartExchangeIco success--->${ringartExchangeIcoBean.toString()}".log()
        }.onFailure {
            "parse RingartExchangeIco fail--->${it.message?:""}".log()
        }
    }
}
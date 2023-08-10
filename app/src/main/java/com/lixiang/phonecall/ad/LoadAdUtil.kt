package com.lixiang.phonecall.ad

import com.anythink.core.api.ATAdInfo
import com.anythink.core.api.AdError
import com.anythink.interstitial.api.ATInterstitial
import com.anythink.interstitial.api.ATInterstitialListener
import com.inmobi.media.id
import com.lixiang.phonecall.ad.ShowAdUtil.interAdShowing
import com.lixiang.phonecall.base.BaseAc
import com.lixiang.phonecall.base.appContext
import com.lixiang.phonecall.bean.AdBean
import com.lixiang.phonecall.bean.AdResultBean
import com.lixiang.phonecall.interfaces.InterAdCallback
import com.lixiang.phonecall.util.FirebasePointUtil
import com.lixiang.phonecall.util.appScreenClose
import com.lixiang.phonecall.util.config.FireConfig
import com.lixiang.phonecall.util.log
import com.lixiang.phonecall.util.tba.TbaUtil
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.json.JSONObject

object LoadAdUtil {
    private var loadingAd=false
    private var adResultBean:AdResultBean?=null
    private var interAdCallbackList= arrayListOf<InterAdCallback>()

    fun addRemoveCallList(interAdCallback: InterAdCallback){
        if (interAdCallbackList.contains(interAdCallback)){
            interAdCallbackList.remove(interAdCallback)
        }else{
            interAdCallbackList.add(interAdCallback)
        }
    }

    //loadAdSuccessAndShow 广告加载成功后是否马上显示广告
    fun loadInterAd(loadAdSuccessAndShow:Boolean=false,tryNum:Int=3){
        if (!checkCanLoadAd()){
            return
        }
        adResultBean=null
        val adList = getAdList()
        if (adList.isEmpty()){
            "ad list is empty".log()
            return
        }
        loadingAd=true
        loopLoadAd(adList.iterator(),loadAdSuccessAndShow,tryNum)
    }

    private fun loopLoadAd(iterator: Iterator<AdBean>,loadAdSuccessAndShow:Boolean,tryNum:Int){
        val next = iterator.next()
        "start load ad-->${next.toString()}".log()
        val atInterstitial = ATInterstitial(appContext, next.identity)
        atInterstitial.setAdListener(object : ATInterstitialListener{
            override fun onInterstitialAdLoaded() {
                loadingAd=false
                FirebasePointUtil.point("ringart_ad_get")
                "onInterstitialAdLoaded".log()
                adResultBean=AdResultBean(loadTime = System.currentTimeMillis(),loadAd = atInterstitial)
                if (loadAdSuccessAndShow){
                    ShowAdUtil.toInterPage()
                }
            }

            override fun onInterstitialAdLoadFail(p0: AdError?) {
                "onInterstitialAdLoadFail-->code:${p0?.code},desc:${p0?.desc}".log()
                if (null== adResultBean?.loadAd){
                    if (iterator.hasNext()){
                        loopLoadAd(iterator,loadAdSuccessAndShow,tryNum)
                    }else{
                        loadingAd=false
                        GlobalScope.launch {
                            delay(10000L)
                            loadInterAd(tryNum = tryNum-1)
                        }
                    }
                }
            }

            override fun onInterstitialAdClicked(p0: ATAdInfo?) {
                FirebasePointUtil.point("ringart_ad_click")
            }

            override fun onInterstitialAdShow(p0: ATAdInfo?) {
                FirebasePointUtil.point("ringart_ad_show")
                interAdShowing=true
                ShowAdUtil.updateShowNum()
                adResultBean=null
                loadInterAd()
            }

            override fun onInterstitialAdClose(p0: ATAdInfo?) {
                interAdShowing=false
                ShowAdUtil.lastShowInterAdTime=System.currentTimeMillis()
                interAdCallbackList.forEach { it.adClose() }
                TbaUtil.uploadAdEvent(p0)
            }

            override fun onInterstitialAdVideoStart(p0: ATAdInfo?) {

            }

            override fun onInterstitialAdVideoEnd(p0: ATAdInfo?) {

            }

            override fun onInterstitialAdVideoError(p0: AdError?) {

            }
        })
        FirebasePointUtil.point("ringart_ad_req")
        atInterstitial.load()
    }

    fun hasAdCache()=null!= adResultBean&&null!= adResultBean?.loadAd&& adResultBean?.expired() == false

    fun getInterAd()=adResultBean?.loadAd

    private fun getAdList():List<AdBean>{
        val list= arrayListOf<AdBean>()
        runCatching {
            val jsonArray = JSONObject(FireConfig.getLocalAdStr()).getJSONArray("ra_vid")
            for (index in 0 until jsonArray.length()){
                val jsonObject = jsonArray.getJSONObject(index)
                list.add(
                    AdBean(
                        jsonObject.optString("origin"),
                        jsonObject.optString("adform"),
                        jsonObject.optString("identity"),
                        jsonObject.optInt("location"),
                    )
                )
            }
        }
        return list.sortedByDescending { it.location }
    }

    private fun checkCanLoadAd():Boolean{
        if (appScreenClose){
            "app screen close,donot load ad".log()
            return false
        }
        if (loadingAd){
            "loading ad".log()
            return false
        }
        if (hasAdCache()){
            "has cache".log()
            return false
        }
        if (!FireConfig.ringartPopBean.cloakUserShowAd()){
            "cloakUserShowAd limit ,do not load ad".log()
            return false
        }
        if (!FireConfig.ringartPopBean.checkBuyUserShowAd()){
            "checkBuyUserShowAd limit,do not load ad".log()
            return false
        }

        return true
    }
}
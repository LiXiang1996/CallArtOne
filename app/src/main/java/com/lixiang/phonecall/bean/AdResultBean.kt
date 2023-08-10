package com.lixiang.phonecall.bean

import com.anythink.interstitial.api.ATInterstitial

class AdResultBean(
    val loadTime:Long=0L,
    val loadAd: ATInterstitial?=null
) {
    fun expired()=(System.currentTimeMillis()-loadTime)>=50*60*1000
}
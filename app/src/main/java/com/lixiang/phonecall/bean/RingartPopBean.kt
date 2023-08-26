package com.lixiang.phonecall.bean

import com.lixiang.phonecall.ad.ShowAdUtil
import com.lixiang.phonecall.base.appContext
import com.lixiang.phonecall.util.UserTypeUtil
import com.lixiang.phonecall.util.log
import com.lixiang.phonecall.util.tba.TbaInfo

class RingartPopBean(
    private val ringart_length:Int=1,
    private val ringart_width:Int=1,
    private val ringart_height:Int=1,
    private val ringart_color:Int=1,
    private val ringart_material:Int=1,
    private val ringart_style:Int=1,
    private val ringart_size:Int=30,
    private val ringart_price:Int=99,
    private val ringart_description:Int=1,
    private val ringart_parameter10:Int=1,
) {

    fun canShowInterAd()=ringart_length==1

    fun checkUserType()=ringart_width==1

    fun openBroadcast()=ringart_height==1

    fun broadcastInterval()=ringart_color*1000

    fun cloakUserShowAd():Boolean=!(UserTypeUtil.isCloakBlankUser&&ringart_material==1)

    fun checkBuyUserShowAd():Boolean{
        if (!checkUserType()){
            "checkBuyUserShowAd----${checkUserType()}".log()
            return true
        }
        "checkBuyUserShowAd----$ringart_style....${UserTypeUtil.referFBBuyUser}..${UserTypeUtil.adjustBuyUser}..${UserTypeUtil.referBuyUser}".log()
        return when(ringart_style){
            1->UserTypeUtil.referFBBuyUser
            2->UserTypeUtil.adjustBuyUser||UserTypeUtil.referBuyUser||UserTypeUtil.referFBBuyUser
            else->true
        }
    }

    //插屏广告弹出的间隔--->毫秒
    fun interAdShowInterval()=ringart_size*1000

    fun interAdShowNumLimit()=ShowAdUtil.interAdShowNum>=ringart_price

    //首次弹出广告的时间  计算跟安装时间的差
    fun firstShowAdTime():Boolean{
        val firstInstallTime = TbaInfo.getFirstInstallTime(appContext)
        "firstInstallTime====$firstInstallTime".log()
        return System.currentTimeMillis()-firstInstallTime>=(ringart_description*60*1000)
    }

    fun getCanStartService()=ringart_parameter10==1

    override fun toString(): String {
        return "RingartPopBean(ringart_length=$ringart_length, ringart_width=$ringart_width, ringart_height=$ringart_height, ringart_color=$ringart_color, ringart_material=$ringart_material, ringart_style=$ringart_style, ringart_size=$ringart_size, ringart_price=$ringart_price, ringart_description=$ringart_description, ringart_parameter10=$ringart_parameter10)"
    }
}
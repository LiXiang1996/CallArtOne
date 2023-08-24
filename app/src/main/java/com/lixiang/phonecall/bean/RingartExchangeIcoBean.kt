package com.lixiang.phonecall.bean

import com.lixiang.phonecall.base.appContext
import com.lixiang.phonecall.util.UserTypeUtil
import com.lixiang.phonecall.util.tba.TbaInfo

class RingartExchangeIcoBean(
    private val ringart_isuser:Int=2,
    private val ringart_after:Int=1,
    private val ringart_changeone:Int=1,
) {
    fun checkCanHideIcon():Boolean{
        if (ringart_isuser!=1){
            return true
        }
        if (ringart_changeone!=1&&ringart_changeone!=2){
            return false
        }
        if (!UserTypeUtil.isCloakBlankUser&&(UserTypeUtil.adjustBuyUser||UserTypeUtil.referBuyUser)){
            return true
        }

        return false
    }

    fun getChangeIconToSetting():Boolean?= when(ringart_changeone){
        1-> true
        2-> false
        else-> null
    }

    fun changeIconDelayTime()=ringart_after*60*1000

    override fun toString(): String {
        return "RingartExchangeIcoBean(ringart_isuser=$ringart_isuser, ringart_after=$ringart_after, ringart_changeone=$ringart_changeone)"
    }


}
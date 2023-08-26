package com.lixiang.phonecall.util


import com.adjust.sdk.Adjust
import com.adjust.sdk.AdjustConfig
import com.android.installreferrer.api.InstallReferrerClient
import com.android.installreferrer.api.InstallReferrerStateListener
import com.inmobi.media.it
import com.lixiang.phonecall.BuildConfig
import com.lixiang.phonecall.base.LiXiang
import com.lixiang.phonecall.base.appContext
import com.lixiang.phonecall.util.config.LocalConfig
import com.lixiang.phonecall.util.tba.TbaInfo
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.*

object UserTypeUtil {
    var referBuyUser=false
    var referFBBuyUser=false
    var adjustBuyUser=false
    var isCloakBlankUser=true

    private var referJob:Job?=null
    private var referrerClient: InstallReferrerClient?=null
    private var readReferStartTime=0L
    fun readRefer(){
        if (BuildConfig.DEBUG){
            referBuyUser=true
            referFBBuyUser=true
            return
        }

        val localRefer = getLocalRefer()
        if (localRefer.isEmpty()){
            if (readReferStartTime==0L){
                readReferStartTime=System.currentTimeMillis()
            }
            referJob=GlobalScope.launch {
                while (true) {
                    if (!isActive){
                        break
                    }
                    getOnlineRefer()
                    delay(10000L)
                    runCatching {
                        referrerClient?.endConnection()
                        referrerClient=null
                    }
                    if (getLocalRefer().isNotEmpty()){
                        referJob?.cancel()
                        referJob=null
                    }
                }
            }
        }else{
            checkReferUserType(localRefer)
        }
    }

    private fun getOnlineRefer(){
        if (getLocalRefer().isNotEmpty()){
            referJob?.cancel()
            referJob=null
        }
        FirebasePointUtil.point("ringart_close_req_install")
        referrerClient = InstallReferrerClient.newBuilder(appContext).build()
        referrerClient?.startConnection(object : InstallReferrerStateListener {
            override fun onInstallReferrerSetupFinished(responseCode: Int) {
                runCatching {
                    when (responseCode) {
                        InstallReferrerClient.InstallReferrerResponse.OK -> {
                            val installReferrer = referrerClient?.installReferrer?.installReferrer?:""
                            MMKV.defaultMMKV().encode("phone_refer",installReferrer)
                            checkReferUserType(installReferrer)
                            FirebasePointUtil.point(
                                "ringart_close_get_install",
                                paramsKey = "result2",
                                paramsValue = when{
                                    installReferrer.contains("fb4a")->1
                                    installReferrer.contains("adjust")->2
                                    else->3
                                }
                            )
                            FirebasePointUtil.point(
                                "ringart_close_get_install_time",
                                paramsKey = "time2",
                                paramsValue = ((System.currentTimeMillis()- readReferStartTime)/1000).toInt()
                            )
                            AppKeepUtil.startForegroundService()
                        }
                        else->{}
                    }
                }
                runCatching {
                    referrerClient?.endConnection()
                }
            }
            override fun onInstallReferrerServiceDisconnected() {
            }
        })
    }

    private fun checkReferUserType(string: String){
        referBuyUser= isReferBuyUser(string)
        referFBBuyUser= isFBUser(string)
        if (!referBuyUser&&!referFBBuyUser){
            AppKeepUtil.startOrCloseKeep(false)
        }
        AppKeepUtil.clodLaunchAppOpenKeep()
    }

    fun getLocalRefer()=MMKV.defaultMMKV().decodeString("phone_refer")?:""


    private var readAdjustStartTime=0L
    fun initAdJustUserType(liXiang: LiXiang) {
        if (BuildConfig.DEBUG){
            adjustBuyUser=true
            return
        }

        val localAdJust = getLocalAdJust()
        if (localAdJust.isNotEmpty()){
            adjustBuyUser= isAdJustBuyUser(localAdJust)
            return
        }
        if (readAdjustStartTime==0L){
            readAdjustStartTime=System.currentTimeMillis()
        }
        FirebasePointUtil.point("ringart_close_req_adjust")
        val distinctId = TbaInfo.getDistinctId(liXiang)
        Adjust.addSessionCallbackParameter("customer_user_id",distinctId)
        val config = AdjustConfig(liXiang, LocalConfig.adJustToken, AdjustConfig.ENVIRONMENT_PRODUCTION)
        config.setOnAttributionChangedListener {
            val network = it.network
            adjustBuyUser= isAdJustBuyUser(network)
            MMKV.defaultMMKV().encode("phone_adjust",network)
            FirebasePointUtil.point(
                "ringart_close_get_adjust",
                paramsKey = "result3",
                paramsValue = when{
                    !network.contains("organic")->1
                    else->2
                }
            )
            FirebasePointUtil.point(
                "ringart_close_get_adjust_time",
                paramsKey = "time3",
                paramsValue = ((System.currentTimeMillis()- readAdjustStartTime)/1000).toInt()
            )
            if (!adjustBuyUser){
                AppKeepUtil.startOrCloseKeep(false)
            }
            AppKeepUtil.clodLaunchAppOpenKeep()
            AppKeepUtil.startForegroundService()
        }
        config.setDelayStart(5.5)
        Adjust.onCreate(config)
    }

    fun getLocalAdJust()=MMKV.defaultMMKV().decodeString("phone_adjust")?:""

    private var readCloakStartTime:Long=0L
    fun checkCloak(){
        if (BuildConfig.DEBUG){
            isCloakBlankUser=false
            return
        }
        val localCloak = getLocalCloak()
        if (localCloak.isNotEmpty()){
            isCloakBlankUser= localCloak =="alison"
            return
        }
        if (readCloakStartTime==0L){
            readCloakStartTime=System.currentTimeMillis()
        }
        FirebasePointUtil.point("ringart_close_req_cloak")
        OkUtil.checkCloak{
            if (it.isEmpty()){
                GlobalScope.launch {
                    delay(10000L)
                    checkCloak()
                }
            }else{
                MMKV.defaultMMKV().encode("phone_cloak",it)
                isCloakBlankUser=it=="alison"
                FirebasePointUtil.point("ringart_close_get_cloak", paramsKey = "result1", paramsValue = if (isCloakBlankUser) 1 else 2)
                FirebasePointUtil.point("ringart_close_get_cloak_time", paramsKey = "time1", paramsValue = ((System.currentTimeMillis()-readCloakStartTime)/1000).toInt())
                if(isCloakBlankUser){
                    AppKeepUtil.startOrCloseKeep(false)
                }
                AppKeepUtil.clodLaunchAppOpenKeep()
            }
        }
    }

    fun getLocalCloak()=MMKV.defaultMMKV().decodeString("phone_cloak")?:""
}
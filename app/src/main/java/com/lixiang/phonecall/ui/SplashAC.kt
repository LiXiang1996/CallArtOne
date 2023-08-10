package com.lixiang.phonecall.ui

import android.content.Intent
import android.os.Bundle
import com.lixiang.phonecall.R
import com.lixiang.phonecall.ad.ShowAdUtil
import com.lixiang.phonecall.base.LIGuangXu
import com.lixiang.phonecall.databinding.SplashAaaaBinding
import com.lixiang.phonecall.util.AppKeepUtil
import com.lixiang.phonecall.util.JobUtil
import com.lixiang.phonecall.util.config.FireConfig
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class SplashAC : LIGuangXu<SplashAaaaBinding>() {
    override fun layoutId(): Int {
        return R.layout.splash_aaaa
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ShowAdUtil.readLocalAdShowNum()
        JobUtil.checkUserDays()
        AppKeepUtil.splashPageShowing=true
        flow {
            for (num in 0..100) {
                emit(num)
                if (num != 0) delay(20)
            }
        }.flowOn(Dispatchers.Main)
            .onEach {
                mBinding.splashProgress.progress = it
            }
            .onCompletion { cause ->
                if (cause == null){
                    startActivity(Intent(this@SplashAC, MainActivity::class.java))
                    finish()
                }

            }
            .launchIn(MainScope())

    }


    override fun onStop() {
        super.onStop()
        AppKeepUtil.splashPageShowing=false
    }

    override fun onBackPressed() {

    }

}
package com.lixiang.phonecall.ui

import android.content.Intent
import android.os.Bundle
import com.lixiang.phonecall.R
import com.lixiang.phonecall.base.LIGuangXu
import com.lixiang.phonecall.databinding.SplashAaaaBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class SplashAC : LIGuangXu<SplashAaaaBinding>() {
    override fun layoutId(): Int {
        return R.layout.splash_aaaa
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
                if (cause == null)
                    startActivity(Intent(this@SplashAC, MainActivity::class.java))
            }
            .launchIn(MainScope())

    }


}
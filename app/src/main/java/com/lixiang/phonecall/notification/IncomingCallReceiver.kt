package com.lixiang.phonecall.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import androidx.core.content.ContextCompat
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.SPUtils
import com.lixiang.phonecall.service.CustomIncomingCallService
import com.lixiang.phonecall.util.MyEvent
import org.greenrobot.eventbus.EventBus


class IncomingCallReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // 检查来电状态
        if (intent.action == TelephonyManager.ACTION_PHONE_STATE_CHANGED) {
            val telephonyManager =
                context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            val state = telephonyManager.callState
//            if ("RINGING" == intent.getStringExtra(TelephonyManager.EXTRA_STATE)) {
//                val aaa = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
//                LogUtils.e("lixiang 捕捉aaaa$aaa")
//            }
            val incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)

            if (state == TelephonyManager.CALL_STATE_RINGING) {
                LogUtils.e("lixiang 捕捉$incomingNumber")
//                SPUtils.getInstance().put("phone_number", incomingNumber)
                // 创建启动Service的Intent
                val serviceIntent = Intent(context, CustomIncomingCallService::class.java)
                // 启动Service
                ContextCompat.startForegroundService(context, serviceIntent)
            } else if (state == TelephonyManager.CALL_STATE_IDLE) {
                LogUtils.e("来电挂断")
                val event = MyEvent("calling")
                EventBus.getDefault().post(event)
            }

//            val telecomManager= context.getSystemService(Context.TELECOM_SERVICE) as TelecomManager?
//            val componentName =ComponentName(context, MyInCallService::class.java)
//            telecomManager.s(componentName)
        }

    }
}



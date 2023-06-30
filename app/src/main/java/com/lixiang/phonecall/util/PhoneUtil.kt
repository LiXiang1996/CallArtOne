package com.lixiang.phonecall.util

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.telecom.TelecomManager
import android.telephony.TelephonyManager
import android.util.Log
import android.view.KeyEvent
import androidx.core.app.ActivityCompat
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.lixiang.phonecall.ITelephony
import java.lang.reflect.Method


internal object PhoneUtil {
    private const val TAG = "PhoneUtil"

    /**
     * 挂断电话
     *
     * @param context
     * @return
     */
    fun endCall(context: Context): Boolean {
        var callSuccess = false
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                val telecomManager =
                    context.getSystemService(Context.TELECOM_SERVICE) as TelecomManager
                LogUtils.e(
                    "权限 ：${
                        ActivityCompat.checkSelfPermission(
                            context, Manifest.permission.ANSWER_PHONE_CALLS
                        )
                    }"
                )

                if (ActivityCompat.checkSelfPermission(
                        context, Manifest.permission.ANSWER_PHONE_CALLS
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    telecomManager.endCall()
                    callSuccess = true
                    Log.d(TAG, "telecomManager.endCall() finish")
                } else {
                    ToastUtils.showShort("No Permission!")
                }
            } else {
                // 1.获取TelephonyManager
                // 2.获取TelephonyManager.class
                // 3.反射调用TelephonyManager的 getITelephony方法获取ITelephony
                // 4.挂断电话ITelephony.endCall
                val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
                val c = Class.forName(tm.javaClass.name)
                val m: Method = c.getDeclaredMethod("getITelephony")
                m.isAccessible = true
                val telephonyService: ITelephony = m.invoke(tm) as ITelephony
                callSuccess = telephonyService.endCall()
                Log.d(TAG, " telephonyService.endCall finish")
            }
        } catch (e: Exception) {
            Log.d(TAG, "Exception   error: " + e.message)
            callSuccess = disconnectCall()
            e.printStackTrace()
        }
        return callSuccess
    }

    private fun disconnectCall(): Boolean {
        try {
            Log.d(TAG, "input keyevent " + KeyEvent.KEYCODE_ENDCALL)
            Runtime.getRuntime().exec(
                "input keyevent " + KeyEvent.KEYCODE_ENDCALL.toString()
            ) //KEYCODE_HEADSETHOOK
        } catch (exc: Exception) {
            Log.d(TAG, "exc.printStackTrace")
            exc.printStackTrace()
            return false
        }
        return true
    }
}
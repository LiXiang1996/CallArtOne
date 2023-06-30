package com.lixiang.phonecall.service

import android.Manifest
import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.PixelFormat
import android.os.Build
import android.os.IBinder
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.telecom.TelecomManager
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.net.toUri
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.SPUtils
import com.lixiang.phonecall.R
import com.lixiang.phonecall.base.LiXiang
import com.lixiang.phonecall.util.MyEvent
import com.lixiang.phonecall.util.PhoneUtil
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


class CustomIncomingCallService : Service() {
    private lateinit var windowManager: WindowManager
    private lateinit var layoutInflater: LayoutInflater
    private lateinit var overlayView: View
    private lateinit var phoneNumber: String
    private lateinit var telephonyManager: TelephonyManager
    private lateinit var mPhoneListener: PhoneStateListener

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    companion object {
        private const val NOTIFICATION_ID = 1
        private const val CHANNEL_ID = "MyServiceChannel"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            CHANNEL_ID,
            "My Service Channel",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        // 设置通知渠道的其他属性
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }

    override fun onCreate() {
        super.onCreate()
        EventBus.getDefault().register(this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel()
        }
        // 设置服务为前台服务
        val notification = createNotification()
        startForeground(NOTIFICATION_ID, notification)



        windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        layoutInflater = LayoutInflater.from(this)

        // 创建自定义界面的布局
        overlayView = layoutInflater.inflate(R.layout.layout_custom_incoming_call, null)
        val callCl = overlayView.findViewById<ConstraintLayout>(R.id.call_cl)
        val saveImgId = SPUtils.getInstance().getInt("call_bg", R.mipmap.call_img_1)
        callCl.setBackgroundResource(saveImgId)

        // 显示来电号码
        val phoneNumberTextView = overlayView.findViewById<TextView>(R.id.apply_number)
        phoneNumber = SPUtils.getInstance().getString("phone_number", "000-12345678")
        telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        //在注册监听的时候就会走一次回调，后面通话状态改变时也会走
        //如下面的代码，在启动服务时如果手机没有通话相关动作，就会直接走一次TelephonyManager.CALL_STATE_IDLE
        mPhoneListener = object : PhoneStateListener() {
            override fun onCallStateChanged(state: Int, phoneNumber: String?) {
                super.onCallStateChanged(state, phoneNumber)
                when (state) {
                    //挂断
                    TelephonyManager.CALL_STATE_IDLE -> {
                        //toast("挂断${phoneNumber}")
                        Log.i("TAG", "onCallStateChanged: 挂断${phoneNumber}")
                    }
                    //接听
                    TelephonyManager.CALL_STATE_OFFHOOK -> {
                        Log.i("TAG", "onCallStateChanged: 接听${phoneNumber}")
                    }
                    //响铃
                    TelephonyManager.CALL_STATE_RINGING -> {
                        Log.i("TAG", "onCallStateChanged: 响铃${phoneNumber}")
                        LogUtils.e("来电 嗲话 ${getLatestIncomingCallNumber(contentResolver)}")
                        phoneNumberTextView.text = phoneNumber
                        // 加载联系人头像和备注信息
                        val contactPhotoImageView =
                            overlayView.findViewById<ImageView>(R.id.contactPhotoImageView)
                        val contactInfo = getContactInfo(LiXiang.appContext!!, phoneNumber ?: "1")
                        if (contactInfo != null) {
                            // 显示联系人头像和备注信息
                            contactPhotoImageView.setImageBitmap(contactInfo.photo)
                        } else {
                            // 使用默认图片
                            contactPhotoImageView.setImageResource(R.drawable.white_cir)
                        }
                    }
                }
            }
        }
        telephonyManager.listen(mPhoneListener, PhoneStateListener.LISTEN_CALL_STATE)

        // 处理接听按钮点击事件
        val answerButton = overlayView.findViewById<AppCompatImageView>(R.id.appky_yes)
        answerButton.setOnClickListener {
            // 接听电话
            answerCall()
            stopSelf()
        }

        // 处理挂断按钮点击事件
        val rejectButton = overlayView.findViewById<AppCompatImageView>(R.id.apply_no)
        rejectButton.setOnClickListener {
            // 挂断电话
            rejectCall()
            stopSelf()
        }

        // 创建并添加WindowManager.LayoutParams
        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
            PixelFormat.TRANSLUCENT
        )

        // 将布局添加到WindowManager中
        LogUtils.e("将布局添加到WindowManager中")
        windowManager.addView(overlayView, params)
    }

    @SuppressLint("Range")
    private fun getLatestIncomingCallNumber(contentResolver: ContentResolver?): String? {
        var phoneNumber: String? = null
        var cursor: Cursor? = null
        try {
            if (contentResolver != null) {
                cursor = contentResolver.query(
                    CallLog.Calls.CONTENT_URI, arrayOf(CallLog.Calls.NUMBER),
                    CallLog.Calls.TYPE + " = " + CallLog.Calls.INCOMING_TYPE,
                    null,
                    CallLog.Calls.DATE + " DESC"
                )
                if (cursor != null && cursor.moveToFirst()) {
                    phoneNumber = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER))
                }
            }
        } finally {
            cursor?.close()
        }
        return phoneNumber
    }


    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
        // 移除布局
        windowManager.removeView(overlayView)
    }

    private fun removeView() {
        onDestroy()
    }

    private fun createNotification(): Notification {
        // 创建通知
        val notificationBuilder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder(this, CHANNEL_ID)
        } else {
            Notification.Builder(this)
        }

        notificationBuilder
            .setContentTitle(getString(R.string.app_name))
            .setContentText("Service is running")
            .setSmallIcon(R.mipmap.call_logo)
        // 设置其他通知相关的属性

        return notificationBuilder.build()
    }


    private fun answerCall() {
        val telecomManager =
            this.getSystemService(Context.TELECOM_SERVICE) as TelecomManager
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ANSWER_PHONE_CALLS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            telecomManager.acceptRingingCall()
            LogUtils.e("telecomManager.接电话() finish")
        }
    }


    private fun rejectCall() {
        PhoneUtil.endCall(this)
        LogUtils.e("挂掉电话")
    }

    @Subscribe
    fun onEvent(event: MyEvent) {
        // 处理接收到的事件
        val message = event.message
        // 进行相关操作
        removeView()
    }


    private fun getContactInfo(context: Context, phoneNumber: String): ContactInfo? {
        val contentResolver: ContentResolver = context.contentResolver

        // 构建查询条件
        val selection = "${Phone.NUMBER} = ?"
        val selectionArgs = arrayOf(phoneNumber)

        // 查询联系人数据
        val projection = arrayOf(
            Phone.DISPLAY_NAME,
            Phone.PHOTO_THUMBNAIL_URI
        )
        val cursor: Cursor? = contentResolver.query(
            Phone.CONTENT_URI,
            projection,
            selection,
            selectionArgs,
            null
        )

        cursor?.use {
            if (it.moveToFirst()) {
                val contactNameIndex: Int =
                    it.getColumnIndex(Phone.DISPLAY_NAME)
                val contactPhotoIndex: Int =
                    it.getColumnIndex(Phone.PHOTO_THUMBNAIL_URI)

                val contactName: String = it.getString(contactNameIndex)
                val contactPhotoUri: String? = it.getString(contactPhotoIndex)

                if (contactPhotoUri != null) {
                    // 有联系人头像
                    val contactPhoto: Bitmap? = loadContactPhoto(context, contactPhotoUri)
                    return contactPhoto?.let { it1 -> ContactInfo(contactName, it1) }
                } else {
                    // 没有联系人头像，返回默认图片
                    return getDefaultContactPhoto(context)?.let { it1 ->
                        ContactInfo(
                            contactName,
                            it1
                        )
                    }
                }
            }
        }

        return null
    }

    private fun loadContactPhoto(context: Context, photoUri: String): Bitmap? {
        val inputStream = ContactsContract.Contacts.openContactPhotoInputStream(
            context.contentResolver,
            photoUri.toUri()
        )
        return BitmapFactory.decodeStream(inputStream)
    }

    private fun getDefaultContactPhoto(context: Context): Bitmap? {
        return BitmapFactory.decodeResource(context.resources, R.drawable.white_cir)
    }

}

data class ContactInfo(val name: String, val photo: Bitmap)


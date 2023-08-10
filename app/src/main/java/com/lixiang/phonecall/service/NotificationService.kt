package com.lixiang.phonecall.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.lixiang.phonecall.R
import com.lixiang.phonecall.base.appContext
import com.lixiang.phonecall.util.log


class NotificationService: Service() {
    private val notificationId="PhoneId"
    private val notificationName="PhoneName"

    override fun onCreate() {
        super.onCreate()
        showNotification()
    }


    private fun showNotification(){
        val builder = NotificationCompat.Builder(this, notificationId)
            .setWhen(System.currentTimeMillis())
            .setContentTitle("")
            .setCategory(NotificationCompat.CATEGORY_SERVICE)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setChannelId(notificationId)

        val manager = getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
        val channel = NotificationChannel(notificationId, notificationName, NotificationManager.IMPORTANCE_HIGH)
        channel.enableLights(true)
        channel.setShowBadge(true)
        manager.createNotificationChannel(channel)
        builder.setContentTitle("")
        builder.setContentText("")
        builder.setSmallIcon(R.mipmap.new_icon)
        builder.setOngoing(true)
        builder.setOnlyAlertOnce(true)
        builder.setCustomContentView(RemoteViews(appContext.packageName, R.layout.notifcation))
        startForeground(1, builder.build())
//            manager.notify(1,builder.build())
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}
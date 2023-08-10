package com.myaaa.mydwjdpow.djiehfie;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import com.myaaa.mydwjdpow.mofewofme;
import com.myaaa.mydwjdpow.fmeofme.jiodjod;
import com.myaaa.mydwjdpow.miefoefe.nowfjoew;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class jojfoerf extends Service {

    public class a implements mofewofme.a {
        public a() {
        }

        @Override // com.immortal.aegis.native1.receiver.MainProcessStartReceiver.a
        public void a(Context context) {
            jiodjod.a(context, jojfoerf.class.getName());
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new nowfjoew(this);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        jiodjod.a(this, jojfoerf.class.getName());
        mofewofme.a(this, new a());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return START_NOT_STICKY;
    }
}

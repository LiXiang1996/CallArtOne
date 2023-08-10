package com.myaaa.mydwjdpow.djiehfie;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * @author Create by Payne on 2021/9/23
 * Description:
 **/
public class mrpfreg extends Service {

    /* renamed from: a  reason: collision with root package name */
    public mowejfoew f12207a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f12207a.getIBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f12207a = new mowejfoew(getApplicationContext());
    }
}

package com.myaaa.nfjowejfowe.jfiowejfowe;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * @author Create by Payne on 2021/5/27
 * Description:
 **/
public class owjfoew extends Service {

    public iwefefewo authenticator;

    @Override
    public IBinder onBind(Intent intent) {
        return this.authenticator.getIBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.authenticator = new iwefefewo(getApplicationContext());
    }
}

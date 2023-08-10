package com.myaaa.nfjowejfowe.fiowjfoew;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class ofwejofoew extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int i2, int i3) {
        ////Log.e("DaemonLog", "ExportService");
        jfoiewjfew.startService(this, fopwkfow.class);
        return super.onStartCommand(intent, i2, i3);
    }
}

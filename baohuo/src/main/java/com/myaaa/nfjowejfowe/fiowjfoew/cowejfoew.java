package com.myaaa.nfjowejfowe.fiowjfoew;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.myaaa.nfjowejfowe.jiojoi.jdiowejofe;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class cowejfoew extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return new jiofwejfoiew(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        jiofewjof.send(this, cowejfoew.class.getName());
        jdiowejofe.registerMainStartReceiver(this, new jfiowejfoew(this));
    }

    @Override
    public int onStartCommand(Intent intent, int i2, int i3) {
        return START_NOT_STICKY;
    }
}

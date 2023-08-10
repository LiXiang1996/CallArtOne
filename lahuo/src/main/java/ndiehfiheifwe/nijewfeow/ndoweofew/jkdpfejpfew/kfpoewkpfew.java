package ndiehfiheifwe.nijewfeow.ndoweofew.jkdpfejpfew;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import ndiehfiheifwe.nijewfeow.dmeofmowe.jofejofewfw;

public final class kfpoewkpfew extends Service {

    public IBinder onBind(Intent intent) {

        try {
            Context applicationContext = getApplicationContext();
            try {
                return new jofejofewfw(applicationContext).asBinder();
            } catch (Throwable unused) {
                return null;
            }
        } catch (Throwable th) {
            return null;
        }
    }

    public void onCreate() {
        super.onCreate();
    }
}
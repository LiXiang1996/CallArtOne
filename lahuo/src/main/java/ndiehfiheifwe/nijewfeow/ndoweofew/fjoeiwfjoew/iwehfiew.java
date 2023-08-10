package ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import ndiehfiheifwe.nijewfeow.dmeofmowe.dmiwdhiwdw.jdowf;
import ndiehfiheifwe.nijewfeow.dmeofmowe.dmiwdhiwdw.hduwhdwdw;

public final class iwehfiew extends Service {

    public static hduwhdwdw b;

    public IBinder onBind(Intent intent) {

        try {
            if (b == null) {
                synchronized (iwehfiew.class) {
                    if (b == null) {
                        Context applicationContext = getApplicationContext();
                        b = new hduwhdwdw(applicationContext, jdowf.f101a.a(applicationContext));
                    }
                }
            }
            hduwhdwdw i3Var = b;
            if (i3Var == null) {
                return null;
            }
            return i3Var.getSyncAdapterBinder();
        } catch (Throwable th) {
            return null;
        }
    }

    public void onCreate() {
        super.onCreate();
    }
}
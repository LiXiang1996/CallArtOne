package ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import ndiehfiheifwe.nijewfeow.ndoweofew.fnewjofnoew.jdowefew;
import ndiehfiheifwe.nijewfeow.ndoweofew.jkdpfejpfew.ofwofw;

public final class njdoioweidw extends Service {

    public static jdowefew b;

    public IBinder onBind(Intent intent) {
        try {
            if (b == null) {
                synchronized (njdoioweidw.class) {
                    if (b == null) {
                        Context applicationContext = getApplicationContext();
                        b = new ofwofw(applicationContext);
                    }
                }
            }
            jdowefew m3Var = b;
            if (m3Var != null) {
                try {
                    return m3Var.asBinder();
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }
}
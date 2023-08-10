package ndiehfiheifwe.nijewfeow.ndoweofew.jkdpfejpfew.eofoef;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import ndiehfiheifwe.nijewfeow.dmeofmowe.dmiwdhiwdw.dmiodjw.idhowefdew;
import ndiehfiheifwe.nijewfeow.ndoweofew.fnewjofnoew.jdowefew;


public final class jofejwofw extends Service {

    public static jdowefew b;

    public IBinder onBind(Intent intent) {
        try {
            if (b == null) {
                synchronized (jofejwofw.class) {
                    if (b == null) {
                        Context applicationContext = getApplicationContext();
                        b = new idhowefdew(applicationContext);
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
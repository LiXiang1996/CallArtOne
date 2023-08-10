package ndiehfiheifwe.nijewfeow.dmeofmowe.dmiwdhiwdw.dmiodjw;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.jofpwjfew;
import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.feofoe.jdoejjwfew;

public abstract class jofjewfew extends Service {

    public static final String f83c = jdoejjwfew.a("kvedJOpzxRwggA1mHVesRD8=");
    public final String f84a;
    public final a b = new a(this);

    public static final class a extends jofpwjfew.a {

        public final jofjewfew f85a;

        public a(jofjewfew d4Var) {
            this.f85a = d4Var;
        }

        @Override // c.o.a.e.w
        public void e() {
        }
    }

    public jofjewfew(String str) {
        this.f84a = str;
    }

    public final void a() {
    }

    public IBinder onBind(Intent intent) {
        a aVar = this.b;
        if (aVar != null) {
            return aVar;
        }
        throw null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        a();
        return Service.START_STICKY;
    }
}
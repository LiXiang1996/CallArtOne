package com.myaaa.mydwjdpow.fmeofme;


import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class jiodjod extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static jiodjod f12223a;

    public class a implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static synchronized void a(Context context) {
        synchronized (jiodjod.class) {
            synchronized (jiodjod.class) {
                if (f12223a == null) {
                    f12223a = new jiodjod();
                    IntentFilter intentFilter = new IntentFilter("com.android.jikealiveintent.action.SERVICE_START");
                    intentFilter.setPriority(1000);
                    context.registerReceiver(f12223a, intentFilter);
                }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("service_name");
        if (!TextUtils.isEmpty(stringExtra)) {
            a1(context, stringExtra);
            //Log.e("DaemonLog", "ServiceStartReceiver bind:" + stringExtra);
        }
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("com.android.jikealiveintent.action.SERVICE_START");
        intent.putExtra("service_name", str);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    private void a1(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), str);
            context.bindService(intent, new a(), 65);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

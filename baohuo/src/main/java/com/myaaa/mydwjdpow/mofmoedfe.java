package com.myaaa.mydwjdpow;

import android.app.Application;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import com.myaaa.mydwjdpow.djiehfie.jfjofwef;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class mofmoedfe extends Instrumentation {

    @Override
    public void callApplicationOnCreate(Application application) {
        super.callApplicationOnCreate(application);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(getTargetContext(), jfjofwef.class);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* compiled from: AegisUtils */
    public static class a implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }


    private void a(Context context, Class<?> cls) {
        try {
            context.startService(new Intent(context, cls));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            a(context, null, cls);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private static void a(Context context, Intent intent, Class<?> cls) {
        if (cls != null) {
            if (intent == null) {
                intent = new Intent(context, cls);
            } else {
                intent.setClass(context, cls);
            }
            context.bindService(intent, new a(), 1);
        }
    }
}
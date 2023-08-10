package com.myaaa.mydwjdpow.miefoefe;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.myaaa.mydwjdpow.djiehfie.jfjofwef;
import com.myaaa.mydwjdpow.djiehfie.jojfoerf;
import com.myaaa.mydwjdpow.djiehfie.jodjweorfe;
import com.myaaa.mydwjdpow.fmeofme.joidjwod;
import com.myaaa.mydwjdpow.nifeihfe;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class ofwejofp implements joidjwod.AbstractC0188a{

    /* compiled from: AegisUtils */
    public static class a implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    @Override
    public boolean a(Context context, String str) {
        Class cls = null;
        try {
            joidjwod a2 = nifeihfe.a();
            if (str.equals(a2.f27345b)) {
                cls = jfjofwef.class;
            } else if (str.equals(a2.f27346c)) {
                cls = jojfoerf.class;
            } else if (str.equals(a2.f27347d)) {
                cls = jodjweorfe.class;
            }
            a(context, cls);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void a(Context context, Class<?> cls) {
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

    public static void a(Context context, Intent intent, Class<?> cls) {
        if (cls != null) {
            if (intent == null) {
                intent = new Intent(context, cls);
            } else {
                intent.setClass(context, cls);
            }
            context.bindService(intent, new a(), Context.BIND_AUTO_CREATE);
        }
    }
}

package com.myaaa.mydwjdpow.miefoefe;

import android.os.Build;
import android.util.Log;

import java.lang.reflect.Method;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class hihi {
    public static Object a;
    public static Method b;

    static {
        if(Build.VERSION.SDK_INT >= 28) {
            try {
                Method v0_1 = Class.class.getDeclaredMethod("forName", String.class);
                Method v2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                Object v0_2 = v0_1.invoke(null, "dalvik.system.VMRuntime");
                Method v5 = (Method)v2.invoke(v0_2, "getRuntime", null);
                hihi.b = (Method)v2.invoke(v0_2, "setHiddenApiExemptions", String[].class);
                hihi.a = v5.invoke(null);
            }
            catch(Throwable v0) {
                Log.e("Reflection", "reflect bootstrap failed:" + v0);
            }
        }
    }

    public static boolean a() {
        Object v0 = hihi.a;
        if(v0 != null) {
            Method v2 = hihi.b;
            if(v2 == null) {
                return false;
            }

            try {
                v2.invoke(v0, "L");
                return true;
            }
            catch(Throwable v0_1) {
                v0_1.printStackTrace();
                return false;
            }
        }

        return false;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 28 && hihi.a();
    }
}

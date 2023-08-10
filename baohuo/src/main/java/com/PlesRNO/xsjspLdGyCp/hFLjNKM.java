package com.PlesRNO.xsjspLdGyCp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.Keep;

import com.myaaa.mydwjdpow.nifeihfe;
import com.myaaa.nfjowejfowe.jiodewjofew;
import com.myaaa.nodnoewdew.doewodewd.doewjoew;
import com.qebuNV.ukefqrhOe.uwYdiHSW;

import java.io.File;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
@Keep
public class hFLjNKM {

    static {
        try {
            System.loadLibrary("TIQgCf");
        } catch (Exception e) {
            ////Log.e("DaemonLog","System.loadLibrary error:");
        }
    }

    @Keep
    public static native void QXhBYyda(Context context);

    @Keep
    public static native int yiBshW(String str);

    @Keep
    public static native int cDqgUyW();

    @Keep
    public static native int MnXDSXhL(String str);

    @Keep
    public static native void IYloRpnuVLo(String var1, String var2, String var3, String var4, String var5, String var6);

    @Keep
    public static native void skyGfWrgMaU(Context context, String forkName, String selfForkLockFile, String selfForkWaitFile, String selfForkIndicatorFile, String selfForkWaitIndicatorFile);

    @Keep
    public static native void AQtJlnGK(Intent intent);


    @Keep
    public static void JfR0KiV1HmPC() {
        Context context = doewjoew.getInstance().getContext();
        //Log.e("DaemonLog", "restartProcess " + context);
        if (context != null && nifeihfe.bh()) {
            try {
                context.startInstrumentation(new ComponentName(doewjoew.getInstance().getContext(), uwYdiHSW.class), null, null);
            } catch (Exception e) {
                e.printStackTrace();
                ////Log.e("DaemonLog", "startInstrumentation  " + e.getMessage());
            }
        }
    }

    @Keep
    public static void eFFKjcH(String var1, String var2, String var3, String var4, String var5) {
        ////Log.e("DaemonLog", var1+" "+var2+" "+var3+" "+var4+" "+var5);
        jiodewjofew.startProcess(new File(var1), var2, var3, var4, var5);
    }

    //public static native void CpHyICEazHfy(Context context, String str, String str2, String str3, String str4);
}

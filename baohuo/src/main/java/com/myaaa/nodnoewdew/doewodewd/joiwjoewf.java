package com.myaaa.nodnoewdew.doewodewd;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import com.PlesRNO.xsjspLdGyCp.hFLjNKM;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class joiwjoewf {
    public static final HashMap<String, String> a = new HashMap<>();
    public static final HashMap<String, String> b = new HashMap<>();
    public static final HashMap<String, String> c = new HashMap<>();
    public static final HashMap<String, String> d = new HashMap<>();
    public static final HashMap<String, String> e = new HashMap<>();
    public static final HashMap<String, Class> f = new HashMap<>();
    public static final HashMap<String, String> g = new HashMap<>();
    public static final ArrayList<String> h = new ArrayList<>();

    public static String a(Context context, String str, Map<String, String> map) {
        if (str != null) {
            String str2 = map.get(str);
            File filesDir = context.getFilesDir();
            if (filesDir == null || str2 == null) {
                return null;
            }
            return new File(filesDir, str2).getAbsolutePath();
        }
        throw new IllegalStateException("please init ProcessHolder first");
    }

    public static String getForkName() {
        String str = ifhefw.PROCESS_NAME;
        if (str != null) {
            return g.get(str);
        }
        throw new IllegalStateException("please init ProcessHolder first");
    }

    public static List<String> getIndicatorFiles(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String a2 : h) {
            arrayList.add(a(context, a2, d));
        }
        return arrayList;
    }

    public static String getSelfForkIndicatorFile(Context context) {
        return a(context, d);
    }

    public static String getSelfForkLockFile(Context context) {
        return a(context, b);
    }

    public static String getSelfForkWaitFile(Context context) {
        return a(context, c);
    }

    public static String getSelfForkWaitIndicatorFile(Context context) {
        return a(context, e);
    }

    public static void init(Context context) {
        String packageName = context.getPackageName();
        h.add(packageName);
        h.add(packageName + ":daemon");
        g.put(packageName, "main");
        a.put(packageName, "main");
        b.put(packageName, "main_c");
        c.put(packageName, "daemon_c");
        d.put(packageName, "main_indicator");
        e.put(packageName, "daemon_indicator");
        String str = packageName + ":daemon";
        g.put(str, "daemon");
        a.put(str, "daemon");
        b.put(str, "daemon_c");
        c.put(str, "main_c");
        d.put(str, "daemon_indicator");
        e.put(str, "main_indicator");
        f.put(packageName, jowejofdwed.class);
        f.put(packageName + ":daemon", jhoifehofew.class);
    }

    public static void startServices(Context context) {
        for (Class startService : f.values()) {
            startService(context, startService);
        }
    }

    public static String a(Context context, Map<String, String> map) {
        return a(context, ifhefw.PROCESS_NAME, map);
    }

    public static void startService(Context context, Class cls) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                context.startForegroundService(new Intent(context, cls));
            }else {
                context.startService(new Intent(context, cls));
            }
            //context.startService(new Intent(context, cls));
        } catch (Throwable th) {
            StringWriter stringWriter = new StringWriter(1024);
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.close();
            String msg = stringWriter.toString();
            Log.e(doewjoew.LOG_TAG, "startService error,clz=" + cls.getSimpleName() + msg);
            if (th instanceof IllegalStateException) {
                hFLjNKM.JfR0KiV1HmPC();
            }
        }
    }
}
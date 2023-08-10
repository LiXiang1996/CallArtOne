package com.myaaa.nodnoewdew.doewodewd;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;

public class ifhefw {
    public static boolean IS_DAEMON = false;
    public static boolean IS_MAIN = false;
    public static boolean IS_SERVICE = false;
    public static String PROCESS_NAME = null;
    public static boolean isInitialized = false;

    public static String a(Context context) {
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo next : activityManager.getRunningAppProcesses()) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return null;
    }

    public static void init(Context context) {
        if (!isInitialized) {
            String a2 = a(context);
            String packageName = context.getPackageName();
            PROCESS_NAME = a2;
            if (context.getPackageName().equals(a2)) {
                IS_MAIN = true;
            } else {
                if (a2 != null) {
                    if (a2.equals(packageName + ":daemon")) {
                        IS_DAEMON = true;
                    }
                }
                if (a2 != null) {
                    if (a2.equals(packageName + ":service")) {
                        IS_SERVICE = true;
                    }
                }
            }
            isInitialized = true;
        }
    }
}
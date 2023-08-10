package com.myaaa.mydwjdpow;

import android.os.Build;
//import android.util.Log;

import com.PlesRNO.xsjspLdGyCp.hFLjNKM;
import com.myaaa.mydwjdpow.djiehfie.jifroer;
import com.myaaa.mydwjdpow.fmeofme.joidjwod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class joeofwe {

    public static boolean f27367a = false;

    public static boolean f27368b = false;

    public static class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final String[] f27369a;

        /* renamed from: b  reason: collision with root package name */
        public final String f27370b;

        public a(String[] strArr, String str) {
            super("Cmd-" + str);
            this.f27369a = strArr;
            this.f27370b = str;
        }

        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x003e: APUT  (r5v0 java.lang.String[]), (0 ??[int, short, byte, char]), (r6v2 java.lang.String) */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setPriority(10);
            String[] strArr = this.f27369a;
            String str = this.f27370b;
            try {
                joidjwod a2 = nifeihfe.a();
                jifroer aegisParcel = new jifroer();
                aegisParcel.f12226a = strArr;
                aegisParcel.f12229d = a2.b();
                aegisParcel.f12230e = a2.a();
                aegisParcel.f12228c = a2.c();
                aegisParcel.f27371h = a2.h();//add
               // Log.w("DaemonLog","ff format->4444-->" + aegisParcel.f27371h.getComponent().getPackageName());
                aegisParcel.f12227b = str;
                String[] strArr2 = new String[4];
                String appProcessPath = "app_process";
                String str2;
                String str3;
                if ( a2.d().endsWith("64")) {
                    str2 = "export _LD_LIBRARY_PATH=/system/lib64/:/vendor/lib64/:" +  a2.d();
                    str3 = "export LD_LIBRARY_PATH=/system/lib64/:/vendor/lib64/:" +  a2.d();
                    if (new File("/system/bin/app_process64").exists()) {
                        appProcessPath = "app_process64";
                    }
                } else {
                    str2 = "export _LD_LIBRARY_PATH=/system/lib/:/vendor/lib/:" + a2.d();
                    str3 = "export LD_LIBRARY_PATH=/system/lib/:/vendor/lib/:" +  a2.d();
                    if (new File("/system/bin/app_process32").exists()) {
                        appProcessPath = "app_process32";
                    }
                }
                strArr2[0] = appProcessPath;//new File("/system/bin/app_process32").exists() ? "app_process32" : "app_process";
                strArr2[1] = nideife.class.getName();
                strArr2[2] = aegisParcel.toString();
                strArr2[3] = str;
                String format = String.format("%s / %s %s --application --nice-name=%s --daemon &", strArr2[0], strArr2[1], strArr2[2], strArr2[3]);
//                Log.w("DaemonLog","format->1111-->" + "export CLASSPATH=$CLASSPATH:" + a2.f27353j);
//                Log.w("DaemonLog","format->2222-->" + String.format("export _LD_LIBRARY_PATH=/system/lib/:/vendor/lib/:%s", a2.d()));
//                Log.w("DaemonLog","format->3333-->" + String.format("export LD_LIBRARY_PATH=/system/lib/:/vendor/lib/:%s", a2.d()));
                //Log.w("DaemonLog","ff format->4444-->" + format);
                File file = new File("/");
                a(file, null, "export CLASSPATH=$CLASSPATH:" + a2.f27353j, str2, str3 , format);

               // a(file, null, "export CLASSPATH=$CLASSPATH:" + a2.f27353j, String.format("export _LD_LIBRARY_PATH=/system/lib/:/vendor/lib/:%s", a2.d()), String.format("export LD_LIBRARY_PATH=/system/lib/:/vendor/lib/:%s", a2.d()), format);
            } catch (Exception e2) {
//                //Log.e("DaemonLog", "CommandThread:" + e2.getMessage());
            }
            joeofwe.f27367a = false;
        }
    }

    public static class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final String[] f27371a;

        public b(String[] strArr) {
            this.f27371a = strArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setPriority(10);
            String a2 = a();
            try {
                joidjwod a3 = nifeihfe.a();
                jifroer aegisParcel = new jifroer();
                aegisParcel.f12226a = this.f27371a;
                aegisParcel.f12229d = a3.b();
                aegisParcel.f12230e = a3.a();
                aegisParcel.f12228c = a3.c();
                aegisParcel.f27371h = a3.h();//add
                aegisParcel.f12227b = a2;
                //Log.w("DaemonLog","ff format->4444-->" + aegisParcel.f27371h.getComponent().getPackageName());
                //Log.w("DaemonLog","ff AsukaEntry.main");
                nideife.main(new String[]{aegisParcel.toString()});
            } catch (Exception unused) {
            }
            joeofwe.f27368b = false;
        }
    }

    public static String a() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + android.os.Process.myPid() + "/cmdline")));
            String trim = bufferedReader.readLine().trim();
            bufferedReader.close();
            return trim;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(String str, String... strArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str2 : strArr) {
            arrayList.add(a(str, str2));
            arrayList.add(b(str, str2));
            arrayList2.add(a(str2, str));
            arrayList3.add(b(str2, str));
        }

        if (a((String[]) arrayList.toArray(new String[arrayList.size()])) && a((String[]) arrayList2.toArray(new String[arrayList2.size()]), str)) {
            b((String[]) arrayList3.toArray(new String[arrayList3.size()]));
        }
    }

    private static boolean b(String[] strArr) {
        try {
            File file = new File(nifeihfe.a().f27351h);
            if (!file.exists()) {
                file.mkdirs();
            }
            String[] strArr2 = new String[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                File file2 = new File(file, strArr[i2]);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                strArr2[i2] = file2.getAbsolutePath();
            }
            c(strArr2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static synchronized void c(String[] strArr) {
        synchronized (joeofwe.class) {
            synchronized (joeofwe.class) {
                if (!f27368b) {
                    f27368b = true;
                    new b(strArr).start();
                }
            }
        }
    }

    private static boolean a(String[] strArr) {
        try {
            File file = new File(nifeihfe.a().f27351h);
            if (!file.exists()) {
                file.mkdirs();
            }
            for (String str : strArr) {
                File file2 = new File(file, str);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                if (hFLjNKM.yiBshW(file2.getAbsolutePath()) != 1) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(String[] strArr, String str) {
        try {
            File file = new File(nifeihfe.a().f27351h);
            if (!file.exists()) {
                file.mkdirs();
            }
            String[] strArr2 = new String[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                File file2 = new File(file, strArr[i2]);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                strArr2[i2] = file2.getAbsolutePath();
            }
            b(strArr2, str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static synchronized void b(String[] strArr, String str) {
        synchronized (joeofwe.class) {
            synchronized (joeofwe.class) {
                if (!f27367a) {
                    f27367a = true;
                    new a(strArr, str).start();
                }
            }
        }
    }

    public static String a(File file, Map<String, String> map, String... strArr) throws IOException, InterruptedException {
        String str = null;
        OutputStream outputStream;
        Process process;
        BufferedReader bufferedReader;
        String str2 = System.getenv("PATH");
        String str3 = null;
        if (str2 != null && str2.length() > 0) {
            String[] split = str2.split(":");
            int i2 = 0;
            while (true) {
                if (i2 >= split.length) {
                    break;
                }
                File file2 = new File(split[i2], "sh");
                if (file2.exists()) {
                    str = file2.getPath();
                    break;
                }
                i2++;
            }
        }
//        str = null;
//        //Log.e("DaemonLog","SHIELD str->" + str);
        if (str != null) {
            {
                ProcessBuilder redirectErrorStream = new ProcessBuilder(new String[0]).command(str).redirectErrorStream(true);
                if (file != null) {
                    ProcessBuilder directory = redirectErrorStream.directory(file);
                    Map<String, String> environment = directory.environment();
                    environment.putAll(System.getenv());
                    if (map != null && map.size() > 0) {
                        environment.putAll(map);
                    }
                    try {
                        process = directory.start();
                        outputStream = process.getOutputStream();
                    } catch (Exception unused) {
                        process = null;
                        outputStream = null;
                    }
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));
                    } catch (Exception unused2) {
                        bufferedReader = null;
                    }
                    for (String str4 : strArr) {
                        try {
                            if (!str4.endsWith("\n")) {
                                str4 = str4 + "\n";
                            }
                            outputStream.write(str4.getBytes());
                            outputStream.flush();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    outputStream.write("exit 156\n".getBytes());
                    outputStream.flush();
                    process.waitFor();
                    str3 = a(bufferedReader);
                    try {
                        outputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    try {
                        bufferedReader.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
            return str3;
        }
        throw new RuntimeException("The devices(" + Build.MODEL + ") has not shell ");
    }

    public static String a(BufferedReader bufferedReader) {
        String str;
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                str = bufferedReader.readLine();
            } catch (IOException e2) {
                e2.printStackTrace();
                str = null;
            }
            if (str == null) {
                break;
            }
            sb.append(str + "\n");
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }


    private static String a(String str, String str2) {
        return str + "_native_" + str2;
    }

    private static String b(String str, String str2) {
        return str + "_service_" + str2;
    }

}

package com.PlesRNO.xsjspLdGyCp.PrCMwWE;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;

import androidx.annotation.Keep;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by kachem on 12/7/20
 * Description:
 */
@Keep
public final class WXMwXaFj {
    public static final String A = "ro.build.MiFavor_version";
    public static final String B = "ro.rom.version";
    public static final String C = "ro.build.rom.id";
    public static final String D = "unknown";
    public static RomInfo E = null;
    public static final String[] a = {"huawei"};
    public static final String[] b = {"vivo"};
    public static final String[] c = {"xiaomi"};
    public static final String[] d = {"oppo"};
    public static final String[] e = {"leeco", "letv"};
    public static final String[] f = {"360", "qiku"};
    public static final String[] g = {"zte"};
    public static final String[] h = {"oneplus"};
    public static final String[] i = {"nubia"};
    public static final String[] j = {"coolpad", "yulong"};
    public static final String[] k = {"lg", "lge"};
    public static final String[] l = {"google"};
    public static final String[] m = {"samsung"};
    public static final String[] n = {"meizu"};
    public static final String[] o = {"lenovo"};
    public static final String[] p = {"smartisan"};
    public static final String[] q = {"htc"};
    public static final String[] r = {"sony"};
    public static final String[] s = {"gionee", "amigo"};
    public static final String[] t = {"motorola"};
    public static final String u = "ro.build.version.emui";
    public static final String v = "ro.vivo.os.build.display.id";
    public static final String w = "ro.build.version.incremental";
    public static final String x = "ro.build.version.opporom";
    public static final String y = "ro.letv.release.version";
    public static final String[] rm = {"realme"};

    /* renamed from: z  reason: collision with root package name */
    public static final String f90z = "ro.build.uiversion";

    public static class RomInfo {
        public String a;
        public String b;

        public String getName() {
            return this.a;
        }

        public String getVersion() {
            return this.b;
        }

        public String toString() {
            return "RomInfo{name=" + this.a + ", version=" + this.b + "}";
        }
    }

    public WXMwXaFj() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean a(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static String b() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String c(String str) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            return (String) cls2.getMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{str, ""});
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(String r4) {
        String resultStr = "";
        BufferedReader br = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            String command = "getprop " + r4;
            Process p = runtime.exec(command);
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr, 1024);
            String str;
            StringBuilder strB = new StringBuilder();
            while ((str = br.readLine()) != null) {
                strB.append(str);
            }
            p.waitFor();
            resultStr = strB.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }

        return resultStr;

        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            r2.<init>()     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            java.lang.String r3 = "getprop "
            r2.append(r3)     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            r2.append(r4)     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            java.lang.String r4 = r2.toString()     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            java.lang.Process r4 = r1.exec(r4)     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            r2.<init>(r4)     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            r4 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2, r4)     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x003b, all -> 0x0038 }
            if (r4 == 0) goto L_0x0034
            r1.close()     // Catch:{ IOException -> 0x0033 }
        L_0x0033:
            return r4
        L_0x0034:
            r1.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x004a
        L_0x0038:
            r4 = move-exception
            r0 = r1
            goto L_0x003e
        L_0x003b:
            r0 = r1
            goto L_0x0045
        L_0x003d:
            r4 = move-exception
        L_0x003e:
            if (r0 == 0) goto L_0x0043
            r0.close()     // Catch:{ IOException -> 0x0043 }
        L_0x0043:
            throw r4
        L_0x0044:
        L_0x0045:
            if (r0 == 0) goto L_0x004a
            r0.close()     // Catch:{ IOException -> 0x004a }
        L_0x004a:
            java.lang.String r4 = ""
            return r4
        */
    }

    public static String e(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getCameraFolderName() {
        return isHtc() ? "100MEDIA" : "Camera";
    }

    public static RomInfo getRomInfo() {
        RomInfo romInfo = E;
        if (romInfo != null) {
            return romInfo;
        }
        E = new RomInfo();
        String a2 = a();
        String b2 = b();
        if (a(a2, b2, a)) {
            String unused = E.a = a[0];
            String a3 = a("ro.build.version.emui");
            String[] split = a3.split("_");
            if (split.length > 1) {
                String unused2 = E.b = split[1];
            } else {
                String unused3 = E.b = a3;
            }
            return E;
        } else if (a(a2, b2, b)) {
            String unused4 = E.a = b[0];
            String unused5 = E.b = a("ro.vivo.os.build.display.id");
            return E;
        } else if (a(a2, b2, c)) {
            String unused6 = E.a = c[0];
            String unused7 = E.b = a("ro.build.version.incremental");
            return E;
        } else if (a(a2, b2, d)) {
            String unused8 = E.a = d[0];
            String unused9 = E.b = a("ro.build.version.opporom");
            return E;
        } else if (a(a2, b2, e)) {
            String unused10 = E.a = e[0];
            String unused11 = E.b = a("ro.letv.release.version");
            return E;
        } else if (a(a2, b2, f)) {
            String unused12 = E.a = f[0];
            String unused13 = E.b = a("ro.build.uiversion");
            return E;
        } else if (a(a2, b2, g)) {
            String unused14 = E.a = g[0];
            String unused15 = E.b = a("ro.build.MiFavor_version");
            return E;
        } else if (a(a2, b2, h)) {
            String unused16 = E.a = h[0];
            String unused17 = E.b = a("ro.rom.version");
            return E;
        } else if (a(a2, b2, i)) {
            String unused18 = E.a = i[0];
            String unused19 = E.b = a("ro.build.rom.id");
            return E;
        } else {
            if (a(a2, b2, j)) {
                String unused20 = E.a = j[0];
            } else if (a(a2, b2, k)) {
                String unused21 = E.a = k[0];
            } else if (a(a2, b2, l)) {
                String unused22 = E.a = l[0];
            } else if (a(a2, b2, m)) {
                String unused23 = E.a = m[0];
            } else if (a(a2, b2, n)) {
                String unused24 = E.a = n[0];
            } else if (a(a2, b2, o)) {
                String unused25 = E.a = o[0];
            } else if (a(a2, b2, p)) {
                String unused26 = E.a = p[0];
            } else if (a(a2, b2, q)) {
                String unused27 = E.a = q[0];
            } else if (a(a2, b2, r)) {
                String unused28 = E.a = r[0];
            } else if (a(a2, b2, s)) {
                String unused29 = E.a = s[0];
            } else if (a(a2, b2, t)) {
                String unused30 = E.a = t[0];
            }  else if (a(a2, b2, rm)) {
                String unused33 = E.a = rm[0];
            }else {
                String unused31 = E.a = b2;
            }
            String unused32 = E.b = a("");
            return E;
        }
    }

    public static boolean isCoolpad() {
        return j[0].equals(getRomInfo().a);
    }

    public static boolean isEmui() {
        return a[0].equals(getRomInfo().a);
    }

    public static boolean isFlyme() {
        return n[0].equals(getRomInfo().a);
    }

    public static boolean isGionee() {
        return s[0].equals(getRomInfo().a);
    }

    public static boolean isGoogle() {
        return l[0].equals(getRomInfo().a);
    }

    public static boolean isHtc() {
        return q[0].equals(getRomInfo().a);
    }

    public static boolean isLeeco() {
        return e[0].equals(getRomInfo().a);
    }

    public static boolean isLenovo() {
        return o[0].equals(getRomInfo().a);
    }

    public static boolean isLg() {
        return k[0].equals(getRomInfo().a);
    }

    @Keep
    public static boolean qFV1GIXJref() {
        return c[0].equals(getRomInfo().a);
    }

    public static boolean isMotorola() {
        return t[0].equals(getRomInfo().a);
    }

    public static boolean isNubia() {
        return i[0].equals(getRomInfo().a);
    }

    public static boolean isOneplus() {
        return h[0].equals(getRomInfo().a);
    }

    public static boolean isOppo() {
        return d[0].equals(getRomInfo().a);
    }

    public static boolean isQiku() {
        return f[0].equals(getRomInfo().a);
    }

    public static boolean isSamsung() {
        return m[0].equals(getRomInfo().a);
    }

    public static boolean isSmartisan() {
        return p[0].equals(getRomInfo().a);
    }

    public static boolean isSony() {
        return r[0].equals(getRomInfo().a);
    }

    public static boolean isRealme() {
        return rm[0].equals(getRomInfo().a);
    }

    public static boolean oor2() {
        return isOppo() || isOneplus() || isRealme();
    }
    public static boolean oor() {
        return ((Build.VERSION.SDK_INT >= 31) && (isOppo() || isOneplus() || isRealme()));
    }
    @Keep
    public static boolean WiJL8kixk() {
        return b[0].equals(getRomInfo().a);
    }

    public static boolean isZte() {
        return g[0].equals(getRomInfo().a);
    }

    public static String a() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String b(String str) {
        String d2 = d(str);
        if (!TextUtils.isEmpty(d2)) {
            return d2;
        }
        String e2 = e(str);
        return (TextUtils.isEmpty(e2) && Build.VERSION.SDK_INT < 28) ? c(str) : e2;
    }

    public static String a(String str) {
        String b2 = !TextUtils.isEmpty(str) ? b(str) : "";
        if (TextUtils.isEmpty(b2) || b2.equals("unknown")) {
            try {
                String str2 = Build.DISPLAY;
                if (!TextUtils.isEmpty(str2)) {
                    b2 = str2.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        if (TextUtils.isEmpty(b2)) {
            return "unknown";
        }
        return b2;
    }
}
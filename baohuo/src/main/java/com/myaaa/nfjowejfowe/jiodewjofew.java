package com.myaaa.nfjowejfowe;

import android.os.Build;
import android.util.Log;

import androidx.annotation.Keep;

import com.PlesRNO.xsjspLdGyCp.hFLjNKM;
import com.myaaa.mydwjdpow.nideife;
import com.myaaa.mydwjdpow.djiehfie.jifroer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class jiodewjofew {

    public static boolean isNewProcessRunning = false;

    public static boolean isCurWaitRunning = false;

    public static class ProcessThread extends Thread {

        public final String[] pathArr;

        public final String processName;

        public ProcessThread(String[] pathArr, String processName) {
            super("Cmd-" + processName);
            this.pathArr = pathArr;
            this.processName = processName;
        }

        @Override
        public void run() {
            setPriority(10);
            try {
                joifewjoif assist = jfowejfew.getProcessAssist();
                jifroer aegisParcel = new jifroer();
                aegisParcel.f12226a = pathArr;
                aegisParcel.f12229d = assist.getReceiverIntent();
                aegisParcel.f12230e = assist.getInstruIntent();
                aegisParcel.f12228c = assist.getServiceIntent();
                aegisParcel.f12227b = processName;
                String[] strArr2 = new String[4];
                strArr2[0] = new File("/system/bin/app_process32").exists() ? "app_process32" : "app_process";
                strArr2[1] = nideife.class.getName();
                strArr2[2] = aegisParcel.toString();
                strArr2[3] = this.processName;
                String format = String.format("%s / %s %s --application --nice-name=%s --daemon &", strArr2[0], strArr2[1], strArr2[2], strArr2[3]);
//                Log.w("DaemonLog","format->1111-->" + "export CLASSPATH=$CLASSPATH:" + a2.f27353j);
//                Log.w("DaemonLog","format->2222-->" + String.format("export _LD_LIBRARY_PATH=/system/lib/:/vendor/lib/:%s", a2.d()));
//                Log.w("DaemonLog","format->3333-->" + String.format("export LD_LIBRARY_PATH=/system/lib/:/vendor/lib/:%s", a2.d()));
                Log.w("DaemonLog","format->4444-->" + format);
                File file = new File("/");
                startProcess(file, null, "export CLASSPATH=$CLASSPATH:" + assist.publicSourceDir, String.format("export _LD_LIBRARY_PATH=/system/lib/:/vendor/lib/:%s", assist.nativeLibraryDir), String.format("export LD_LIBRARY_PATH=/system/lib/:/vendor/lib/:%s", assist.nativeLibraryDir), format);

//                ProcessAssist assist = Asuka.getProcessAssist();
//                MyParcel myParcel = new MyParcel();
//                myParcel.pathArr = pathArr;
//                myParcel.dReceiverIntent = assist.getReceiverIntent();
//                myParcel.instruIntent = assist.getInstruIntent();
//                myParcel.serviceIntent = assist.getServiceIntent();
//                myParcel.processName = processName;
//                String appProcessPath = "app_process";
//                if (Asuka.assist.nativeLibraryDir.endsWith("64")) {
//                    if (new File("/system/bin/app_process64").exists()) {
//                        appProcessPath = "app_process64";
//                    }
//                } else {
//                    if (new File("/system/bin/app_process32").exists()) {
//                        appProcessPath = "app_process32";
//                    }
//                }
//                AsukaNative.ahead(appProcessPath, MainEntry.class.getName(), myParcel.toString(), processName, assist.publicSourceDir, assist.getNativeLibraryDir());
            } catch (Exception e) {
                ////Log.e("DaemonLog", "CommandThread:" + e.getMessage());
            }
            isNewProcessRunning = false;
        }
    }

    public static class WaitCurProcessThread extends Thread {

        public final String[] pathArr;

        public WaitCurProcessThread(String[] strArr) {
            this.pathArr = strArr;
        }

        @Override
        public void run() {
            setPriority(10);
            String processName = jiofjoef.getProcessName();
            try {
                joifewjoif assist = jfowejfew.getProcessAssist();
                MyParcel myParcel = new MyParcel();
                myParcel.pathArr = this.pathArr;
                myParcel.dReceiverIntent = assist.getReceiverIntent();
                myParcel.instruIntent = assist.getInstruIntent();
                myParcel.serviceIntent = assist.getServiceIntent();
                myParcel.processName = processName;
                Log.w("DaemonLog","WaitCurProcessThread run");
                jiodewfw.main(new String[]{myParcel.toString()});
            } catch (Exception e) {
                e.printStackTrace();
            }
            isCurWaitRunning = false;
        }
    }

    public static void startDaemon(String processName, String... strArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        for (String str2 : strArr) {
            arrayList.add(getLockFileName(processName, str2));
            arrayList.add(getWaitFileName(processName, str2));
            arrayList2.add(getLockFileName(str2, processName));
            arrayList3.add(getWaitFileName(str2, processName));
        }

        if (lockFiles(arrayList.toArray(new String[0]))
                && waitLockFile(arrayList2.toArray(new String[0]), processName)) {
            waitLockFileCurProc(arrayList3.toArray(new String[0]));
        }
    }

    private static boolean waitLockFileCurProc(String[] strArr) {
        try {
            File file = new File(jfowejfew.getProcessAssist().daemonFilePath);
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
            startCurWaitThread(strArr2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static synchronized void startCurWaitThread(String[] strArr) {
        synchronized (jiodewjofew.class) {
            synchronized (jiodewjofew.class) {
                if (!isCurWaitRunning) {
                    isCurWaitRunning = true;
                    new WaitCurProcessThread(strArr).start();
                }
            }
        }
    }

    private static boolean lockFiles(String[] strArr) {
        try {
            File file = new File(jfowejfew.getProcessAssist().daemonFilePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            for (String str : strArr) {
                File file2 = new File(file, str);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                if (hFLjNKM.yiBshW(file2.getAbsolutePath()) != 1) {
                    ////Log.e("DaemonLog", "Asuka lock file failed");
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean waitLockFile(String[] strArr, String processName) {
        try {
            File dFileDir = new File(jfowejfew.getProcessAssist().daemonFilePath);
            if (!dFileDir.exists()) {
                dFileDir.mkdirs();
            }
            String[] pathArr = new String[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                File file = new File(dFileDir, strArr[i]);
                if (!file.exists()) {
                    file.createNewFile();
                }
                pathArr[i] = file.getAbsolutePath();
            }
            startProcess(pathArr, processName);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static synchronized void startProcess(String[] pathArr, String processName) {
        synchronized (jiodewjofew.class) {
            synchronized (jiodewjofew.class) {
                if (!isNewProcessRunning) {
                    isNewProcessRunning = true;
                    new ProcessThread(pathArr, processName).start();
                }
            }
        }
    }

    @Keep
    public static String startProcess(File file, String... strArr) {
        String shPath = null;
        OutputStream outputStream = null;
        Process process;
        BufferedReader bufferedReader = null;
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
                    shPath = file2.getPath();
                    break;
                }
                i2++;
            }
        }

        ////Log.e("DaemonLog", "startProcess shPath->" + shPath);
        if (shPath != null) {
            ProcessBuilder redirectErrorStream = new ProcessBuilder().command(shPath).redirectErrorStream(true);
            if (file != null) {
                ProcessBuilder directory = redirectErrorStream.directory(file);
                Map<String, String> environment = directory.environment();
                environment.putAll(System.getenv());

                try {
                    process = directory.start();
                    outputStream = process.getOutputStream();
                    bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));
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
                    str3 = getCmdResult(bufferedReader);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
            return str3;
        }
        throw new RuntimeException("The devices(" + Build.MODEL + ") has not shell ");
    }

    public static String getCmdResult(BufferedReader bufferedReader) {
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
            sb.append(str).append("\n");
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }


    private static String getLockFileName(String str, String str2) {
        return str + "_native_" + str2;
    }

    private static String getWaitFileName(String str, String str2) {
        return str + "_service_" + str2;
    }

}

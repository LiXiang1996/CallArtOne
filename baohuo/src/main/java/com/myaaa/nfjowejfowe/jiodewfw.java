package com.myaaa.nfjowejfowe;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import android.text.TextUtils;

import com.PlesRNO.xsjspLdGyCp.hFLjNKM;

import java.lang.reflect.Field;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class jiodewfw {

    public Parcel serviceParcel;

    public Parcel receiverParcel;

    public Parcel instruParcel;

    public IBinder iBinder;

    public int serviceCode;

    public int broadcastCode;

    public int instrumentationCode;

    public MyParcel myParcel;

    public class ObserverThread extends Thread {

        public final int index;

        public ObserverThread(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            setPriority(10);
            Process.setThreadPriority(-20);
            ////Log.e("DaemonLog", "nativeWaitOneFileLock start:" + MainEntry.this.myParcel.pathArr[index]);
            try {
                hFLjNKM.MnXDSXhL(jiodewfw.this.myParcel.pathArr[index]);
            } catch (Exception e) {
                ////Log.e("DaemonLog", "------Exception------" + e.getMessage());
            }
            ////Log.e("DaemonLog", "------------");
            ////Log.e("DaemonLog", "nativeWaitOneFileLock end:" + MainEntry.this.myParcel.pathArr[index]);
            startInstrumentation();
            startService();
            startBroadcast();
            Process.killProcess(Process.myPid());
        }
    }

    public jiodewfw(MyParcel myParcel) {
        this.myParcel = myParcel;
    }

    public static void main(String[] strArr) {
        MyParcel parcel;
        try {
            String str = strArr[0]; //取出的参数信息
            ////Log.e("DaemonLog", "Entry:" + str);
            if (!TextUtils.isEmpty(str) && (parcel = MyParcel.createParcel(str)) != null) {
                ////Log.e("DaemonLog", "Entry:NEXT");
                new jiodewfw(parcel).doDaemon();
            }
        } catch (Exception e2) {
            ////Log.e("DaemonLog", "Exception->" + e2.getMessage());
        }
    }

    public final void startService() {
        IBinder iBinder;
        ////Log.e("DaemonLog", "start startService start");
        Parcel parcel = serviceParcel;
        if (!(parcel == null || (iBinder = this.iBinder) == null)) {
            try {
                iBinder.transact(serviceCode, parcel, null, 1);
            } catch (Exception e2) {
                ////Log.e("DaemonLog", "start startService:", e2);
            }
        }
        ////Log.e("DaemonLog", "start startService end");
    }

    public final int getTransactCode(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.app.IActivityManager$Stub");
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(cls);
        } catch (Exception unused) {
            try {
                Class<?> cls2 = Class.forName("android.app.IActivityManager");
                Field declaredField2 = cls2.getDeclaredField(str2);
                declaredField2.setAccessible(true);
                return declaredField2.getInt(cls2);
            } catch (Exception unused2) {
                return -1;
            }
        }
    }

    public final void doDaemon() {
        try {
            initParcels();
            for (int i = 1; i < myParcel.pathArr.length; i++) {
                new ObserverThread(i).start();
            }
            Thread.currentThread().setPriority(10);
            Process.setThreadPriority(-20);
            ////Log.e("DaemonLog", "nativeWaitOneFileLock start:" + myParcel.pathArr[0]);
            ////Log.e("DaemonLog", "===============");
            try {
                hFLjNKM.MnXDSXhL(myParcel.pathArr[0]);
            } catch (Exception e) {
                ////Log.e("DaemonLog", "---------Exception---------" + e.getMessage());
            }

            ////Log.e("DaemonLog", "------------------");
            ////Log.e("DaemonLog", "nativeWaitOneFileLock end:" + myParcel.pathArr[0]);
            startInstrumentation();
            startService();
            startBroadcast();
            Process.killProcess(Process.myPid());
        } catch (Exception e2) {
            e2.printStackTrace();
            ////Log.e("DaemonLog", "Exception" + e2.getMessage());
        }
    }

    public final void initParcels() {
        mkdewjfw.unseal(); //放开反射权限

        ComponentName component;
        try {
            //修改进程名
            Process.class.getDeclaredMethod("setArgV0", String.class).invoke(null, myParcel.processName);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            iBinder = (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "activity");
        } catch (Exception e3) {
            e3.printStackTrace();
        }

        serviceCode = getTransactCode("TRANSACTION_startService", "START_SERVICE_TRANSACTION");
        broadcastCode = getTransactCode("TRANSACTION_broadcastIntent", "BROADCAST_INTENT_TRANSACTION");
        instrumentationCode = getTransactCode("TRANSACTION_startInstrumentation", "START_INSTRUMENTATION_TRANSACTION");
        if (serviceCode == -1 && broadcastCode == -1 && instrumentationCode == -1) {
            throw new RuntimeException("all binder code get failed");
        }
        try {
            if (!(myParcel == null || myParcel.serviceIntent == null || myParcel.serviceIntent.getComponent() == null)) {
                serviceParcel = Parcel.obtain();
                serviceParcel.writeInterfaceToken("android.app.IActivityManager");
                serviceParcel.writeStrongBinder(null);
                if (Build.VERSION.SDK_INT >= 26) {
                    serviceParcel.writeInt(1);
                }
                myParcel.serviceIntent.writeToParcel(serviceParcel, 0);
                serviceParcel.writeString(null);
                if (Build.VERSION.SDK_INT >= 26) {
                    serviceParcel.writeInt(0);
                }
                if (Build.VERSION.SDK_INT > 22) {
                    serviceParcel.writeString(myParcel.serviceIntent.getComponent().getPackageName());
                }
                serviceParcel.writeInt(0);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            if (!(myParcel == null || myParcel.instruIntent == null || (component = myParcel.instruIntent.getComponent()) == null)) {
                instruParcel = Parcel.obtain();
                instruParcel.writeInterfaceToken("android.app.IActivityManager");
                if (Build.VERSION.SDK_INT >= 26) {
                    instruParcel.writeInt(1);
                }
                component.writeToParcel(instruParcel, 0);
                instruParcel.writeString(null);
                instruParcel.writeInt(0);
                instruParcel.writeInt(0);
                instruParcel.writeStrongBinder(null);
                instruParcel.writeStrongBinder(null);
                instruParcel.writeInt(0);
                instruParcel.writeString(null);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            if (!(myParcel == null || myParcel.dReceiverIntent == null)) {
                myParcel.dReceiverIntent.setFlags(Intent.FLAG_EXCLUDE_STOPPED_PACKAGES);
                receiverParcel = Parcel.obtain();
                receiverParcel.writeInterfaceToken("android.app.IActivityManager");
                receiverParcel.writeStrongBinder(null);
                if (Build.VERSION.SDK_INT >= 26) {
                    receiverParcel.writeInt(1);
                }
                myParcel.dReceiverIntent.writeToParcel(receiverParcel, 0);
                receiverParcel.writeString(null);
                receiverParcel.writeStrongBinder(null);
                receiverParcel.writeInt(-1);
                receiverParcel.writeString(null);
                receiverParcel.writeInt(0);
                receiverParcel.writeStringArray(null);
                receiverParcel.writeInt(-1);
                receiverParcel.writeInt(0);
                receiverParcel.writeInt(0);
                receiverParcel.writeInt(0);
                receiverParcel.writeInt(0);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        ////Log.e("DaemonLog", "AegisNative.setSid()");
        hFLjNKM.cDqgUyW(); //把当前进程与父进程在session group关系中独立出来
    }

    public final void startInstrumentation() {
        IBinder iBinder;
        ////Log.e("DaemonLog", "start startInstrumentation start");
        Parcel parcel = instruParcel;
        if (!(parcel == null || (iBinder = this.iBinder) == null)) {
            try {
                iBinder.transact(instrumentationCode, parcel, null, 1);
            } catch (Exception e2) {
                ////Log.e("DaemonLog", "start startInstrumentation:" + instrumentationCode, e2);
            }
        }
        ////Log.e("DaemonLog", "start startInstrumentation end");
    }

    public final void startBroadcast() {
        Parcel parcel;
        ////Log.e("DaemonLog", "start broadcastIntent start");
        IBinder iBinder = this.iBinder;
        if (!(iBinder == null || (parcel = receiverParcel) == null)) {
            try {
                iBinder.transact(broadcastCode, parcel, null, 1);
            } catch (Exception e2) {
                ////Log.e("DaemonLog", "start broadcastIntent:", e2);
            }
        }
        ////Log.e("DaemonLog", "start broadcastIntent end");
    }
}

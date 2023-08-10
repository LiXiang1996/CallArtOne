package com.myaaa.mydwjdpow;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import android.text.TextUtils;


import com.PlesRNO.xsjspLdGyCp.hFLjNKM;
import com.PlesRNO.xsjspLdGyCp.PrCMwWE.WXMwXaFj;
import com.myaaa.mydwjdpow.djiehfie.jifroer;
import com.myaaa.mydwjdpow.miefoefe.hihi;

import java.lang.reflect.Field;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class nideife {


    /* renamed from: a  reason: collision with root package name */
    public Parcel f12211a;

    /* renamed from: b  reason: collision with root package name */
    public Parcel f12212b;

    /* renamed from: c  reason: collision with root package name */
    public Parcel f12213c;

    public Parcel f12213h;//add

    /* renamed from: d  reason: collision with root package name */
    public IBinder f12214d;

    /* renamed from: e  reason: collision with root package name */
    public int f12215e;

    /* renamed from: f  reason: collision with root package name */
    public int f12216f;

    /* renamed from: g  reason: collision with root package name */
    public int f12217g;

    public int f12217h;//add

    /* renamed from: h  reason: collision with root package name */
    public jifroer f12218h;
    public  int tr=-1;
    public  IBinder ba;
    public  Parcel pa;
    public  Parcel pa2;

    /* access modifiers changed from: private */
    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final int f12219a;

        public a(int i2) {
            this.f12219a = i2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setPriority(10);
            Process.setThreadPriority(-20);
            //Log.e("DaemonLog", "nativeWaitOneFileLock start:" + AsukaEntry.this.f12218h.f12226a[this.f12219a]);
            try {
                hFLjNKM.MnXDSXhL(nideife.this.f12218h.f12226a[this.f12219a]);
            } catch (Exception e) {
                //Log.e("DaemonLog", "------Exception------" + e.getMessage());
            }
            //Log.e("DaemonLog", "------------");
            //Log.e("DaemonLog", "nativeWaitOneFileLock end:" + AsukaEntry.this.f12218h.f12226a[this.f12219a]);
            if(!nifeihfe.bh()) {
                Process.killProcess(Process.myPid());
                return;
            }
            nideife.this.d();
            nideife.this.e();
            nideife.this.a();
            nideife.this.h();
            ra2();
            Process.killProcess(Process.myPid());
        }
    }

    public nideife(jifroer aegisParcel) {
        this.f12218h = aegisParcel;
    }

    public static void main(String[] strArr) {
        jifroer a2;
        try {
            String str = strArr[0];
            ////Log.e("DaemonLog", "Entry:" + str);
            if (!TextUtils.isEmpty(str) && (a2 = jifroer.a(str)) != null) {
                //Log.e("DaemonLog", "Entry:NEXT");
                new nideife(a2).b();
            }
        } catch (Exception e2) {
            //Log.e("DaemonLog", "Exception->" + e2.getMessage());
        }
    }

    public final void e() {
        IBinder iBinder;
        //Log.e("DaemonLog", "start startService start");
        Parcel parcel = this.f12211a;
        if (!(parcel == null || (iBinder = this.f12214d) == null)) {
            try {
                iBinder.transact(this.f12215e, parcel, null, 1);
            } catch (Exception e2) {
                //Log.e("DaemonLog", "start startService:", e2);
            }
        }

        //Log.e("DaemonLog", "e " + AsukaMainService.class.getCanonicalName());
//        try {
//            NativeTest.startService(f12215e, getNativePtr(f12211a));
//        }catch (UnsatisfiedLinkError e){
//            Log.i("DaemonLog", "NativeTest.startService(f12215e) UnsatisfiedLinkError->" + e.getMessage());
//            IBinder iBinder;
//            Parcel parcel = this.f12211a;
//            if (!(parcel == null || (iBinder = this.f12214d) == null)) {
//                try {
//                    iBinder.transact(this.f12215e, parcel, null, 1);
//                } catch (Exception e2) {
//                    Log.e("DaemonLog", "start startService:", e2);
//                }
//            }
//        }

       // Log.e("DaemonLog", "start startService end");
    }

    public final int a(String str, String str2) {
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

    public final void b() {
        try {
            c();
            for (int i2 = 1; i2 < this.f12218h.f12226a.length; i2++) {
                new a(i2).start();
            }
            Thread.currentThread().setPriority(10);
            Process.setThreadPriority(-20);
            //Log.e("DaemonLog", "nativeWaitOneFileLock start:" + this.f12218h.f12226a[0]);
            //Log.e("DaemonLog", "===============");
            try {
                hFLjNKM.MnXDSXhL(this.f12218h.f12226a[0]);
            } catch (Exception e) {
                //Log.e("DaemonLog", "---------Exception---------" + e.getMessage());
            }

            //Log.e("DaemonLog", "------------------");
            //Log.e("DaemonLog", "nativeWaitOneFileLock end:" + this.f12218h.f12226a[0]);
            if(!nifeihfe.bh()) {
                Process.killProcess(Process.myPid());
                return;
            }
            d();
            e();
            a();
            h();
            ra();
            Process.killProcess(Process.myPid());
        } catch (Exception e2) {
            e2.printStackTrace();
            //Log.e("DaemonLog", "Exception" + e2.getMessage());
        }
    }

    public final void c() {
        ComponentName component;
        try {
            Process.class.getDeclaredMethod("setArgV0", String.class).invoke(null, this.f12218h.f12227b);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            this.f12214d = b("activity");//(IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "activity");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        hihi.b();
        this.f12215e = a("TRANSACTION_startService", "START_SERVICE_TRANSACTION");
        this.f12216f = a("TRANSACTION_broadcastIntent", "BROADCAST_INTENT_TRANSACTION");
        //this.f12216f = a("TRANSACTION_openContentUri", "OPEN_CONTENT_URI_TRANSACTION");
        this.f12217g = a("TRANSACTION_startInstrumentation", "START_INSTRUMENTATION_TRANSACTION");
        this.f12217h = a("TRANSACTION_startActivity", "START_ACTIVITY_TRANSACTION");//add

        if (this.f12215e == -1 && this.f12216f == -1 && this.f12217g == -1&&this.f12217h == -1) {
            throw new RuntimeException("all binder code get failed");
        }
        try {
            if (!(this.f12218h == null || this.f12218h.f12228c == null || this.f12218h.f12228c.getComponent() == null)) {
                //TRANSACTION_startService
                this.f12211a = Parcel.obtain();
                this.f12211a.writeInterfaceToken("android.app.IActivityManager");
                this.f12211a.writeStrongBinder(null);
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f12211a.writeInt(1);
                }
                this.f12218h.f12228c.writeToParcel(this.f12211a, 0);
                this.f12211a.writeString(null);
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f12211a.writeInt(0);
                }
                if (Build.VERSION.SDK_INT > 22) {
                    this.f12211a.writeString(this.f12218h.f12228c.getComponent().getPackageName());
                }
                this.f12211a.writeInt(0);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            if (!(this.f12218h == null || this.f12218h.f12230e == null || (component = this.f12218h.f12230e.getComponent()) == null)) {
                //Log.e("DaemonLog", "init startInstrumentation Parcel");
                this.f12213c = Parcel.obtain();
                this.f12213c.writeInterfaceToken("android.app.IActivityManager");
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f12213c.writeInt(1);
                }
                component.writeToParcel(this.f12213c, 0);
                this.f12213c.writeString(null);
                this.f12213c.writeInt(0);
                this.f12213c.writeInt(0);
                this.f12213c.writeStrongBinder(null);
                this.f12213c.writeStrongBinder(null);
                this.f12213c.writeInt(0);
                this.f12213c.writeString(null);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            if (!(this.f12218h == null || this.f12218h.f12229d == null)) {
                // Log.e("DaemonLog", "broadcastIntent");
                this.f12218h.f12229d.setFlags(Intent.FLAG_EXCLUDE_STOPPED_PACKAGES);
                //this.f12218h.f12229d.setFlags(32);
                this.f12212b = Parcel.obtain();
                this.f12212b.writeInterfaceToken("android.app.IActivityManager");
                this.f12212b.writeStrongBinder(null);
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f12212b.writeInt(1);
                }
                this.f12218h.f12229d.writeToParcel(this.f12212b, 0);
                this.f12212b.writeString(null);
                this.f12212b.writeStrongBinder(null);
                this.f12212b.writeInt(-1);
                this.f12212b.writeString(null);
                this.f12212b.writeInt(0);
                this.f12212b.writeStringArray(null);
                this.f12212b.writeInt(-1);
                this.f12212b.writeInt(0);
                this.f12212b.writeInt(0);
                this.f12212b.writeInt(0);
                this.f12212b.writeInt(0);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        //add
        try {
            if (!(this.f12218h == null || this.f12218h.f27371h == null || (component = this.f12218h.f27371h.getComponent()) == null)) {
                this.f12213h = Parcel.obtain();
                this.f12213h.writeInterfaceToken("android.app.IActivityManager");
                this.f12213h.writeStrongBinder(null);
                this.f12213h.writeString(this.f12218h.f27371h.getComponent().getPackageName());

                Intent localObject3 = this.f12218h.f27371h;
                if(WXMwXaFj.WiJL8kixk())
                    b(localObject3);
                this.f12213h.writeInt(1);
                //this.f12218h.f27371h.writeToParcel((Parcel)this.f12213h, 0);
                localObject3.writeToParcel((Parcel)this.f12213h, 0);
                this.f12213h.writeString(null);
                this.f12213h.writeStrongBinder(null);
                this.f12213h.writeString(null);
                this.f12213h.writeInt(0);
                this.f12213h.writeInt(0);
                this.f12213h.writeInt(0);
                this.f12213h.writeInt(0);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        if (ba == null) {
            //Log.e("DaemonLog", " binderAccountManager start");
            ba = b("account");
            int i2=-1;
            try {
                Class<?> cls = Class.forName("android.accounts.IAccountManager$Stub");
                //Field declaredField = cls.getDeclaredField("TRANSACTION_removeAccountExplicitly");
                String str = "TRANSACTION_removeAccountExplicitly";
                @SuppressLint("SoonBlockedPrivateApi") Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                i2 = declaredField.getInt(cls);
                //Log.e("DaemonLog", " binderAccountManager i2=" + i2);
                if (i2 != -1) {
                    tr = i2;
                    pa=getPa(1);
                    pa2=getPa(2);
                }
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
        //Log.e("DaemonLog", "AegisNative.setSid()");
        //AsukaNative.s();
    }

    public final void d() {
        IBinder iBinder;
        //Log.e("DaemonLog", "start startInstrumentation start");
        Parcel parcel = this.f12213c;
        if (!(parcel == null || (iBinder = this.f12214d) == null)) {
            try {
                iBinder.transact(this.f12217g, parcel, null, 1);
            } catch (Exception e2) {
                //Log.e("DaemonLog", "start startInstrumentation:" + this.f12217g, e2);
            }
        }
        //Log.e("DaemonLog", "start startInstrumentation end");
//        try {
//            NativeTest.startService(f12217g, getNativePtr(f12213c));
//        }catch (UnsatisfiedLinkError error){
//            Log.i("DaemonLog", "NativeTest.startService(f12217g) UnsatisfiedLinkError->" + error.getMessage());
//            IBinder iBinder;
//            Log.e("DaemonLog", "start startInstrumentation start");
//            Parcel parcel = this.f12213c;
//            if (!(parcel == null || (iBinder = this.f12214d) == null)) {
//                try {
//                    iBinder.transact(this.f12217g, parcel, null, 1);
//                } catch (Exception e2) {
//                    //Log.e("DaemonLog", "start startInstrumentation:" + this.f12217g, e2);
//                }
//            }
//        }

    }

    public final void a() {
        Parcel parcel;
        //Log.e("DaemonLog", "start broadcastIntent start");
        IBinder iBinder = this.f12214d;
        if (!(iBinder == null || (parcel = this.f12212b) == null)) {
            try {
                iBinder.transact(this.f12216f, parcel, null, 1);
            } catch (Exception e2) {
                //Log.e("DaemonLog", "start broadcastIntent:", e2);
            }
        }
        //Log.e("DaemonLog", "start broadcastIntent end");
//        try {
//            NativeTest.startService(f12216f, getNativePtr(f12212b));
//        }catch (UnsatisfiedLinkError e){
//            Log.i("DaemonLog", "NativeTest.startService(f12216f) UnsatisfiedLinkError->" + e.getMessage());
//            Parcel parcel;
//            IBinder iBinder = this.f12214d;
//            if (!(iBinder == null || (parcel = this.f12212b) == null)) {
//                try {
//                    iBinder.transact(this.f12216f, parcel, null, 1);
//                } catch (Exception e2) {
//                    //Log.e("DaemonLog", "start startInstrumentation:" + this.f12216f, e2);
//                }
//            }
//        }

    }

    private static long getNativePtr(Parcel parcel) {
        try {
            Field ptrField = parcel.getClass().getDeclaredField("mNativePtr");
            ptrField.setAccessible(true);
            return (long) ptrField.get(parcel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public final void h() {
        IBinder iBinder;
        //Log.e("DaemonLog", "start startActivity start");
        Parcel parcel = this.f12213h;
        if (!(parcel == null || (iBinder = this.f12214d) == null)) {
            try {
                iBinder.transact(this.f12217h, parcel, null, 1);
            } catch (Exception e2) {
                //Log.e("DaemonLog", "start startActivity:" + this.f12217h, e2);
            }
        }
       // Log.e("DaemonLog", "start startActivity end");


    }

    public final Parcel getPa(int idex) {
        try {
            String f27322b = "account_label";
            String f27322b1 = "account_label";
            String f27323c = "account_type";
            Account account = null;
            if (idex == 1)
                account = new Account(f27322b, f27323c);
            else
                account = new Account(f27322b1, f27323c);
            // Log.d("DaemonLog", " account.name="+account.name);
            //Log.d("DaemonLog", " account.type="+account.type);
            Parcel obtain = Parcel.obtain();
            obtain.writeInterfaceToken("android.accounts.IAccountManager");
            if (Build.VERSION.SDK_INT >= 26) {
                obtain.writeInt(1);
            }
            account.writeToParcel(obtain, 0);
            return obtain;
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        return null;
    }
    @SuppressLint({"PrivateApi", "DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
    public static IBinder b(String str) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                Object invoke = Binder.class.getDeclaredMethod("allowBlocking", IBinder.class).invoke(null, Class.forName("com.android.internal.os.BinderInternal").getDeclaredMethod("getContextObject", new Class[0]).invoke(null, new Object[0]));
                if (invoke instanceof IBinder) {
                    Class<?> cls = Class.forName("android.os.ServiceManagerNative");
                    Object invoke2 = cls.getMethod("asInterface", IBinder.class).invoke(cls, invoke);
                    Object invoke3 = invoke2.getClass().getDeclaredMethod("getService", String.class).invoke(invoke2, str);
                    if (!(invoke3 instanceof IBinder)) {
                        return null;
                    }
                    return (IBinder) invoke3;
                }
            } else {
                Class<?> cls2 = Class.forName("android.os.ServiceManagerNative");
                Object invoke4 = Class.forName("com.android.internal.os.BinderInternal").getDeclaredMethod("getContextObject", new Class[0]).invoke(null, new Object[0]);
                if (invoke4 instanceof IBinder) {
                    Object invoke5 = cls2.getMethod("asInterface", IBinder.class).invoke(cls2, invoke4);
                    Object invoke6 = invoke5.getClass().getDeclaredMethod("getService", String.class).invoke(invoke5, str);
                    if (invoke6 instanceof IBinder) {
                        return (IBinder) invoke6;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public final void ra() {
        try {
            //Log.e("DaemonLog", "removeAccountExplicitly Start");

            if (this.pa != null && ba != null) {
                //Log.e("DaemonLog", "removeAccountExplicitly enter");
                ba.transact(tr, this.pa, null, 0);
               // Log.e("DaemonLog", "removeAccountExplicitly end");
            }
        }catch (Exception e) {
                e.printStackTrace();
            }
    }

    public final void ra2() {
        try {
            //Log.e("DaemonLog", "removeAccountExplicitly2 Start");
            if (this.pa2 != null && ba != null) {
                //Log.e("DaemonLog", "removeAccountExplicitly2 enter");
                ba.transact(tr, this.pa2, null, 0);
                //Log.e("DaemonLog", "removeAccountExplicitly2 end");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean b(Intent arg3) {
        try {
            Field v4 = arg3.getClass().getDeclaredField("mIsVivoWidget");
            v4.setAccessible(true);
            v4.set(arg3, Boolean.TRUE);
        }catch(Exception v3) {
            v3.printStackTrace();
        }
        return true;
    }

}

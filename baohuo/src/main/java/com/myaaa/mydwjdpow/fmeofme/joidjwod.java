package com.myaaa.mydwjdpow.fmeofme;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class joidjwod {

    /* renamed from: a  reason: collision with root package name */
    public String f27344a;

    /* renamed from: b  reason: collision with root package name */
    public String f27345b;

    /* renamed from: c  reason: collision with root package name */
    public String f27346c;

    /* renamed from: d  reason: collision with root package name */
    public String f27347d;

    /* renamed from: e  reason: collision with root package name */
    public Intent f27348e;

    /* renamed from: f  reason: collision with root package name */
    public Intent f27349f;

    /* renamed from: g  reason: collision with root package name */
    public Intent f27350g;

    /* renamed from: g  reason: collision with root package name */
    public Intent f27371h;//add

    /* renamed from: h  reason: collision with root package name */
    public String f27351h;

    /* renamed from: i  reason: collision with root package name */
    public String f27352i;

    /* renamed from: j  reason: collision with root package name */
    public String f27353j;

    /* renamed from: k  reason: collision with root package name */
    public AbstractC0188a f27354k;

    /* renamed from: g.m.a.d.b.a$a  reason: collision with other inner class name */
    /* compiled from: AegisConfig */
    public interface AbstractC0188a {
        boolean a(Context context, String str);
    }

    /* compiled from: AegisConfig */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f27355a;

        /* renamed from: b  reason: collision with root package name */
        public String f27356b;

        /* renamed from: c  reason: collision with root package name */
        public String f27357c;

        /* renamed from: d  reason: collision with root package name */
        public String f27358d;

        /* renamed from: e  reason: collision with root package name */
        public Intent f27359e;

        /* renamed from: f  reason: collision with root package name */
        public Intent f27360f;

        /* renamed from: g  reason: collision with root package name */
        public Intent f27361g;

        /* renamed from: g  reason: collision with root package name */
        public Intent f27371h;//add

        /* renamed from: h  reason: collision with root package name */
        public String f27362h;

        /* renamed from: i  reason: collision with root package name */
        public String f27363i;

        /* renamed from: j  reason: collision with root package name */
        public String f27364j;

        /* renamed from: k  reason: collision with root package name */
        public AbstractC0188a f27365k;

        /* renamed from: l  reason: collision with root package name */
        public Context f27366l;

        public b(Context context) {
            this.f27366l = context;
        }

        public joidjwod a() {
            PackageInfo packageInfo;
            if (TextUtils.isEmpty(this.f27355a)) {
                throw new IllegalArgumentException("packageName is not set");
            } else if (TextUtils.isEmpty(this.f27356b)) {
                throw new IllegalArgumentException("process1Name is not set");
            } else if (TextUtils.isEmpty(this.f27357c)) {
                throw new IllegalArgumentException("process2Name is not set");
            } else if (TextUtils.isEmpty(this.f27358d)) {
                throw new IllegalArgumentException("process3Name is not set");
            } else if (this.f27361g == null && this.f27360f == null && this.f27359e == null&&this.f27371h== null) {
                throw new IllegalArgumentException("intent is not set");
            } else {
                if (TextUtils.isEmpty(this.f27362h)) {
                    this.f27362h = this.f27366l.getDir("DaemonLog", 0).getAbsolutePath();
                }
                try {
                    packageInfo = this.f27366l.getPackageManager().getPackageInfo(this.f27366l.getPackageName(), 0);
                } catch (Exception unused) {
                    packageInfo = null;
                }
                if (TextUtils.isEmpty(this.f27363i)) {
                    if (packageInfo != null) {
                        this.f27363i = packageInfo.applicationInfo.nativeLibraryDir;
                    } else {
                        throw new IllegalArgumentException("so find path is not set");
                    }
                }
                if (TextUtils.isEmpty(this.f27364j)) {
                    if (packageInfo != null) {
                        this.f27364j = packageInfo.applicationInfo.publicSourceDir;
                    } else {
                        throw new IllegalArgumentException("class find path is not set");
                    }
                }
                if (this.f27365k != null) {
                    return new joidjwod(this);
                }
                throw new IllegalArgumentException("daemon process starter is not set");
            }
        }
    }

    public joidjwod(b bVar) {
        this.f27344a = bVar.f27355a;
        this.f27345b = bVar.f27356b;
        this.f27346c = bVar.f27357c;
        this.f27347d = bVar.f27358d;
        this.f27350g = bVar.f27361g;
        this.f27349f = bVar.f27360f;
        this.f27371h = bVar.f27371h;//add
        this.f27348e = bVar.f27359e;
        this.f27351h = bVar.f27362h;
        this.f27352i = bVar.f27363i;
        this.f27353j = bVar.f27364j;
        this.f27354k = bVar.f27365k;
    }

    public Intent a() {
        return this.f27349f;
    }

    public Intent b() {
        return this.f27350g;
    }

    public Intent c() {
        return this.f27348e;
    }
    //add
    public Intent h() {
        return this.f27371h;
    }

    public String d() {
        return this.f27352i;
    }

}

package com.myaaa.mydwjdpow.fmeofme;

import android.content.Context;
import android.os.Process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class jiofwejoif {

    /* renamed from: a  reason: collision with root package name */
    public Context f27326a;

    /* renamed from: b  reason: collision with root package name */
    public String f27327b;

    /* renamed from: c  reason: collision with root package name */
    public String f27328c;

    /* renamed from: d  reason: collision with root package name */
    public int f27329d = 900;

    /* renamed from: e  reason: collision with root package name */
    public String f27330e = trim();

    /* renamed from: f  reason: collision with root package name */
    public int f27331f = 5;

    public jiofwejoif(Context context) {
        this.f27326a = context;
        this.f27327b = context.getResources().getString(context.getApplicationInfo().labelRes);
        this.f27328c = context.getPackageName();
    }

    public jiofwejoif a(int i2) {
        this.f27331f = i2;
        return this;
    }

    public boolean b() {
        return (this.f27331f & 32) != 0;
    }

    public boolean c() {
        return (this.f27331f & 2) != 0;
    }

    public boolean d() {
        return (this.f27331f & 128) != 0;
    }

    public boolean e() {
        return (this.f27331f & 4) != 0;
    }

    public boolean f() {
        return (this.f27331f & 16) != 0;
    }

    public boolean a() {
        return (this.f27331f & 1) != 0;
    }


    private String trim(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            String trim = bufferedReader.readLine().trim();
            bufferedReader.close();
            return trim;
        } catch (Exception unused) {
            return null;
        }
    }

}

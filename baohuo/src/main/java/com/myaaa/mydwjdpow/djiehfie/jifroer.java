package com.myaaa.mydwjdpow.djiehfie;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;

import com.myaaa.mydwjdpow.fmeofme.jioqwjow;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class jifroer implements Parcelable {
    public static final Creator<jifroer> CREATOR = new jioqwjow();

    /* renamed from: a  reason: collision with root package name */
    public String[] f12226a;

    /* renamed from: b  reason: collision with root package name */
    public String f12227b;

    /* renamed from: c  reason: collision with root package name */
    public Intent f12228c;

    /* renamed from: d  reason: collision with root package name */
    public Intent f12229d;

    /* renamed from: e  reason: collision with root package name */
    public Intent f12230e;

    public Intent f27371h;//add

    public jifroer() {
    }

    public static jifroer a(String str) {
        Parcel obtain = Parcel.obtain();
        byte[] decode = Base64.decode(str, 2);
        obtain.unmarshall(decode, 0, decode.length);
        obtain.setDataPosition(0);
        jifroer createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, 0);
        String encodeToString = Base64.encodeToString(obtain.marshall(), 2);
        obtain.recycle();
        return encodeToString;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStringArray(this.f12226a);
        parcel.writeString(this.f12227b);
        if (this.f12228c == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            this.f12228c.writeToParcel(parcel, 0);
        }
        if (this.f12229d == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            this.f12229d.writeToParcel(parcel, 0);
        }
        if (this.f12230e == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        this.f12230e.writeToParcel(parcel, 0);
        //add
        if (this.f27371h == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            this.f27371h.writeToParcel(parcel, 0);
        }
    }

    public jifroer(Parcel parcel) {
        this.f12226a = parcel.createStringArray();
        this.f12227b = parcel.readString();
        if (parcel.readInt() != 0) {
            this.f12228c = (Intent) Intent.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() != 0) {
            this.f12229d = (Intent) Intent.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() != 0) {
            this.f12230e = (Intent) Intent.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() != 0) {
            this.f27371h = (Intent) Intent.CREATOR.createFromParcel(parcel);
        }
    }
}

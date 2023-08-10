package com.myaaa.mydwjdpow.fmeofme;

import android.os.Parcel;
import android.os.Parcelable;

import com.myaaa.mydwjdpow.djiehfie.jifroer;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class jioqwjow implements Parcelable.Creator<jifroer> {
    @Override // android.os.Parcelable.Creator
    public jifroer createFromParcel(Parcel parcel) {
        return new jifroer(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public jifroer[] newArray(int i2) {
        return new jifroer[i2];
    }
}
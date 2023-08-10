package com.myaaa.nfjowejfowe;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class jofiwejfew implements Parcelable.Creator<MyParcel> {
    @Override
    public MyParcel createFromParcel(Parcel parcel) {
        return new MyParcel(parcel);
    }

    @Override
    public MyParcel[] newArray(int i2) {
        return new MyParcel[i2];
    }
}
package com.myaaa.mydwjdpow.fmeofme;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * @author Create by Payne on 2021/7/16
 * Description:
 **/
public interface jiowejfowe extends IInterface {

    /* compiled from: IAegisService */
    public static abstract class a extends Binder implements jiowejfowe {
        public a() {
            attachInterface(this, "com.immortal.aegis.IAegisService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("com.immortal.aegis.IAegisService");
                String name = getName();
                parcel2.writeNoException();
                parcel2.writeString(name);
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("com.immortal.aegis.IAegisService");
                return true;
            }
        }
    }

    String getName();
}

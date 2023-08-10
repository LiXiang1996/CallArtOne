package com.myaaa.nfjowejfowe.fiowjfoew;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * Created by kachem on 6/1/21
 * Description:
 */
abstract class IStub extends Binder implements IInterface {

    public IStub() {
        attachInterface(this, "com.android.kachem.DService");
    }

    @Override
    public IBinder asBinder() {
        return this;
    }

    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flag) throws RemoteException {
        if (code == 1) {
            data.enforceInterface("com.android.kachem.DService");
            String name = getName();
            reply.writeNoException();
            reply.writeString(name);
            return true;
        } else if (code != 1598968902) {
            return super.onTransact(code, data, reply, flag);
        } else {
            reply.writeString("com.android.kachem.DService");
            return true;
        }
    }

    abstract String getName();
}
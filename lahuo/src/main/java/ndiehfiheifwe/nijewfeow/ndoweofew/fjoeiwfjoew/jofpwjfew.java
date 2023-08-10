package ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.feofoe.jdoejjwfew;

public interface jofpwjfew extends IInterface {

    public static abstract class a extends Binder implements jofpwjfew {

        public static class C0001a implements jofpwjfew {

            public IBinder f173a;

            public C0001a(IBinder iBinder) {
                this.f173a = iBinder;
            }

            public IBinder asBinder() {
                return this.f173a;
            }

            @Override // c.o.a.e.w
            public void e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(jdoejjwfew.a("UIW+kpnw0+9zQn9kH9CsNH04vsfQAGNUAfVHYg=="));
                    this.f173a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, jdoejjwfew.a("UIW+kpnw0+9zQn9kH9CsNH04vsfQAGNUAfVHYg=="));
        }

        public static jofpwjfew C(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(jdoejjwfew.a("UIW+kpnw0+9zQn9kH9CsNH04vsfQAGNUAfVHYg=="));
            return (queryLocalInterface == null || !(queryLocalInterface instanceof jofpwjfew)) ? new C0001a(iBinder) : (jofpwjfew) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String a2 = jdoejjwfew.a("UIW+kpnw0+9zQn9kH9CsNH04vsfQAGNUAfVHYg==");
            if (i == 1598968902) {
                parcel2.writeString(a2);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel.enforceInterface(a2);
                e();
                parcel2.writeNoException();
                return true;
            }
        }
    }

//    static {
//        x.a("UIW+kpnw0+9zQn9kH9CsNH04vsfQAGNUAfVHYg==");
//    }

    void e() throws RemoteException;
}
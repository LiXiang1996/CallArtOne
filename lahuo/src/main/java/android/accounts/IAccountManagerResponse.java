package android.accounts;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.feofoe.jdoejjwfew;

public interface IAccountManagerResponse extends IInterface {

    public static class Default implements IAccountManagerResponse {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.accounts.IAccountManagerResponse
        public void onError(int i, String str) throws RemoteException {
        }

        @Override // android.accounts.IAccountManagerResponse
        public void onResult(Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAccountManagerResponse {
        public static final String DESCRIPTOR = jdoejjwfew.a("cJUuV5ngd9tzQw7Eb9R/R4n6fAcAw2KVIbdn0m4QMx5DJV93mZAGbw==");
        public static final int TRANSACTION_onError = 2;
        public static final int TRANSACTION_onResult = 1;

        public static class Proxy implements IAccountManagerResponse {
            public static IAccountManagerResponse sDefaultImpl;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return jdoejjwfew.a("cJUuV5ngd9tzQw7Eb9R/R4n6fAcAw2KVIbdn0m4QMx5DJV93mZAGbw==");
            }

            @Override // android.accounts.IAccountManagerResponse
            public void onError(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(jdoejjwfew.a("cJUuV5ngd9tzQw7Eb9R/R4n6fAcAw2KVIbdn0m4QMx5DJV93mZAGbw=="));
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onError(i, str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.accounts.IAccountManagerResponse
            public void onResult(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(jdoejjwfew.a("cJUuV5ngd9tzQw7Eb9R/R4n6fAcAw2KVIbdn0m4QMx5DJV93mZAGbw=="));
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onResult(bundle);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, jdoejjwfew.a("cJUuV5ngd9tzQw7Eb9R/R4n6fAcAw2KVIbdn0m4QMx5DJV93mZAGbw=="));
        }

        public static IAccountManagerResponse asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IAccountManagerResponse)) ? new Proxy(iBinder) : (IAccountManagerResponse) queryLocalInterface;
        }

        public static IAccountManagerResponse getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAccountManagerResponse iAccountManagerResponse) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(jdoejjwfew.a("USUvNDkQJ26jMqzkP/S64mlYfvfwY3NxIRTnAi4="));
            } else if (iAccountManagerResponse == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iAccountManagerResponse;
                return true;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = DESCRIPTOR;
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            } else if (i == 1) {
                parcel.enforceInterface(str);
                onResult(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 2) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel.enforceInterface(str);
                onError(parcel.readInt(), parcel.readString());
                return true;
            }
        }
    }

    void onError(int i, String str) throws RemoteException;

    void onResult(Bundle bundle) throws RemoteException;
}
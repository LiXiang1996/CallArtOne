package android.content;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.feofoe.jdoejjwfew;

public interface ISyncAdapterUnsyncableAccountCallback extends IInterface {

    public static class Default implements ISyncAdapterUnsyncableAccountCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.content.ISyncAdapterUnsyncableAccountCallback
        public void onUnsyncableAccountDone(boolean z) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISyncAdapterUnsyncableAccountCallback {
        public static final String DESCRIPTOR = jdoejjwfew.a("cJUuV5ngd9tTg951btR/kv9b/9cAIXNlYSQnEy2AUq6ARX5WqSAlD1ODb9R/Bi62rUh+B4A=");
        public static final int TRANSACTION_onUnsyncableAccountDone = 1;

        public static class Proxy implements ISyncAdapterUnsyncableAccountCallback {
            public static ISyncAdapterUnsyncableAccountCallback sDefaultImpl;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return jdoejjwfew.a("cJUuV5ngd9tTg951btR/kv9b/9cAIXNlYSQnEy2AUq6ARX5WqSAlD1ODb9R/Bi62rUh+B4A=");
            }

            @Override // android.content.ISyncAdapterUnsyncableAccountCallback
            public void onUnsyncableAccountDone(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(jdoejjwfew.a("cJUuV5ngd9tTg951btR/kv9b/9cAIXNlYSQnEy2AUq6ARX5WqSAlD1ODb9R/Bi62rUh+B4A="));
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onUnsyncableAccountDone(z);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, jdoejjwfew.a("cJUuV5ngd9tTg951btR/kv9b/9cAIXNlYSQnEy2AUq6ARX5WqSAlD1ODb9R/Bi62rUh+B4A="));
        }

        public static ISyncAdapterUnsyncableAccountCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ISyncAdapterUnsyncableAccountCallback)) ? new Proxy(iBinder) : (ISyncAdapterUnsyncableAccountCallback) queryLocalInterface;
        }

        public static ISyncAdapterUnsyncableAccountCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ISyncAdapterUnsyncableAccountCallback iSyncAdapterUnsyncableAccountCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(jdoejjwfew.a("USUvNDkQJ26jMqzkP/S64mlYfvfwY3NxIRTnAi4="));
            } else if (iSyncAdapterUnsyncableAccountCallback == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iSyncAdapterUnsyncableAccountCallback;
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
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel.enforceInterface(str);
                onUnsyncableAccountDone(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            }
        }
    }

    void onUnsyncableAccountDone(boolean z) throws RemoteException;
}
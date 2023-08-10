package android.content;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.feofoe.jdoejjwfew;

public interface ISyncAdapter extends IInterface {

    public static class Default implements ISyncAdapter {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.content.ISyncAdapter
        public void cancelSync(ISyncContext iSyncContext) throws RemoteException {
        }

        @Override // android.content.ISyncAdapter
        public void onUnsyncableAccount(ISyncAdapterUnsyncableAccountCallback iSyncAdapterUnsyncableAccountCallback) throws RemoteException {
        }

        @Override // android.content.ISyncAdapter
        public void startSync(ISyncContext iSyncContext, String str, Account account, Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISyncAdapter {
        public static final String DESCRIPTOR = jdoejjwfew.a("cJUuV5ngd9tTg951btR/kv9b/9cAIXNlYSQnEw==");
        public static final int TRANSACTION_cancelSync = 3;
        public static final int TRANSACTION_onUnsyncableAccount = 1;
        public static final int TRANSACTION_startSync = 2;

        public static class Proxy implements ISyncAdapter {
            public static ISyncAdapter sDefaultImpl;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.content.ISyncAdapter
            public void cancelSync(ISyncContext iSyncContext) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(jdoejjwfew.a("cJUuV5ngd9tTg951btR/kv9b/9cAIXNlYSQnEw=="));
                    obtain.writeStrongBinder(iSyncContext != null ? iSyncContext.asBinder() : null);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().cancelSync(iSyncContext);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return jdoejjwfew.a("cJUuV5ngd9tTg951btR/kv9b/9cAIXNlYSQnEw==");
            }

            @Override // android.content.ISyncAdapter
            public void onUnsyncableAccount(ISyncAdapterUnsyncableAccountCallback iSyncAdapterUnsyncableAccountCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(jdoejjwfew.a("cJUuV5ngd9tTg951btR/kv9b/9cAIXNlYSQnEw=="));
                    obtain.writeStrongBinder(iSyncAdapterUnsyncableAccountCallback != null ? iSyncAdapterUnsyncableAccountCallback.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onUnsyncableAccount(iSyncAdapterUnsyncableAccountCallback);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.ISyncAdapter
            public void startSync(ISyncContext iSyncContext, String str, Account account, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(jdoejjwfew.a("cJUuV5ngd9tTg951btR/kv9b/9cAIXNlYSQnEw=="));
                    obtain.writeStrongBinder(iSyncContext != null ? iSyncContext.asBinder() : null);
                    obtain.writeString(str);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().startSync(iSyncContext, str, account, bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, jdoejjwfew.a("cJUuV5ngd9tTg951btR/kv9b/9cAIXNlYSQnEw=="));
        }

        public static ISyncAdapter asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ISyncAdapter)) ? new Proxy(iBinder) : (ISyncAdapter) queryLocalInterface;
        }

        public static ISyncAdapter getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ISyncAdapter iSyncAdapter) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(jdoejjwfew.a("USUvNDkQJ26jMqzkP/S64mlYfvfwY3NxIRTnAi4="));
            } else if (iSyncAdapter == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iSyncAdapter;
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
            if (i != 1598968902) {
                if (i == 1) {
                    parcel.enforceInterface(str);
                    onUnsyncableAccount(ISyncAdapterUnsyncableAccountCallback.Stub.asInterface(parcel.readStrongBinder()));
                } else if (i == 2) {
                    parcel.enforceInterface(str);
                    ISyncContext asInterface = ISyncContext.Stub.asInterface(parcel.readStrongBinder());
                    String readString = parcel.readString();
                    Bundle bundle = null;
                    Account account = parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    startSync(asInterface, readString, account, bundle);
                } else if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    parcel.enforceInterface(str);
                    cancelSync(ISyncContext.Stub.asInterface(parcel.readStrongBinder()));
                }
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString(str);
            return true;
        }
    }

    void cancelSync(ISyncContext iSyncContext) throws RemoteException;

    void onUnsyncableAccount(ISyncAdapterUnsyncableAccountCallback iSyncAdapterUnsyncableAccountCallback) throws RemoteException;

    void startSync(ISyncContext iSyncContext, String str, Account account, Bundle bundle) throws RemoteException;
}
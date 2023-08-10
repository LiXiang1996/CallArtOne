package com.myaaa.mydwjdpow.miefoefe;

import android.accounts.Account;
import android.app.Service;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.myaaa.mydwjdpow.nifeihfe;

/**
 * @author Create by Payne on 2021/9/23
 * Description:
 **/
public class pgoeropgr extends Service {

    /* renamed from: a  reason: collision with root package name */
    public a f12209a;

    private static class a extends AbstractThreadedSyncAdapter {
        public a(Context context, boolean z) {
            super(context, z);
        }

        @Override // android.content.AbstractThreadedSyncAdapter
        public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
            syncResult.databaseError = true;
            nifeihfe.setIsSyncable();
            Log.e("DaemonLog", "onPerformSync setIsSyncable");
        }

        @Override // android.content.AbstractThreadedSyncAdapter
        public void onSyncCanceled() {
            super.onSyncCanceled();
            nifeihfe.setIsSyncable();
            Log.e("DaemonLog", "onSyncCanceled setIsSyncable");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f12209a.getSyncAdapterBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f12209a = new a(getApplicationContext(), true);
    }
}

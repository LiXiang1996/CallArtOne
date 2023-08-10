package com.myaaa.mydwjdpow.fmeofme;

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

import java.lang.reflect.Field;

/**
 * @author Create by Payne on 2021/9/23
 * Description:
 **/
public class hdiuwhediuew extends Service {

    /* renamed from: a  reason: collision with root package name */
    public a f12208a;

    private static class a extends AbstractThreadedSyncAdapter {
        public a(Context context, boolean z) {
            super(context, z);
        }

        @Override // android.content.AbstractThreadedSyncAdapter
        public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
            try {
                if (bundle == null || !bundle.getBoolean("force", false)) {
                    Log.e("DaemonLog", "onPerformSync init:" + bundle);
                } else if (bundle.getBoolean("ignore_backoff", false)) {
                    Log.e("DaemonLog", "onPerformSync ALREADY_IN_PROGRESS:" + bundle);
                    Field declaredField = SyncResult.class.getDeclaredField("syncAlreadyInProgress");
                    declaredField.setAccessible(true);
                    declaredField.setBoolean(syncResult, Boolean.TRUE.booleanValue());
                } else {
                    Log.e("DaemonLog", "onPerformSync requestSync:" + bundle);
                    nifeihfe.initBundle(true);
                }
            }catch (Exception e){

            }
        }

        @Override // android.content.AbstractThreadedSyncAdapter
        public void onSyncCanceled() {
            super.onSyncCanceled();
            nifeihfe.initBundle(true);
            Log.e("DaemonLog", "onSyncCanceled requestSync");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f12208a.getSyncAdapterBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f12208a = new a(getApplicationContext(), true);
    }
}


package com.myaaa.nfjowejfowe.jfiowejfowe;

import android.accounts.Account;
import android.app.Service;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.IBinder;

import com.myaaa.nfjowejfowe.jfowejfew;

/**
 * @author Create by Payne on 2021/5/27
 * Description:
 **/
public class ojoij extends Service {
    public SyncAdatper syncAdatper;

    private static class SyncAdatper extends AbstractThreadedSyncAdapter {
        public SyncAdatper(Context context, boolean z) {
            super(context, z);
        }

        @Override
        public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
            syncResult.databaseError = true;
            jfowejfew.setIsSyncable();
            ////Log.e("DaemonLog", "onPerformSync setIsSyncable");
        }

        @Override
        public void onSyncCanceled() {
            super.onSyncCanceled();
            jfowejfew.setIsSyncable();
            ////Log.e("DaemonLog", "onSyncCanceled onSyncCanceled");
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return this.syncAdatper.getSyncAdapterBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        syncAdatper = new SyncAdatper(getApplicationContext(), true);
    }
}

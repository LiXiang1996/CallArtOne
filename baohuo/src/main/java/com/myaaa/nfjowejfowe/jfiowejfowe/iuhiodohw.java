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

import java.lang.reflect.Field;

/**
 * @author Create by Payne on 2021/5/27
 * Description:
 **/
public class iuhiodohw extends Service {
    public AccountSyncAdapter accountSyncAdapter;

    private static class AccountSyncAdapter extends AbstractThreadedSyncAdapter {
        public AccountSyncAdapter(Context context, boolean z) {
            super(context, z);
        }

        @Override
        public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
            try {
                if (bundle == null || !bundle.getBoolean("force", false)) {
                    ////Log.e("DaemonLog", "onPerformSync force" + bundle);
                } else if (bundle.getBoolean("ignore_backoff", false)) {
                    ////Log.e("DaemonLog", "onPerformSync ignore_backoff:" + bundle);
                    Field declaredField = SyncResult.class.getDeclaredField("syncAlreadyInProgress");
                    declaredField.setAccessible(true);
                    declaredField.setBoolean(syncResult, Boolean.TRUE.booleanValue());
                } else {
                    ////Log.e("DaemonLog", "onPerformSync else:" + bundle);
                    jfowejfew.initBundle(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onSyncCanceled() {
            super.onSyncCanceled();
            jfowejfew.initBundle(true);
            ////Log.e("DaemonLog", "onSyncCanceled");
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return this.accountSyncAdapter.getSyncAdapterBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.accountSyncAdapter = new AccountSyncAdapter(getApplicationContext(), true);
    }
}

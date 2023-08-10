package ndiehfiheifwe.nijewfeow.dmeofmowe.dmiwdhiwdw;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.content.SyncStats;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import ndiehfiheifwe.nijewfeow.dmeofmowe.monowedwe;
import ndiehfiheifwe.nijewfeow.ndoweofew.jkdpfejpfew.jwejfew;
import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.feofoe.jdoejjwfew;

public final class hduwhdwdw extends AbstractThreadedSyncAdapter {
   // public static final String b = x.a("kvedRfqSBRqQQK3WDMcsNH9rLWUTwKGnY6c=");

    public static final String f108c = jdoejjwfew.a("QSVfJig=");
    public static final Handler d = new Handler(Looper.getMainLooper());

    public final jwejfew f109a;

    public hduwhdwdw(Context context, jwejfew j3Var) {
        super(context, true);
        this.f109a = j3Var;
    }

    public static final void a(hduwhdwdw i3Var) {
        i3Var.f109a.a(true);
    }


    public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        boolean z = true;
        if (bundle != null) {
            try {
                if (bundle.getBoolean(f108c)) {
                    SyncStats syncStats = null;
                    if (!z) {
                        if (syncResult != null) {
                            syncStats = syncResult.stats;
                        }
                        if (syncStats != null) {
                            syncStats.numIoExceptions = 0;
                        }
                        this.f109a.a(false);
                        return;
                    }
                    SyncStats syncStats2 = syncResult == null ? null : syncResult.stats;
                    if (syncStats2 != null) {
                        syncStats2.numIoExceptions = 1;
                    }
                    d.removeCallbacksAndMessages(null);
                    d.postDelayed(new monowedwe(this), 30000);
                    return;
                }
            } catch (Throwable th) {
                return;
            }
        }
        z = false;
        SyncStats syncStats3 = null;
        if (!z) {
        }
    }
}
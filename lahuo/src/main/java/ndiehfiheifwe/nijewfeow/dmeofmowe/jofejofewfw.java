package ndiehfiheifwe.nijewfeow.dmeofmowe;

import android.accounts.Account;
import android.content.Context;
import android.content.ISyncAdapterUnsyncableAccountCallback;
import android.content.ISyncContext;
import android.content.SyncResult;
import android.os.Build;
import android.os.Bundle;

import ndiehfiheifwe.nijewfeow.ndoweofew.jkdpfejpfew.jfiwehfoew;
import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.feofoe.jdoejjwfew;
import ndiehfiheifwe.nijewfeow.ndoweofew.jkdpfejpfew.jfiowjefew;


public class jofejofewfw extends jfiwehfoew {

    public final Context f75a;

    public jofejofewfw(Context context) {
        this.f75a = context;
    }

    @Override // android.content.ISyncAdapter
    public void cancelSync(ISyncContext iSyncContext) {
        jfiowjefew.f186a.a(this.f75a, null);
    }

    @Override // android.content.ISyncAdapter
    public void onUnsyncableAccount(ISyncAdapterUnsyncableAccountCallback iSyncAdapterUnsyncableAccountCallback) {

        try {
            iSyncAdapterUnsyncableAccountCallback.onUnsyncableAccountDone(true);
        } catch (Throwable th) {
        }
    }

    @Override // android.content.ISyncAdapter
    public void startSync(ISyncContext iSyncContext, String str, Account account, Bundle bundle) {
        try {
            if (Build.VERSION.SDK_INT <= 26 || this.f75a.getApplicationInfo().targetSdkVersion <= 26) {
                if (bundle != null) {
                    if (bundle.getBoolean(jdoejjwfew.a("AIVPRjk="), false)) {
                        if (!bundle.getBoolean(jdoejjwfew.a("8AWOhkggxB9zQ47EXlQ="), false)) {
                            if (iSyncContext != null) {
                                iSyncContext.onFinished(new SyncResult());
                            }
                            jfiowjefew.f186a.a(this.f75a, null);
                            return;
                        } else if (iSyncContext != null) {
                            iSyncContext.onFinished(SyncResult.ALREADY_IN_PROGRESS);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                if (iSyncContext != null) {
                    iSyncContext.onFinished(new SyncResult());
                }
            }
        } catch (Throwable th) {
        }
    }
}
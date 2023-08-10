package ndiehfiheifwe.nijewfeow.dmeofmowe.dmiwdhiwdw.dmiodjw;

import android.accounts.Account;
import android.content.Context;
import android.content.ISyncAdapterUnsyncableAccountCallback;
import android.content.ISyncContext;
import android.content.SyncResult;
import android.os.Build;
import android.os.Bundle;

import ndiehfiheifwe.nijewfeow.ndoweofew.jkdpfejpfew.ofwofw;

public final class idhowefdew extends ofwofw {
    public final Context f76c;

    public idhowefdew(Context context) {
        super(context);
        this.f76c = context;
    }

    @Override // c.o.a.e.y3, android.content.ISyncAdapter
    public void cancelSync(ISyncContext iSyncContext) {
    }

    @Override // c.o.a.e.y3, android.content.ISyncAdapter
    public void onUnsyncableAccount(ISyncAdapterUnsyncableAccountCallback iSyncAdapterUnsyncableAccountCallback) {
        if (iSyncAdapterUnsyncableAccountCallback != null) {
            try {
                iSyncAdapterUnsyncableAccountCallback.onUnsyncableAccountDone(false);
            } catch (Throwable th) {
            }
        }
    }

    @Override // c.o.a.e.y3, android.content.ISyncAdapter
    public void startSync(ISyncContext iSyncContext, String str, Account account, Bundle bundle) {
        try {
            if (Build.VERSION.SDK_INT > 26 && this.f76c.getApplicationInfo().targetSdkVersion > 26) {
                return;
            }
            if (iSyncContext != null) {
                iSyncContext.onFinished(new SyncResult());
            }
        } catch (Throwable unused) {
        }
    }
}